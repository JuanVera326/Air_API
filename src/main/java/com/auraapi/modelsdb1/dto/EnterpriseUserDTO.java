package com.auraapi.modelsdb1.dto;

import java.util.HashSet;
import java.util.Set;


public class EnterpriseUserDTO {

	private Long id_enterprise_user;
	private String name_enterprise_user;
	private String username_enterprise_user;
	private String lastname_enterprise_user;
	private String email_enterprise_user;
	private String image;
	private boolean state_enterprise_user;
	private Set<String> rol_enterprise_user;
	private Set<TransactionsDTO> transactions;
	private Set<EnterpriseUserDTO> workforce;

	public EnterpriseUserDTO() {

		transactions = new HashSet<>();
		workforce = new HashSet<>();
	}

	public EnterpriseUserDTO(Long id_enterprise_user, String name_enterprise_user, String username_enterprise_user,
			String lastname_enterprise_user, String email_enterprise_user, String image, boolean state_enterprise_user,
			Set<String> rol_enterprise_user, Set<TransactionsDTO> transactions, Set<EnterpriseUserDTO> workforce) {
		super();
		this.id_enterprise_user = id_enterprise_user;
		this.name_enterprise_user = name_enterprise_user;
		this.username_enterprise_user = username_enterprise_user;
		this.lastname_enterprise_user = lastname_enterprise_user;
		this.email_enterprise_user = email_enterprise_user;
		this.image = image;
		this.state_enterprise_user = state_enterprise_user;
		this.rol_enterprise_user = rol_enterprise_user;
		this.transactions = transactions;
		this.workforce = workforce;
	}

	public Long getId_enterprise_user() {
		return id_enterprise_user;
	}

	public void setId_enterprise_user(Long id_enterprise_user) {
		this.id_enterprise_user = id_enterprise_user;
	}

	public String getName_enterprise_user() {
		return name_enterprise_user;
	}

	public void setName_enterprise_user(String name_enterprise_user) {
		this.name_enterprise_user = name_enterprise_user;
	}

	public String getUsername_enterprise_user() {
		return username_enterprise_user;
	}

	public void setUsername_enterprise_user(String username_enterprise_user) {
		this.username_enterprise_user = username_enterprise_user;
	}

	public String getLastname_enterprise_user() {
		return lastname_enterprise_user;
	}

	public void setLastname_enterprise_user(String lastname_enterprise_user) {
		this.lastname_enterprise_user = lastname_enterprise_user;
	}

	public String getEmail_enterprise_user() {
		return email_enterprise_user;
	}

	public void setEmail_enterprise_user(String email_enterprise_user) {
		this.email_enterprise_user = email_enterprise_user;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isState_enterprise_user() {
		return state_enterprise_user;
	}

	public void setState_enterprise_user(boolean state_enterprise_user) {
		this.state_enterprise_user = state_enterprise_user;
	}

	public Set<String> getRol_enterprise_user() {
		return rol_enterprise_user;
	}

	public void setRol_enterprise_user(Set<String> rol_enterprise_user) {
		this.rol_enterprise_user = rol_enterprise_user;
	}

	public Set<TransactionsDTO> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<TransactionsDTO> transactions) {
		this.transactions = transactions;
	}

	public Set<EnterpriseUserDTO> getWorkforce() {
		return workforce;
	}

	public void setWorkforce(Set<EnterpriseUserDTO> workforce) {
		this.workforce = workforce;
	}

}
