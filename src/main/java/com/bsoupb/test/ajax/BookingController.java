package com.bsoupb.test.ajax;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bsoupb.test.ajax.domain.Booking;
import com.bsoupb.test.ajax.service.BookingService;

@Controller
@RequestMapping("/ajax/booking")
public class BookingController {
	
	@GetMapping("/main")
	public String BookingMain() {
		return "/ajax/booking/main";
	}
	
	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/list")
	public String BookingList(Model model) {
		
		List<Booking> booking = bookingService.getBooking();
		
		model.addAttribute("bookingList", booking);
		
		return "/ajax/booking/list";
	}
	
	@GetMapping("/input")
	public String BookingInput() {
		return "ajax/booking/input";
	}
	
	@GetMapping("/insert")
	@ResponseBody
	public Map<String, String> insertBooking(
			@RequestParam("name") String name
			, @DateTimeFormat(pattern="yyyy년 M월 d일") @RequestParam("date") Date date
			, @RequestParam("day") int day
			, @RequestParam("headcount") int headcount
			, @RequestParam("phoneNumber") String phoneNumber
			) {
		
		int count = bookingService.insertBooking(name, date, day, headcount, phoneNumber);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public Map<String, String> deleteBooking(@RequestParam("id") int id) {
		int count = bookingService.deleteBooking(id);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@GetMapping("/search")
	@ResponseBody
	public Booking searchBooking(@RequestParam("name") String name, @RequestParam("phoneNumber") String phoneNumber, Model model) {
		Booking booking = bookingService.searchBooking(name, phoneNumber);
		model.addAttribute("bookingList", booking);
		return booking;
	}
	
	
}
