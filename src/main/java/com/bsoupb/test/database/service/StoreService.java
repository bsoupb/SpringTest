package com.bsoupb.test.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsoupb.test.database.domain.Store;
import com.bsoupb.test.database.repository.StoreRepository;

@Service
public class StoreService {
	
	@Autowired
	private StoreRepository storeRepository;
	
	// 가게 정보 리스트를 돌려주는 기능
	public List<Store> getStoreList(){
		// 2. store 테이블의 가게정보 조회 결과를 Repository 메소드를 통해 얻어 온다.
		List<Store> storeList = storeRepository.selectStoreList();
	
		return storeList;
	}
}
