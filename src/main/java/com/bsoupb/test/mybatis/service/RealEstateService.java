package com.bsoupb.test.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsoupb.test.mybatis.domain.RealEstate;
import com.bsoupb.test.mybatis.repository.RealEstateRepository;

@Service
public class RealEstateService {

	@Autowired
	private RealEstateRepository realEstateRepository;
	
	public RealEstate getRealEstate(int id) {
		
		RealEstate realEstate = realEstateRepository.selectRealEstateRepository(id);
		
		return realEstate;
	}

	public List<RealEstate> getRErentPrice(int rentPrice) {
		
		List<RealEstate> rErentPrice = realEstateRepository.selectRErentPriceRepository(rentPrice);
		return rErentPrice;
	}
}
