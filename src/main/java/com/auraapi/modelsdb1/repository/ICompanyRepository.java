package com.auraapi.modelsdb1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auraapi.modelsdb1.entity.users.CompanyVO;

@Repository
public interface ICompanyRepository extends JpaRepository<CompanyVO, Long>{

}
