package com.bsoupb.test.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bsoupb.test.jsp.service.RealtorService;

@Controller
public class RealtorController {
	
	@Autowired
	private RealtorService realtorService;
	
	@GetMapping("/jsp/realtor/insert")
	@ResponseBody
	public String createRealtor(
		@RequestParam("office") String office
		, @RequestParam("phoneNumber") String phoneNumber
		, @RequestParam("address") String address
		, @RequestParam("grade") String grade
			) {
		int count = realtorService.addRealtor(office, phoneNumber, address, grade);
		return "실행 결과 : " + count;
	}
	
	@GetMapping("/jsp/realtor/input")
	public String inputRealtor() {
		return "/jsp/realtorInput";
	}
}
