package com.auraapi.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auraapi.modelsdb1.entity.users.CompanyVO;
import com.auraapi.modelsdb1.service.ICompanyService;
import com.auraapi.modelsdb1.service.IUserSupplierService;


@RestController
@RequestMapping("/aura/api/centralcontrol")
@CrossOrigin(origins = {"*"}) // Tests
public class AdminCentralControlCompaniesRest {
	
	@Autowired
	private IUserSupplierService iUserSupplierService;
	
	@Autowired
	private ICompanyService companyService;
		
	@GetMapping("/getAllCompanies")
	@PreAuthorize("hasRole('ROLE_SUPERADMIN')")
	public ResponseEntity<?> getAllCompanies(){
		List<CompanyVO> companiesList = StreamSupport
				.stream(companyService.findAll().spliterator(), false).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(companiesList);
	}
	
	@GetMapping("/getAllCompanies/{idCompany}")
	public ResponseEntity<?> getCompanyById(@PathVariable Long idCompany){
		
		Optional<CompanyVO> company = companyService.findByID(idCompany);
		
		if (!company.isPresent()) {
			String msj = "La Compañia con id "+ idCompany +" no existe";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msj);
		}
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(company);
	
	}
	
	@GetMapping("/getAllCompanies/{idOwner}")
	public ResponseEntity<?> getCompanyByOwner(@PathVariable Long idOwner){
		
		List<CompanyVO> companiesList = StreamSupport
				.stream(companyService.findAll().spliterator(), false).collect(Collectors.toList());
		
		CompanyVO company = new CompanyVO();
		
		for(int i = 0; i <= companiesList.size(); i++) {
			
			if(companiesList.get(i).getOwner().getId_enterprise_user() == idOwner) {
				
				company = companiesList.get(i);
				break;
			
		}
			
 			if(company != null) {
 				return ResponseEntity.status(HttpStatus.ACCEPTED).body(company);
 			}else {
 				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
 			}
		}
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	
	}
	
	@PostMapping("/companies")// DEBE REVISARSE QUE VALIDE QUE NO EXISTA USUARIO PREVIO REGISTRADO HACER VALIDACION DE CONSULTA
	public ResponseEntity<?> saveNewCompany(@RequestBody CompanyVO company){
		
		 ResponseEntity.status(HttpStatus.ACCEPTED).body(companyService.save(company)); 
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}
	

	@DeleteMapping("/companies/{id}")
	public ResponseEntity<?> deleteCompany(Long roleheader, @PathVariable Long id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(companyService.deleteById(id));
	}
	
	@PutMapping("/companies/{id}")
	public ResponseEntity<?> updateCompany(@RequestBody CompanyVO company, @PathVariable Long id){
	
		Optional<CompanyVO> companyOp = companyService.findByID(id);
		
		if (!companyOp.isPresent()) {
			String msj = "La compañia con id "+ id +" no esta registrado";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msj);
		}
		
		companyOp.get().setId(company.getId());
		companyOp.get().setName_company(company.getName_company());
		companyOp.get().setRuc(company.getRuc());
		companyOp.get().setAddress(company.getAddress());
		companyOp.get().setEmail(company.getEmail());
		companyOp.get().setPhone(company.getPhone());
		companyOp.get().setType_activity(company.getType_activity());
		companyOp.get().setType_taxpayer(company.getType_taxpayer());
		companyOp.get().setDate_regist(company.getDate_regist());
		companyOp.get().setOwner(company.getOwner());
		companyOp.get().setState(company.isState());
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(companyService.save(companyOp.get()));
			
	}

}
