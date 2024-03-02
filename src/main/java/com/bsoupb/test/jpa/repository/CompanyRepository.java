package com.bsoupb.test.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bsoupb.test.jpa.domain.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>{ 

}
