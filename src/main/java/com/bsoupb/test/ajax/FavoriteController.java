package com.bsoupb.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bsoupb.test.ajax.domain.Favorite;
import com.bsoupb.test.ajax.service.FavoriteService;

@Controller
public class FavoriteController {
	
	@Autowired
	private FavoriteService favoriteService;
	
	@GetMapping("/ajax/favorite/list")
	public String FavoriteList(Model model) {
		
		List<Favorite> favorite = favoriteService.getFavorite();

		model.addAttribute("favoriteList", favorite);
		return "/ajax/favorite/list";
	}
	
	@GetMapping("/ajax/favorite/input")
	public String FavoriteInput() {
		return "ajax/favorite/input";
	}
	
	@PostMapping("/ajax/favorite/create")
	@ResponseBody  // 응답 처리 방식
	public Map<String, String> FavoriteCreate(
			@RequestParam("name") String name
			, @RequestParam("url") String url
 			) {
		int count = favoriteService.addFavorite(name, url);
		
		// 성공실패 여부
		// {"result":"success"}
		// {"result":"fail"}
		
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			// 성공
			resultMap.put("result", "success");
		} else {
			// 실패
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@PostMapping("/ajax/favorite/duplicate-url")
	@ResponseBody
	public Map<String, Boolean> isDuplicateUrl(@RequestParam("url") String url) {
		
		boolean isDuplicate = favoriteService.isDuplicateUrl(url);
		
		Map<String, Boolean> resultMap = new HashMap<>(); // key, value 형태
		
//		if(isDuplicate) {
//			resultMap.put("isDuplicate", true);
//		} else {
//			resultMap.put("isDuplicate", false);
//		}
		
		resultMap.put("isDuplicate", isDuplicate);
		
		return resultMap;
	}
	
	@GetMapping("/ajax/favorite/delete-url")
	@ResponseBody
	public Map<String, String> deleteUrl(@RequestParam("id") int id) {
		int count = favoriteService.deleteUrl(id);
		
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
}
