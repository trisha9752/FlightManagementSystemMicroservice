/****************************************************************************************************************************
 - File Name        : Booking
 - Author           : Trisha Mazumdar
 - Creation Date    : 11-06-2020
 - Description      : This is a model class which encapsulates the data and helps to share it among different classes.
  ****************************************************************************************************************************/ 


package com.capgemini.flightmanagement.bookingservice.model;

import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.Date;


@Component
public class Booking {
	private Long bookingId;
	private String passengerName;
	private Date bookingDate;
	private Date travelDate;
	private Double bookingAmount;
	private Integer passengerAge;
	private Long passengerUIN;
	private Long flightNumber;
	private Time arrivalTime;
	private Time departureTime;
	public Long getBookingId() {
		return bookingId;
	}
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Date getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}
	public Double getBookingAmount() {
		return bookingAmount;
	}
	public void setBookingAmount(Double bookingAmount) {
		this.bookingAmount = bookingAmount;
	}
	public Integer getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(Integer passengerAge) {
		this.passengerAge = passengerAge;
	}
	public Long getPassengerUIN() {
		return passengerUIN;
	}
	public void setPassengerUIN(Long passengerUIN) {
		this.passengerUIN = passengerUIN;
	}
	public Long getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(Long flightNumber) {
		this.flightNumber = flightNumber;
	}
	public Time getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public Time getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}
	
}
