package com.bsoupb.test.jstl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.bsoupb.test.jstl.domain.Weather;
import com.bsoupb.test.jstl.service.WeatherService;

@Controller

public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("jstl/weather/list")
	public List<Weather> weatherList(Model model) {
		
		List<String> WeatherImageList = new ArrayList<>(); 
		
		WeatherImageList.add("http://marondal.com/material/images/dulumary/web/jstl/sunny.jpg");
		WeatherImageList.add("http://marondal.com/material/images/dulumary/web/jstl/partlyCloudy.jpg");
		WeatherImageList.add("http://marondal.com/material/images/dulumary/web/jstl/cloudy.jpg");
		WeatherImageList.add("http://marondal.com/material/images/dulumary/web/jstl/rainy.jpg");
		
		List<Weather> weather = weatherService.getWeather();
		
		model.addAttribute("weather", weather);
		model.addAttribute("weatherImage", WeatherImageList);
		
		return weather;
	}
	
	@GetMapping("jstl/weather/input")
	public String weatherInput() {
		return "/jstl/weather/input";
	}
	
	@GetMapping("jstl/weather/insert")
	
	public String insertWeather(
//			@DateTimeFormat(pattern="yyyy년M월d일") @RequestParam("date") Date date 
//			, @RequestParam("weather") String weather
//			, @RequestParam("temperatures") double temperatures
//			, @RequestParam("precipitation") double precipitation
//			, @RequestParam("microDust") String microDust
//			, @RequestParam("windSpeed") double windSpeed
			@ModelAttribute Weather weather
			) {
			
//		int count = weatherService.addWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
		
		weatherService.addWeatherByObject(weather);

		//		return "수행결과 : " + count;
		return "redirect:/jstl/weather/list";
		
	}
	
	
}
