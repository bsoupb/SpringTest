package com.bsoupb.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bsoupb.test.mybatis.domain.RealEstate;

@Mapper
public interface RealEstateRepository {
	
	public RealEstate selectRealEstateRepository(@Param("id") int id);
	
	public List<RealEstate> selectRErentPriceRepository(@Param("rentPrice") int rentPrice);
	
}
