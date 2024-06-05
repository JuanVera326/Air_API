package com.auraapi.modelsdb1.service;

import java.util.List;
import java.util.Optional;

import com.auraapi.modelsdb1.dto.EnterpriseUserDTO;
import com.auraapi.modelsdb1.entity.users.EnterpriseUserVO;

public interface IUserSupplierService {
	
	public Iterable<EnterpriseUserVO> findAll();
	
	public Optional<EnterpriseUserVO> findByID(Long id);
 	
	public EnterpriseUserVO save(EnterpriseUserVO user);
	
	public boolean deleteById(Long id);
	
	/*---------------------------------*/
	
	public Optional <EnterpriseUserVO> findOneByUsername_supplier (String username);
	
	public List<EnterpriseUserDTO> getAllUsers();
	
}
