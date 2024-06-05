package com.auraapi.modelsdb1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auraapi.modelsdb1.entity.users.RolesUserSupplierVO;

@Repository
public interface IRolesUserSupplierRepository extends JpaRepository<RolesUserSupplierVO, Long>{

}
