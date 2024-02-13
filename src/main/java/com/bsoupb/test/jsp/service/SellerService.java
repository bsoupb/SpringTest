package com.bsoupb.test.jsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsoupb.test.jsp.domain.Seller;
import com.bsoupb.test.jsp.repository.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;
	
	public int addSeller(String nickname, double temperature, String image) {
		
		int count = sellerRepository.insertSeller(nickname, temperature, image);
		return count;
		
	}
	
	public Seller getLastSeller() {
	
		Seller seller = sellerRepository.selectLastSeller();
		return seller;
	}
	
	public Seller getSeller(Integer id) {
		
		Seller seller = sellerRepository.selectSeller(id);
		return seller;
	}
	
}
