package com.bsoupb.test.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bsoupb.test.jpa.domain.Company;
import com.bsoupb.test.jpa.service.CompanyService;

@RequestMapping("/jpa/company")
@Controller
public class CompayController {
	
	@Autowired
	private CompanyService companyService;
	
	
//	1. Create
//	아래 회사 정보들을 테이블에 Insert 하세요.
//	객체 생성은 builder 패턴을 활용하세요.
//	저장 성공한 객체들의 정보를 아래와 같이 출력하세요.
//	회사명 : 넥손
//	사업내용 : 컨텐츠 게임
//	규모 : 대기업
//	사원수 : 3585명
//	회사명 : 버블팡
//	사업내용 : 여신 금융업
//	규모 : 대기업
//	사원수 : 6834명
	@GetMapping("/create")
	@ResponseBody
	public List<Company> createCompany() {
		
		List<Company> companyList =  new ArrayList<>();
		
		Company company  = companyService.addCompany("넥손", "컨텐츠 게임", "대기업", 3585);
		companyList.add(company);
		company = companyService.addCompany("버플팡", "여신 금융업", "대기업", 6834);
		companyList.add(company);
		
		return companyList;
	}
	
//	2. Update
//	버블팡이 극심한 경영 악화로 회사 정보가 변경되었다.
//	규모를 중소기업, 사원수를 34명 으로 수정하세요. (버블팡의 pk id번호로 업데이트 - workbench에서 조회)
//	수정된 내용을 아래와 같이 출력 하세요.
	
	@GetMapping("/update")
	@ResponseBody
	public Company updateCompany() {
		Company company = companyService.updateCompany(10, "중소기업", 34);
		return company;
	}
	
	
//	3. Delete
//	버블팡이 파산하여 회사가 없어졌다.
//	해당 회사 정보를 테이블에서 삭제하세요. (버블팡의 pk id번호로 업데이트 - workbench에서 조회)
	@GetMapping("/delete")
	@ResponseBody
	public String deleteCompany() {
		companyService.deleteCompany(10);
		return "수행 완료";
	}
}
