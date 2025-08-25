package com.wipro.controller;




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.entities.Booking;
import com.wipro.service.BookingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/booking")
public class BookingController {
	
	public final BookingService bookingservice;
	
	@PostMapping("/Bookingorder")
	public Booking orderingFood(@RequestBody Booking booking)
	{
		return bookingservice.orderFood(booking);
	}
	
	@GetMapping("/getOrders")
	public Page<Booking> getOrders(Pageable pageable)
	{
		return bookingservice.getorders(pageable);
	}
	
	@GetMapping("/getOrderById/{id}")
	public Booking getOrderById(@PathVariable Long id) 
	{
		return bookingservice.getOrderById(id);
	}
	
	@PatchMapping("/updateOrderById/{id}")
	public Booking updateOrderById(@PathVariable Long id , @RequestBody Booking booking)
	{
		return bookingservice.updateOrderById(id,booking);
	}
	
	@GetMapping("/getAmount/{id}")
	public Integer getAMount(@PathVariable Long id){
	  return bookingservice.getAmount(id);
	}
	
	@GetMapping("/findOrderById/{id}")
	public Boolean findOrderById(@PathVariable Long id) {
		return bookingservice.findOrderById(id);
	}
	
	@GetMapping("/getPrice/{id}")
	public Integer getPrice(@PathVariable Long id)
	{
		return bookingservice.getPrice(id);
	}
	
	@GetMapping("/getCustomerEmail/{id}")
	public String getCustomerEmail(@PathVariable Long id)
	{
		return bookingservice.getCustomerEmail(id);
	}
	

}
