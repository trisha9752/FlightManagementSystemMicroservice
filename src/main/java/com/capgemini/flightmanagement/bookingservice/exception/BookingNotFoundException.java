/****************************************************************************************************************************
 - File Name        : BookingNotFoundException
 - Author           : Trisha Mazumdar
 - Creation Date    : 11-06-2020
 - Description      : This is an BookingNotFoundException class which is
 					   used to handle the Exception in Booking Service.
  ****************************************************************************************************************************/ 

package com.capgemini.flightmanagement.bookingservice.exception;

public class BookingNotFoundException extends Exception{
	public BookingNotFoundException(String msg) {
		super(msg);
	}
}
