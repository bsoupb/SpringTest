package com.bsoupb.test.jstl.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bsoupb.test.jstl.domain.Weather;

@Mapper
public interface WeatherRepository {

	public List<Weather> selectWeather();
	
}
