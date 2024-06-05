package com.auraapi.modelsdb1.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auraapi.modelsdb1.entity.users.CompanyVO;
import com.auraapi.modelsdb1.repository.ICompanyRepository;
import com.auraapi.modelsdb1.service.ICompanyService;

@Service
public class CompanyServiceImpl implements ICompanyService{
	
	@Autowired
	private ICompanyRepository companyRepository; 

	@Override
	@Transactional(readOnly = true)
	public Iterable<CompanyVO> findAll() {
		return companyRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<CompanyVO> findByID(Long id) {
		return companyRepository.findById(id);
	}

	@Override
	public CompanyVO save(CompanyVO company) {
		return companyRepository.save(company);
	}

	@Override
	public boolean deleteById(Long id) {
		companyRepository.deleteById(id);
		return true;
	}

}
