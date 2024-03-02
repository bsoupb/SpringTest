package com.bsoupb.test.ajax.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsoupb.test.ajax.domain.Booking;
import com.bsoupb.test.ajax.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	
	public List<Booking> getBooking() {
		List<Booking> booking = bookingRepository.selectBooking();
		return booking;
	}
	
	public int insertBooking(String name, Date date, int day, int headcount, String phoneNumber) {
		int count = bookingRepository.insertBooking(name, date, day, headcount, phoneNumber, "대기중");
		return count;
	}
	
	public int deleteBooking(int id) {
		int count = bookingRepository.deleteBooking(id);
		return count;
	}
	
	public Booking searchBooking(String name, String phoneNumber) {
		Booking booking = bookingRepository.searchBooking(name, phoneNumber);
		return booking;
	}
	
}
