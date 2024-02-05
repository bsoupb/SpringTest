package com.bsoupb.test.database.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bsoupb.test.database.domain.Store;

@Mapper
public interface StoreRepository {
	
	// 3. store 테이블의 모든 행을 조회하고 돌려준다.
	// 4. 한 행의 객체를 저장할 클래스 설계 -> 리스트로 구성 (domain, entity)
	public List<Store> selectStoreList(); // 여러 행 : 리스트, <> 안 : 객체
	// 인터페이스 : 세미콜론으로 끝
}
