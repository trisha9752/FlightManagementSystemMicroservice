/****************************************************************************************************************************
 - File Name        : BookingServiceImplementation
 - Author           : Trisha Mazumdar
 - Creation Date    : 11-06-2020
 - Description      : This is a service class which contains the business logic of Booking Service
  ****************************************************************************************************************************/ 

package com.capgemini.flightmanagement.bookingservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.flightmanagement.bookingservice.dao.BookingEntity;
import com.capgemini.flightmanagement.bookingservice.dao.BookingRepository;
import com.capgemini.flightmanagement.bookingservice.exception.BookingNotFoundException;
import com.capgemini.flightmanagement.bookingservice.model.Booking;


@Service
public class BookingServiceImplementation implements BookingService {
	@Autowired
	 private BookingRepository repository;

	/****************************************************************************************************************************
	 - Method Name      : addBooking
	 - Input Parameters : Booking
	 - Return type      : String
	 - Author           : Trisha Mazumdar
	 - Creation Date    : 11-06-2020
	 - Description      : Inserting the booking information into the database.
	  ****************************************************************************************************************************/ 
	
	@Override
	public String addBooking(Booking booking) {
		// TODO Auto-generated method stub
		BookingEntity entity = new BookingEntity();
		entity.setBookingAmount(booking.getBookingAmount());
		entity.setBookingDate(booking.getBookingDate());
		entity.setPassengerName(booking.getPassengerName());
		entity.setTravelDate(booking.getTravelDate());
		entity.setPassengerAge(booking.getPassengerAge());
		entity.setPassengerUIN(booking.getPassengerUIN());
		entity.setFlightNumber(booking.getFlightNumber());
		entity.setArrivalTime(booking.getArrivalTime());
		entity.setDepartureTime(booking.getDepartureTime());
		repository.saveAndFlush(entity);	
		String msg = "Booking added successfully with booingId "+entity.getBookingId();
		return msg;
	}

	/****************************************************************************************************************************
	 - Method Name      : viewBooking
	 - Input Parameters : void
	 - Return type      : List<Booking>
	 - Author           : Trisha Mazumdar
	 - Creation Date    : 11-06-2020
	 - Description      : Fetching the booking information from the database.
	  ****************************************************************************************************************************/ 
	
	@Override
	public List<Booking> viewBooking() {
		// TODO Auto-generated method stub
		List<BookingEntity> entityList=repository.findAll();
		List<Booking> newBookingList = new ArrayList<>();
		for (BookingEntity entity : entityList) {
			Booking booking = new Booking();
			booking.setBookingId(entity.getBookingId());
			booking.setBookingAmount(entity.getBookingAmount());
			booking.setBookingDate(entity.getBookingDate());
			booking.setPassengerAge(entity.getPassengerAge());
			booking.setPassengerName(entity.getPassengerName());
			booking.setPassengerUIN(entity.getPassengerUIN());
			booking.setTravelDate(entity.getTravelDate());
			booking.setFlightNumber(entity.getFlightNumber());
			booking.setArrivalTime(entity.getArrivalTime());
			booking.setDepartureTime(entity.getDepartureTime());
			newBookingList.add(booking);
	}
		return newBookingList;
	}

	/****************************************************************************************************************************
	 - Method Name      : viewBookingById
	 - Input Parameters : bookingId
	 - Return type      : BookingEntity
	 - Author           : Trisha Mazumdar
	 - Creation Date    : 11-06-2020
	 - Description      : Fetching the booking information from the database by Booking Id.
	  ****************************************************************************************************************************/ 

	@Override
	public BookingEntity viewBookingById(Long bookingId) throws BookingNotFoundException {
		// TODO Auto-generated method stub
		Optional<BookingEntity> entity = repository.findById(bookingId);
		if(entity.isPresent()) {
			return entity.get();
		}
		else {
			throw new BookingNotFoundException("Booking not found for the given id");
		}
	}
	
	/****************************************************************************************************************************
	 - Method Name      : updateBookingById
	 - Input Parameters : bookingId, Booking
	 - Return type      : String
	 - Author           : Trisha Mazumdar
	 - Creation Date    : 11-06-2020
	 - Description      : Updating the booking information into the database.
	  ****************************************************************************************************************************/ 
	
	@Override
	public String updateBookingById(Long bookingId, Booking booking) throws BookingNotFoundException {
		// TODO Auto-generated method stub
		Optional<BookingEntity> optional = repository.findById(bookingId);
		if(optional.isPresent()) {
			BookingEntity entity = optional.get();
			entity.setBookingAmount(booking.getBookingAmount());
			entity.setBookingDate(booking.getBookingDate());
			entity.setPassengerName(booking.getPassengerName());
			entity.setTravelDate(booking.getTravelDate());
			entity.setPassengerAge(booking.getPassengerAge());
			entity.setPassengerUIN(booking.getPassengerUIN());
			entity.setFlightNumber(booking.getFlightNumber());
			entity.setArrivalTime(booking.getArrivalTime());
			entity.setDepartureTime(booking.getDepartureTime());
			repository.save(entity);
			return "Booking updated successfully!";
		}
		else {
			throw new BookingNotFoundException("Booking not found for the given id");
		}
	}
	
	/****************************************************************************************************************************
	 - Method Name      : deleteBookingById
	 - Input Parameters : bookingId
	 - Return type      : String
	 - Author           : Trisha Mazumdar
	 - Creation Date    : 11-06-2020
	 - Description      : Deleting the booking information from the database.
	  ****************************************************************************************************************************/ 

	@Override
	public String deleteBookingById(Long bookingId) throws BookingNotFoundException {
		// TODO Auto-generated method stub
		Optional<BookingEntity> entity = repository.findById(bookingId);
		if(entity.isPresent()) {
			repository.deleteById(bookingId);
			return "Booking record deleted successfully!";
		}
		else {
			throw new BookingNotFoundException("Booking not found for the given id");
		}
		
	}
}
