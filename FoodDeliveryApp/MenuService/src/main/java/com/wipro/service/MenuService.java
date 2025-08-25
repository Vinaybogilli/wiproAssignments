package com.wipro.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wipro.customexception.MENU_NOT_FOUND_EXCEPTION;
import com.wipro.entities.Menu;
import com.wipro.feign.MenuInterface;

import com.wipro.repo.Menurepo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class MenuService {

	private final Menurepo menurepo;
	private final MenuInterface menuinterface;
	
	public Menu createmenu(Menu menu) {
		log.info("menu is saving");
		return menurepo.save(menu);
	}

	public Page<Menu> getallitems(Pageable pageable) {
		
		return menurepo.findAll(pageable);
	}

	public List<Menu> getItemsByResId(Long resId) {
	        return menurepo.findByResId(resId);
	}

	public List<Menu> getItemsByResName(String name) {
		
		Long resid = menuinterface.getResIdByName(name);
		return menurepo.findByResId(resid);
	}

	public Menu updateMenuById(Long id,Menu menu) {
		
		Menu existing = menurepo.findById(id)
		        .orElseThrow(() -> new MENU_NOT_FOUND_EXCEPTION("Menu not found with id: " + id));
		
		if(menu.getItemName() != null) {
			existing.setItemName(menu.getItemName());
		}
		
		if(menu.getCategory() != null) {
			existing.setCategory(menu.getCategory());
		}
		
		if(menu.getPrice() != null && menu.getPrice() != 0) {
			existing.setPrice(menu.getPrice());
		}
		
		if(menu.getResId() != null) {
			existing.setResId(menu.getResId());
		}
		
		
		return menurepo.save(existing);
	}

	public Menu addItemsByResName(String name, Menu menu) {
		Long resid = menuinterface.getResIdByName(name);
		menu.setResId(resid);
		return menurepo.save(menu);
	}

	public Integer givePrice(String name) {
		Menu menu = menurepo.findByitemName(name);
		
		return menu.getPrice();
	}


}
