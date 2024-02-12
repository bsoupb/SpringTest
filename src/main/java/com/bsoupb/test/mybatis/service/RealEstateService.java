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
	
	public List<RealEstate> getRealEstateListByAreaAndPrice(int area, int price){
		List<RealEstate> realEstateList = realEstateRepository.selectRealEstateListByAreaAndPrice(area, price);
		return realEstateList;
	}
	
	public int addRealEstate(RealEstate realEstate) {
		int count = realEstateRepository.insertRealEstate(realEstate);
		return count;
	}
	
	public int addFieldRealEstate(int realtorId, String address, int area, String type, int price, int rentPrice) {
		int count = realEstateRepository.insertFieldRealEstate(realtorId, address, area, type, price, rentPrice);
		return count;
	}
	
	// id가 22인 매물 정보에 type을 전세, 보증금 70000으로 변경
	// 특정 id의 매물 정보에 전달 받은 type과 price 값으로 수정하는 기능
	public int updateRealEstate(int id, String type, int price) {
		int count = realEstateRepository.updateRealEstate(id, type, price);
		return count;
	}
	
	public int deleteRealEstate(int id) {
		int count = realEstateRepository.deleteRealEstate(id);
		return count;
	}
}
