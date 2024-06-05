package com.auraapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.auraapi.modelsdb1.dto.EnterpriseUserDTO;
import com.auraapi.modelsdb1.entity.users.EnterpriseUserVO;
import com.auraapi.modelsdb1.service.IUserSupplierService;

@RestController
@RequestMapping("/aura/api/supplier")
@CrossOrigin(origins = { "*" }) // Tests
public class EnterpriseUserRest {

	@Autowired
	private IUserSupplierService iUserSupplierService;

	@Autowired
	private PasswordEncoder keyPassEncoder;

	@GetMapping("/getAllUsers")
	public ResponseEntity<?> getAllUsuarios() {
		List<EnterpriseUserDTO> usersList = iUserSupplierService.getAllUsers();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(usersList);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<?> getUser(@PathVariable(value = "id") Long user_id) {
		Optional<EnterpriseUserVO> oUser = iUserSupplierService.findByID(user_id);
		return ResponseEntity.ok(oUser);
	}

	@PostMapping("/users")
	public ResponseEntity<?> saveNewUsuario(@RequestBody EnterpriseUserVO user) {
		String crypPass = keyPassEncoder.encode(user.getPassword_enterprise_user());
		user.setPassword_enterprise_user(crypPass);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(iUserSupplierService.save(user));
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteUsuario(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(iUserSupplierService.deleteById(id));
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<?> updateUsuario(@RequestBody EnterpriseUserVO user, @PathVariable Long id) {

		Optional<EnterpriseUserVO> userOp = iUserSupplierService.findByID(id);

		if (!userOp.isPresent()) {
			String msj = "El usuario con id " + id + " no esta registrado";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msj);
		}

		userOp.get().setName_enterprise_user(user.getName_enterprise_user());
		userOp.get().setLastname_enterprise_user(user.getLastname_enterprise_user());
		userOp.get().setEmail_enterprise_user(user.getEmail_enterprise_user());
		userOp.get().setUsername_enterprise_user(user.getUsername_enterprise_user());
		userOp.get().setRegist_date_enterprise_user(user.getRegist_date_enterprise_user());
		userOp.get().setPassword_enterprise_user(user.getPassword_enterprise_user());
		userOp.get().setRol_enterprise_user(user.getRol_enterprise_user());
		userOp.get().setState_enterprise_user(user.isState_enterprise_user());
		userOp.get().setId_enterprise_user(user.getId_enterprise_user());
		userOp.get().setImage(user.getImage());

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(iUserSupplierService.save(userOp.get()));
	}

}
