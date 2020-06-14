/****************************************************************************************************************************
 - File Name        : BookingEntity
 - Author           : Trisha Mazumdar
 - Creation Date    : 11-06-2020
 - Description      : This is entity class to represent objects in Database of Booking Service.
  ****************************************************************************************************************************/ 

package com.capgemini.flightmanagement.bookingservice.dao;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="booking")
public class BookingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bookingid")
	private Long bookingId;
	@Column(name="passengername")
	@NotBlank(message="Passenger Name is mandatory")
	@NotNull(message="Passenger Name is mandatory")
	@Size(min = 3, max = 30, message="Name must be equal to or greater than 3 character and less than 30")
	private String passengerName;
	@Column(name="bookingdate")
	@NotNull(message="Booking Date is mandatory")
	private Date bookingDate;
	@Column(name="traveldate")
	@NotNull(message="Travel Date is mandatory")
	@Future
	private Date travelDate;
	@Column(name="bookingamount")
	@NotNull(message="Booking Amount is mandatory")
	@Min(value=1000, message="Booking Amount should be greater than 1000")
	private Double bookingAmount;
	@Column(name="passengerage")
	@NotNull(message="Passenger Age is mandatory")
	@Min(value=1, message="Age should be greater than 1 years")
	@Max(value=120, message="Age can not be greater than 120 years")
	private Integer passengerAge;
	@Column(name="passengeruin")
	@NotNull(message="Passenger UIN is mandatory")
	@Min(value=0, message="UIN can't be less than 0")
	private Long passengerUIN;
	@Column(name="flightnumber")
	@NotNull(message="flight Number is mandatory")
	private Long flightNumber;
	@Column(name="arrivaltime")
	@NotNull(message="flight Number is mandatory")
	private Time arrivalTime;
	@Column(name="departuretime")
	@NotNull(message="flight Number is mandatory")
	private Time departureTime;
	public BookingEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookingEntity(Long bookingId, String passengerName, Date bookingDate, Date travelDate, Double bookingAmount,
			Integer passengerAge, Long passengerUIN, Long flightNumber, Time arrivalTime, Time departureTime) {
		super();
		this.bookingId = bookingId;
		this.passengerName = passengerName;
		this.bookingDate = bookingDate;
		this.travelDate = travelDate;
		this.bookingAmount = bookingAmount;
		this.passengerAge = passengerAge;
		this.passengerUIN = passengerUIN;
		this.flightNumber = flightNumber;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
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
}
