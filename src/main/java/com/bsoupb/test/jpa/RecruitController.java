package com.bsoupb.test.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bsoupb.test.jpa.domain.Recruit;
import com.bsoupb.test.jpa.repository.RecruitRepository;

@RequestMapping("/jpa/recruit")
@Controller
public class RecruitController {

	@Autowired
	private RecruitRepository recruitRepository;
	
	
//	1. id 로 조회
//	id가 8인 공고를 조회하고 아래와 같이 출력하세요.
	@GetMapping("/1")
	@ResponseBody
	public Recruit selectRecruit1() {
		
		Optional<Recruit> optionalRecruit = recruitRepository.findById(8);
		Recruit recruit = optionalRecruit.orElse(null);
		
		return recruit;

	}
	
//	2. Parameter 조건 조회
//	Request Parameter로 전달 받은 company id로 해당하는 회사의 공고를 조회하세요.
//	조회 결과를 아래와 같이 출력하세요.
	@GetMapping("/2")
	@ResponseBody
	public List<Recruit> selectRecruit2(@RequestParam("companyId") int companyId){
		List<Recruit> recruitList = recruitRepository.findByCompanyId(companyId);
		return recruitList;
	}
	
//	3. 복합 조건 조회
//	웹 back-end 개발자 이고 정규직인 공고를 조회하고 아래와 같이 출력하세요.
	@GetMapping("/3")
	@ResponseBody
	public List<Recruit> selectRecruit3(){
		List<Recruit> recruitList = recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
		return recruitList;
	}
	
//	4. 복합 조건 조회
//	정규직이거나 연봉이 9000 이상인 공고를 조회하고 아래와 같이 출력하세요.
	@GetMapping("/4")
	@ResponseBody
	public List<Recruit> selectRecruit4(){
		List<Recruit> recruitList = recruitRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
		return recruitList;
	}
	
//	5. 정렬 제한 조건
//	계약직 목록을 연봉 기준으로 내림차순 정렬해서 3개만 조회하세요.
	@GetMapping("/5")
	@ResponseBody
	public List<Recruit> selectRecruit5(){
		List<Recruit> recruitList = recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
		return recruitList;
	}
	
//	6. 범위 조회
//	성남시 분당구가 지역인 연봉 7000 이상 8500 이하인 공고를 조회하고 아래와 같이 출력하세요.
	@GetMapping("/6")
	@ResponseBody
	public List<Recruit> selectRecruit6(){
		List<Recruit> recruitList = recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
		return recruitList;
	}
	
//	7. Native query
//	마감일이 2026-04-10 이후이고 연봉이 8100 이상인 정규직 공고를 연봉 내림차순으로 조회하세요.
	@GetMapping("/7")
	@ResponseBody
	public List<Recruit> selectRecruit7(){
		List<Recruit> recruitList = recruitRepository.findByDeadlineAndTypeOrderSalaryDesc("정규직", 8100, "2026-04-10 00:00:00");
		return recruitList;
		
	}
	
	
}
