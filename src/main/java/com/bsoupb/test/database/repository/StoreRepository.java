package com.bsoupb.test.database.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bsoupb.test.database.domain.Store;

@Mapper
public interface StoreRepository {
	
	public List<Store> selectStoreList();
	
}
