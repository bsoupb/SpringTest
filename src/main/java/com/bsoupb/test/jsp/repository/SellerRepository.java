package com.bsoupb.test.jsp.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bsoupb.test.jsp.domain.Seller;

@Mapper
public interface SellerRepository {
	
	public int insertSeller(
			@Param("nickname") String nickname
			, @Param("temperature") double temperature
			, @Param("image") String image);
	
	public Seller selectLastSeller(@Param("id") Integer id);
	
	
}
