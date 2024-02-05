package com.bsoupb.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bsoupb.test.mybatis.domain.RealEstate;
import com.bsoupb.test.mybatis.service.RealEstateService;

@Controller
public class RealEstateController {
	
	@Autowired
	private RealEstateService realEstateService;
	
	@RequestMapping("/mybatis/real-estate/1")
	@ResponseBody
	public RealEstate realEstate(@RequestParam("id") int id) {
		
		RealEstate realEstate = realEstateService.getRealEstate(id);
		return realEstate;
		
	}	
	
	@RequestMapping("/mybatis/real-estate/2")
	@ResponseBody
	public List<RealEstate> RErentPrice(@RequestParam("rentPrice") int rentPrice) {
		
		List<RealEstate> rErentPrice = (List<RealEstate>) realEstateService.getRErentPrice(rentPrice);
		return rErentPrice;
	}
}
