package com.bsoupb.test.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;

import com.bsoupb.test.jsp.domain.Realtor;
import com.bsoupb.test.jsp.service.RealtorService;

@Controller
public class RealtorController {
	
	@Autowired
	private RealtorService realtorService;
	
	@GetMapping("/jsp/realtor/insert")
//	@ResponseBody
	public String createRealtor(
		@RequestParam("office") String office
		, @RequestParam("phoneNumber") String phoneNumber
		, @RequestParam("address") String address
		, @RequestParam("grade") String grade
		, Model model
			) {
//		int count = realtorService.addRealtor(office, phoneNumber, address, grade);
		
		Realtor realtor = new Realtor(); // insert 해야 할 primary key -> 객체로 가져옴(엔티티 클래스)
		
		realtor.setOffice(office);
		realtor.setPhoneNumber(phoneNumber);
		realtor.setAddress(address);
		realtor.setGrade(grade);
		
		int count = realtorService.addRealtorByObject(realtor);
		
		model.addAttribute("realtor", realtor);
		
		return "/jsp/realtorInfo";
	}
	
	@GetMapping("/jsp/realtor/input")
	public String inputRealtor() {
		return "/jsp/realtorInput";
	}
	
	@GetMapping("jsp/realtor/info")
	public String infoRealtor() {
		
		return "/jsp/realtorInfo";
	}
}
