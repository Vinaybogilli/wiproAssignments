package com.wipro.customexception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class GlobalExeptionHandler {
	
	@ExceptionHandler(BOOKING_NOT_FOUND_EXCEPTION.class)
	public ResponseEntity<ErrorMessage> handleMenuNotFoundException(BOOKING_NOT_FOUND_EXCEPTION ex)
	{
		ErrorMessage errrorMessage=new ErrorMessage(ex.getMessage(),"BOOKING_NOT_FOUND_EXCEPTON");
		return new ResponseEntity<>(errrorMessage,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MENU_NOT_FOUND_EXCEPTION.class)
	public ResponseEntity<ErrorMessage> handleMenuNotFoundException(MENU_NOT_FOUND_EXCEPTION ex)
	{
		ErrorMessage errrorMessage=new ErrorMessage(ex.getMessage(),"MENU_NOT_FOUND_EXCEPTON");
		return new ResponseEntity<>(errrorMessage,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(RES_NOT_FOUND_EXCEPTION.class)
	public ResponseEntity<ErrorMessage> handleResNotFoundException(RES_NOT_FOUND_EXCEPTION ex)
	{
		ErrorMessage errrorMessage=new ErrorMessage(ex.getMessage(),"RES_NOT_FOUND_EXCEPTON");
		return new ResponseEntity<>(errrorMessage,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PRICE_NOT_FOUND_EXCEPTION.class)
	public ResponseEntity<ErrorMessage> handleResNotFoundException(PRICE_NOT_FOUND_EXCEPTION ex)
	{
		ErrorMessage errrorMessage=new ErrorMessage(ex.getMessage(),"PRICE_NOT_FOUND_EXCEPTION");
		return new ResponseEntity<>(errrorMessage,HttpStatus.NOT_FOUND);
	}


}
