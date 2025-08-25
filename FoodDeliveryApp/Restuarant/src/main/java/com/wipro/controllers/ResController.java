package com.wipro.controllers;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.wipro.entities.Restuarant;
import com.wipro.service.ResService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/restuarant")
public class ResController {
	
	private final ResService resservice;

	@PostMapping("/addrestuarnt")
	public Restuarant createres(@RequestBody Restuarant restuarant)
	{
		
		return resservice.createres(restuarant);
	}
	
	@GetMapping("/getallrestuarnt")
	public Page<Restuarant> getRes(Pageable pageable)
	{
		return resservice.getRes(pageable);
	}
	
	@GetMapping("/getResById/{id}")
	public Restuarant getResById(@PathVariable Long id)
	{
		return resservice.getResById(id);
	}
	
	@DeleteMapping("/deleterestuarant/{id}")
	public void  deleteRes(@PathVariable Long id)
	{
		resservice.deleteres(id);
	}
	
	@GetMapping("/getResIdByName/{name}")
	public Long getResIdByName(@PathVariable String name)
	{
		return resservice.getResIdByName(name);
	}
	
}
