package com.bsoupb.test.jstl.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsoupb.test.jstl.domain.Weather;
import com.bsoupb.test.jstl.repository.WeatherRepository;

@Service
public class WeatherService {
	
	@Autowired
	private WeatherRepository weatherRepository;
	
	public List<Weather> getWeather() {
		
		List<Weather> weather = weatherRepository.selectWeather();
		return weather;
		
	}
	
	public int addWeather(Date date, String weather, double temperatures, double precipitation, String microDust, double windSpeed) {
		
		int count = weatherRepository.insertWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
		return count;
		
	}
	
}
