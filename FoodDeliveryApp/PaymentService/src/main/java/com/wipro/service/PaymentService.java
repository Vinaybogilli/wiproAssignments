package com.wipro.service;

import java.time.LocalDateTime;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wipro.customexception.BOOKING_NOT_FOUND_EXCEPTION;
import com.wipro.entities.Notification;
import com.wipro.entities.Payment;
import com.wipro.feign.Notificationfeign;
import com.wipro.feign.PaymentFeign;
import com.wipro.repo.paymentrepo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class PaymentService {
	
	private final paymentrepo payrepo;
	private final PaymentFeign payfeign;
	private final Notificationfeign nfeign;
	

	public Payment placeOrder(Long id) {
	    Boolean bookingExists = payfeign.findOrderById(id);
	    Integer price=payfeign.getPrice(id); 
	    String customeremail=payfeign.getCustomerEmail(id);
	    
	    if (Boolean.TRUE.equals(bookingExists)) {
	        Payment payment = new Payment();
	        payment.setDateAndTime(LocalDateTime.now());
	        payment.setOrderStatus("order placed");
	        payment.setPrice(price);
	        payment.setPaymentMethod("cod");
	        
	        Notification note=new Notification();
		    note.setToEmail(customeremail);
		    note.setMessage("Order Placed success");
		    note.setSubject("about order");
		    
		    nfeign.sendNotification(note);

	        log.info("order saved");
	        return payrepo.save(payment);
	    } else {
	        throw new BOOKING_NOT_FOUND_EXCEPTION("Booking not found for id: " + id);
	    }
	}


	public Payment updateStatus(Long id, Payment newstatus) {
		Payment existing=payrepo.findById(id).orElseThrow(() -> new BOOKING_NOT_FOUND_EXCEPTION("Booking not found with id: " + id));
		existing.setOrderStatus(newstatus.getOrderStatus());
		
		
		String customeremail=payfeign.getCustomerEmail(id);
		Notification note=new Notification();
	    note.setToEmail(customeremail);
	    note.setMessage(newstatus.getOrderStatus());
	    note.setSubject("about order");
	    
	    nfeign.sendNotification(note);
	    
	    
		return payrepo.save(existing);
	}


	public Page<Payment> getAllOrders(Pageable pageable) {
		
		return payrepo.findAll(pageable);
	}


}
