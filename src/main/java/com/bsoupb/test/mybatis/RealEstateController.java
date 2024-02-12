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
@RequestMapping("/mybatis/real-estate")
public class RealEstateController {
	
	@Autowired
	private RealEstateService realEstateService;
	
	
	// 1. id 로 select 하기
	// id를 parameter 로 입력 받고 해당하는 id의 매물 정보를 아래와 같이 json으로 출력하세요.
	@RequestMapping("/select/1")
	@ResponseBody
	public RealEstate realEstate(@RequestParam("id") int id) {
		
		// 파라미터로 전달된 id와 일치하는 매물 정보를 json으로 response에 담는다
		RealEstate realEstate = realEstateService.getRealEstate(id);
		return realEstate;
		
	}	
	
	//	2. 월세 조건 select
	//	월세(rentPrice) 를 parameter 로 받고 해당하는 월세보다 낮은 매물을 아래와 같이 json 으로 출력하세요.
	@RequestMapping("/select/2")
	@ResponseBody
	public List<RealEstate> RErentPrice(@RequestParam("rentPrice") int rentPrice) {
		
		List<RealEstate> rErentPrice = (List<RealEstate>) realEstateService.getRErentPrice(rentPrice);
		return rErentPrice;
	}
//	
//	3. 복합조건 select
//	아래 두 parameter를 받고 매매 매물 중 조건에 모두 부합하는 매물 정보를 아래와 같이 json으로 출력하세요.
//	넓이(area) - 매물의 넓이가 전달 받은 넓이 이상인 것
//	가격(price) - 매물의 매매금이 전달받은 매매금 보다 이하인 것
//	등록일을 기준으로 내림 차순으로 정렬하세요.
	
	
	@RequestMapping("/select/3")
	@ResponseBody
	public List<RealEstate> realEstateListByAreaAndPrice(
			@RequestParam("area") int area
			, @RequestParam("price") int price){
		
		List<RealEstate> realEstateList = realEstateService.getRealEstateListByAreaAndPrice(area, price);
		return realEstateList;
		
	}
	
//	1. 객체로 insert 하기
//	아래 내용을 객체를 활용해서 insert 하세요.
//	입력 성공한 행의 수를 출력하세요.
	@RequestMapping("/insert/1")
	@ResponseBody
	public String createRealEstate() {
		
		RealEstate realEstate = new RealEstate();
		
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		
		int count = realEstateService.addRealEstate(realEstate);
		return "실행 결과 : " + count;
		
	}
	
//	2. field 로 insert 하기
//	아래 내용을 객체 없이 insert 하세요.
//	단, realtorId 는 parameter를 통해서 전달받아서 저장하세요.
//	입력 성공한 행의 수를 출력하세요.
	@RequestMapping("/insert/2")
	@ResponseBody
	public String createFieldRealEstate(@RequestParam("realtorId") int realtorId) {
		int count = realEstateService.addFieldRealEstate(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		return "실행 결과 : " + count;
	}
	
//	1. update
//	id가 22 인 행의 type 을 전세로 바꾸고 price 를 70000으로 변경하세요.
//	수정 성공한 행의 수를 출력하세요.
	
	@RequestMapping("/update")
	@ResponseBody
	public String updateRealEstate() {
		// id가 23인 매물 정보에 type을 전세, 보증금 70000으로 변경
		
		int count = realEstateService.updateRealEstate(23, "전세", 70000);
		return "수정 성공 " + count;
		
	}
	
//	1. delete
//	parameter로 받은 id의 행을 삭제하세요.
//	삭제 성공한 행의 수를 출력하세요.
	
	@RequestMapping("/delete")
	@ResponseBody
	public String deleteRealEstate(@RequestParam("id") int id){
		int count = realEstateService.deleteRealEstate(id);
		return "삭제 성공 " + count;
	}

}
