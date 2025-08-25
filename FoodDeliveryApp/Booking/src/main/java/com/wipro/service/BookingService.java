package com.wipro.service;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wipro.customexception.BOOKING_NOT_FOUND_EXCEPTION;
import com.wipro.customexception.PRICE_NOT_FOUND_EXCEPTION;
import com.wipro.customexception.RES_NOT_FOUND_EXCEPTION;
import com.wipro.entities.Booking;
import com.wipro.entities.Notification;
import com.wipro.feign.BookingFeign;
import com.wipro.feign.Mfeign;
import com.wipro.feign.Notificationfeign;
import com.wipro.repo.BookingRepo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@AllArgsConstructor
@Slf4j
public class BookingService {
    
	private final BookingRepo bookingrepo;
	private final BookingFeign bfeign;
	private final Mfeign mfeign;
	private final Notificationfeign nfeign;
	
	
	public Booking orderFood(Booking booking) {
	    
	    Long resid = bfeign.getResIdByName(booking.getResName());
	    if (resid == null) {
	        throw new RES_NOT_FOUND_EXCEPTION("Restaurant not found: " + booking.getResName());
	    }

	   
	    Integer quantity = booking.getQuantity();
	    Integer price = mfeign.getPriceByName(booking.getItemName());
	    
	    Notification note=new Notification();
	    note.setToEmail(booking.getCustomerEmail());
	    note.setMessage("Order saved success");
	    note.setSubject("about order");
	    
	    nfeign.sendNotification(note);

	    if (quantity == null || price == null) {
	        throw new PRICE_NOT_FOUND_EXCEPTION("Price or quantity is missing for item: " + booking.getItemName());
	    }

	    
	    booking.setPrice(price * quantity);

	    
	    log.info("order saved success");
	    return bookingrepo.save(booking);
	}


	public Page<Booking> getorders(Pageable pageable) {
		
		return bookingrepo.findAll(pageable);
	}

	public Booking getOrderById(Long id) {
		
		
		return bookingrepo.findById(id).orElseThrow(() -> new BOOKING_NOT_FOUND_EXCEPTION("Booking not found"));
	}

	public Booking updateOrderById(Long id, Booking booking) {
		
		Booking existing=bookingrepo.findById(id)
				.orElseThrow(() -> new BOOKING_NOT_FOUND_EXCEPTION("Booking not found with id: " + id));;
		
				if (booking.getCustomerName() != null) {
			        existing.setCustomerName(booking.getCustomerName());
			    }
			    if (booking.getPhone() != null) {
			        existing.setPhone(booking.getPhone());
			    }
			    if (booking.getResName() != null) {
			        existing.setResName(booking.getResName());
			    }
			    if (booking.getItemName() != null) {
			        existing.setItemName(booking.getItemName());
			    }
			    if (booking.getQuantity() != null) {
			        existing.setQuantity(booking.getQuantity());
			    }
			    

			    return bookingrepo.save(existing);
	}

	public Integer getAmount(Long id) {
	    Booking booking = bookingrepo.findById(id)
	        .orElseThrow(() -> new BOOKING_NOT_FOUND_EXCEPTION("Booking not found with id: " + id));

	    Integer quantity = booking.getQuantity();
	    Integer price = mfeign.getPriceByName(booking.getItemName());

	    if (quantity == null || price == null) {
	        throw new PRICE_NOT_FOUND_EXCEPTION("Price or quantity is missing for booking id: " + id);
	    }

	    return price * quantity;
	}

	public Boolean findOrderById(Long id) {
	    return bookingrepo.existsById(id);
	}


	public Integer getPrice(Long id) {
		Booking booking = bookingrepo.findById(id)
		        .orElseThrow(() -> new BOOKING_NOT_FOUND_EXCEPTION("Booking not found with id: " + id));
		
		Integer price=booking.getPrice();
		return price;
	}


	public String getCustomerEmail(Long id) {
		Booking booking = bookingrepo.findById(id)
		        .orElseThrow(() -> new BOOKING_NOT_FOUND_EXCEPTION("Booking not found with id: " + id));
		return booking.getCustomerEmail();
	}
    
	
	
}
