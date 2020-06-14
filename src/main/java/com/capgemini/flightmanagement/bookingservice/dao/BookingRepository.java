/****************************************************************************************************************************
 - File Name        : BookingRepository
 - Author           : Trisha Mazumdar
 - Creation Date    : 11-06-2020
 - Description      : This is an interface for HotelService which extends JpaRepository to 
 					  perform all the basic CRUD operations
  ****************************************************************************************************************************/ 

package com.capgemini.flightmanagement.bookingservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long>  {
	
	
	
	
}
