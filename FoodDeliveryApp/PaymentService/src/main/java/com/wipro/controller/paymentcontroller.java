package com.wipro.controller;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.entities.Payment;
import com.wipro.service.PaymentService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/payment")
public class paymentcontroller {
	
	private final PaymentService paymentservice;
	
	    @GetMapping("/PlaceOrder/{id}")
		public Payment PlaceOrder(@PathVariable Long id)
		{
			return paymentservice.placeOrder(id);
		}
	    
	    @PatchMapping("/updateOrderStatus/{id}")
	    public Payment updateStatus(@PathVariable Long id,@RequestBody Payment newstatus)
	    {
	    	return paymentservice.updateStatus(id,newstatus);
	    }
	    
	    @GetMapping("/getAllOrders")
	    public Page<Payment> getAllOrders(Pageable pageable)
	    {
	    	return paymentservice.getAllOrders(pageable);
	    }
	
}
