package com.bsoupb.test.jsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsoupb.test.jsp.repository.RealtorRepository;

@Service
public class RealtorService {
	
	@Autowired
	private RealtorRepository realtorRepository;
	
	public int addRealtor(String office, String phoneNumber, String address, String grade) {
		int count = realtorRepository.insertRealtor(office, phoneNumber, address, grade);
		return count;
	}
	
}
