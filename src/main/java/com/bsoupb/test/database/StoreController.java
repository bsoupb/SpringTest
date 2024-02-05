package com.bsoupb.test.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bsoupb.test.database.domain.Store;
import com.bsoupb.test.database.service.StoreService;

@Controller
public class StoreController {
	
	// 가게 정보 리스트를 json으로 response에 담는다
	// 1. Store 관련 Service Class의 메소드를 통해 가게 정보 리스트를 얻어 온다
	// service만 앎
	// 가게 정보 리스트는 Service Class를 통해 얻어옴
	
	// 해당 변수의 객체를 채워 줌
	@Autowired
	private StoreService storeService;
	
	@RequestMapping("/db/store/list")
	@ResponseBody
	public List<Store> storeList() {
		
		List<Store> storeList = storeService.getStoreList();
		return storeList;
	}
	
}
