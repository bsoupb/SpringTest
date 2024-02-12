package com.bsoupb.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bsoupb.test.mybatis.domain.RealEstate;

@Mapper
public interface RealEstateRepository {
	
	public RealEstate selectRealEstateRepository(@Param("id") int id);
	
	public List<RealEstate> selectRErentPriceRepository(@Param("rentPrice") int rentPrice);
	
	public List<RealEstate> selectRealEstateListByAreaAndPrice(
			@Param("area") int area
			, @Param("price") int price);
	
	public int insertRealEstate(RealEstate realEstate);
	
	public int insertFieldRealEstate(
			@Param("realtorId") int realtorId
			, @Param("address") String address
			, @Param("area") int area
			, @Param("type") String type
			, @Param("price") int price
			, @Param("rentPrice") int rentPrice
			);
	
	public int updateRealEstate(
			@Param("id") int id
			, @Param("type") String type
			, @Param("price") int price
			);
	
	public int deleteRealEstate(@Param("id") int id);
}
