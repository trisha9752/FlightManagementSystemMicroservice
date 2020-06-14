/****************************************************************************************************************************
 - File Name        : BookingService
 - Author           : Trisha Mazumdar
 - Creation Date    : 11-06-2020
 - Description      : This is Service interface for booking. 
  ****************************************************************************************************************************/ 


package com.capgemini.flightmanagement.bookingservice.service;

import java.util.List;

import com.capgemini.flightmanagement.bookingservice.dao.BookingEntity;
import com.capgemini.flightmanagement.bookingservice.exception.BookingNotFoundException;
import com.capgemini.flightmanagement.bookingservice.model.Booking;

public interface BookingService {
	public String addBooking(Booking booking);
	public List<Booking> viewBooking();
	public BookingEntity viewBookingById(Long bookingId) throws BookingNotFoundException;
	public String updateBookingById(Long bookingId, Booking booking) throws BookingNotFoundException;
	public String deleteBookingById(Long bookingId) throws BookingNotFoundException;
}
