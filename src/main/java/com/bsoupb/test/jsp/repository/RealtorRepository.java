package com.bsoupb.test.jsp.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bsoupb.test.jsp.domain.Realtor;

@Mapper
public interface RealtorRepository {

	public int insertRealtor(
		@Param("office") String office
		, @Param("phoneNumber") String phoneNumber
		, @Param("address") String address
		, @Param("grade") String grade
	);
	
	public int insertRealtorByObject(Realtor realtor);
	
}
