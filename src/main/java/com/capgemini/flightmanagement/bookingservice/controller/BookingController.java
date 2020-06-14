 /****************************************************************************************************************************
 - File Name        : BookingController
 - Author           : Trisha Mazumdar
 - Creation Date    : 11-06-2020
 - Description      : This is an end point controller to consume Booking Services.
  ****************************************************************************************************************************/ 

package com.capgemini.flightmanagement.bookingservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.flightmanagement.bookingservice.dao.BookingEntity;
import com.capgemini.flightmanagement.bookingservice.exception.BookingNotFoundException;
import com.capgemini.flightmanagement.bookingservice.model.Booking;
import com.capgemini.flightmanagement.bookingservice.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	private BookingService service;
	
	/****************************************************************************************************************************
	 - Method Name      : addBooking
	 - Input Parameters : Booking
	 - Return type      : ResponseEntity<String>
	 - Author           : Trisha Mazumdar
	 - Creation Date    : 11-06-2020
	 - Description      : Inserting the booking information entered by user into the database.
	 - End point URL    : http://localhost:9090/booking/addBooking
	  ****************************************************************************************************************************/ 
	
	@PostMapping("/addBooking")
	public ResponseEntity<String> addBooking(@Valid @RequestBody Booking booking) {
		String msg= service.addBooking(booking);
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}
	
	/****************************************************************************************************************************
	 - Method Name      : viewBooking
	 - Input Parameters : void
	 - Return type      : List<Booking>
	 - Author           : Trisha Mazumdar
	 - Creation Date    : 11-06-2020
	 - Description      : Fetching the booking information from the database.
	 - End point URL    : http://localhost:9090/booking/viewBooking
	  ****************************************************************************************************************************/ 
	
	@GetMapping("/viewBooking")
	public List<Booking> viewBooking() {
		return service.viewBooking();
	}
	
	/****************************************************************************************************************************
	 - Method Name      : viewBookingById
	 - Input Parameters : bookingId
	 - Return type      : BookingEntity
	 - Author           : Trisha Mazumdar
	 - Creation Date    : 11-06-2020
	 - Description      : Fetching the booking information from the database by Booking Id.
	 - End point URL    : http://localhost:9090/booking/viewBookingById/11111
	  ****************************************************************************************************************************/ 
	
	@GetMapping("/viewBookingById/{bookingId}")
	public BookingEntity  viewBookingById(@PathVariable("bookingId")Long bookingId) throws BookingNotFoundException {
		return service.viewBookingById(bookingId);
	}
	
	/****************************************************************************************************************************
	 - Method Name      : updateBookingById
	 - Input Parameters : bookingId, Booking
	 - Return type      : ResponseEntity<String>
	 - Author           : Trisha Mazumdar
	 - Creation Date    : 11-06-2020
	 - Description      : Updating the booking information entered by user into the database.
	 - End point URL    : http://localhost:9090/booking/updateBookingById/11111
	  ****************************************************************************************************************************/ 
	
	@PutMapping("/updateBookingById/{bookingId}")
	public ResponseEntity<String> updateBookingById(@Valid @PathVariable Long bookingId, @RequestBody Booking booking) throws BookingNotFoundException {
		return ResponseEntity.ok(service.updateBookingById(bookingId,booking));
	}
	
	/****************************************************************************************************************************
	 - Method Name      : deleteBookingById
	 - Input Parameters : bookingId
	 - Return type      : ResponseEntity<String>
	 - Author           : Trisha Mazumdar
	 - Creation Date    : 11-06-2020
	 - Description      : Deleting the booking information from the database.
	 - End point URL    : http://localhost:9090/booking/deleteBookingById/11112
	  ****************************************************************************************************************************/ 
	
	@DeleteMapping("/deleteBookingById/{bookingId}")
	public ResponseEntity<String> deleteBookingById(@PathVariable Long bookingId) throws BookingNotFoundException{
		return ResponseEntity.ok(service.deleteBookingById(bookingId)); 
	}
}
