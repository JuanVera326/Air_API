package com.auraapi.modelsdb1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.auraapi.modelsdb1.entity.users.EnterpriseUserVO;


@Repository
public interface IUserSupplierRepository extends JpaRepository<EnterpriseUserVO, Long>{
	
    @Query("SELECT u FROM EnterpriseUserVO u WHERE username_enterprise_user = ?1")
    Optional<EnterpriseUserVO> findByUsername_enterprise_user(String username);
}
