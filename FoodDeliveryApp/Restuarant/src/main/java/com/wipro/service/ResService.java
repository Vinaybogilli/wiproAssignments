package com.wipro.service;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wipro.customexception.RES_NOT_FOUND_EXCEPTION;
import com.wipro.entities.Restuarant;
import com.wipro.repo.ResRepo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class ResService {

	private final  ResRepo resrepo;
	public Restuarant createres(Restuarant restuarant) {
		
		return resrepo.save(restuarant);
	}
	public Page<Restuarant> getRes(Pageable pageable) {
		
		return resrepo.findAll(pageable);
	}
	public void deleteres(Long id) {
		log.warn("Deleting restaurant with ID: {}", id);
		 resrepo.deleteById(id);
		
	}
	
	public Long getResIdByName(String name) {
		
		Long id=resrepo.findIdByName(name);
		
		if (id == null) {
	        throw new RES_NOT_FOUND_EXCEPTION("Restaurant not found with name: " + name);
	    }
		return id;
	}
	public Restuarant getResById(Long id) {
		return resrepo.findById(id)
                .orElseThrow(() -> new RES_NOT_FOUND_EXCEPTION("Restaurant not found with id: " + id));
	}

}
