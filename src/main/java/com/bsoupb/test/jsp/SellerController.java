package com.bsoupb.test.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bsoupb.test.jsp.domain.Seller;
import com.bsoupb.test.jsp.service.SellerService;

@Controller
@RequestMapping("/jsp/seller")
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	@PostMapping("/create")
	@ResponseBody
	public String crateSeller(
			@RequestParam("nickname") String nickname
			, @RequestParam("temperature") double temperature
			, @RequestParam("image") String image){
		
		int count = sellerService.addSeller(nickname, temperature, image);
		return "실행 결과 : " + count;
		
	}
	
	@GetMapping("/input")
	public String inputSeller() {
		return "/jsp/sellerInput";
	}
	
	@GetMapping("/info")
	public String infoSeller(@RequestParam(required=false, value="id") Integer id, Model model) { // required : 파라미터가 전달될 수 도 있고 아닐 수도 있고
		
		// id가 전달되면 일치하는 판매자 정보
		Seller seller = null;
		if(id != null) {
			seller = sellerService.getSeller(id);
			
		} else { // id가 전달되지 않으면 가장 최근 등록된 판매자 정보
			seller = sellerService.getLastSeller();

		}
		
		model.addAttribute("seller", seller);
		model.addAttribute("title", "판매자 정보");
					
		return "/jsp/sellerInfo";
	}
	
}
