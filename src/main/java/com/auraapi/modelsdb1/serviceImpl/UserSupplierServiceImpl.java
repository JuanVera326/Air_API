package com.auraapi.modelsdb1.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auraapi.modelsdb1.dto.EnterpriseUserDTO;
import com.auraapi.modelsdb1.dto.TransactionsDTO;
import com.auraapi.modelsdb1.entity.users.EnterpriseUserVO;
import com.auraapi.modelsdb1.entity.users.RolesUserSupplierVO;
import com.auraapi.modelsdb1.repository.IUserSupplierRepository;
import com.auraapi.modelsdb1.service.IUserSupplierService;

@Service
public class UserSupplierServiceImpl implements IUserSupplierService{
	
	
	@Autowired
	private IUserSupplierRepository iUserSupplierRepository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<EnterpriseUserVO> findAll() {
		return iUserSupplierRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<EnterpriseUserVO> findByID(Long id) {
		return iUserSupplierRepository.findById(id);
	}

	@Override
	public EnterpriseUserVO save(EnterpriseUserVO user) {
		return iUserSupplierRepository.save(user);
	}

	@Override
	public boolean deleteById(Long id) {
		iUserSupplierRepository.deleteById(id);
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<EnterpriseUserVO> findOneByUsername_supplier(String username) {
		return iUserSupplierRepository.findByUsername_enterprise_user(username);
	}
	
	@Override
	@Transactional(readOnly = true)
    public List<EnterpriseUserDTO> getAllUsers() {
        List<EnterpriseUserVO> usersList = StreamSupport.stream(iUserSupplierRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return usersList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private EnterpriseUserDTO convertToDto(EnterpriseUserVO user) {
        EnterpriseUserDTO userDto = modelMapper.map(user, EnterpriseUserDTO.class);

        // Convert roles to a set of role names
        Set<String> roles = user.getRol_enterprise_user().stream()
                .map(RolesUserSupplierVO::getName)
                .collect(Collectors.toSet());
        userDto.setRol_enterprise_user(roles);

        // Convert transactions
        Set<TransactionsDTO> transactions = user.getTransactions().stream()
                .map(transaction -> modelMapper.map(transaction, TransactionsDTO.class))
                .collect(Collectors.toSet());
        userDto.setTransactions(transactions);

        // Convert workforce
        Set<EnterpriseUserDTO> workforce = user.getWorkforce().stream()
                .map(worker -> modelMapper.map(worker, EnterpriseUserDTO.class))
                .collect(Collectors.toSet());
        userDto.setWorkforce(workforce);

        return userDto;
    }
}
