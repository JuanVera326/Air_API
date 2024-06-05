package com.auraapi.modelsdb1.dto;

public class AuthDTO {
	
	private String username_supplier;
	private String passkey_supplier;
	
	
	public AuthDTO() { }
	
	public String getUsername_supplier() {
		return username_supplier;
	}
	public void setUsername_supplier(String username_supplier) {
		this.username_supplier = username_supplier;
	}
	public String getPasskey_supplier() {
		return passkey_supplier;
	}
	public void setPasskey_supplier(String passkey_supplier) {
		this.passkey_supplier = passkey_supplier;
	}
	
}
