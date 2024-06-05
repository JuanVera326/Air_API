package com.auraapi.modelsdb1.service;

import java.util.Optional;

import com.auraapi.modelsdb1.entity.users.CompanyVO;

public interface ICompanyService {
	
	public Iterable<CompanyVO> findAll();
	
	public Optional<CompanyVO> findByID(Long id);
 	
	public CompanyVO save(CompanyVO company);
	
	public boolean deleteById(Long id);
	
}
