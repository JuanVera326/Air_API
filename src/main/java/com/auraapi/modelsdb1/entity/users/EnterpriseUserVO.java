package com.auraapi.modelsdb1.entity.users;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.auraapi.modelsdb1.entity.inventory.TransactionsVO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;

@Entity
@Table(name = "enterprise_user")
public class EnterpriseUserVO implements Serializable{
	
	private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_enterprise_user", nullable = false)
    private Long id_enterprise_user;

    @Column(name = "name_enterprise_user", nullable = false , length = 80)
    private String name_enterprise_user;

    @Column(name = "password_enterprise_user", nullable = false , length = 100)
    private String password_enterprise_user;
    
    @Column(name = "username_enterprise_user", nullable = false , length = 45)
    private String username_enterprise_user;
    
    @Column(name = "lastname_enterprise_user", nullable = false , length = 80)
    private String lastname_enterprise_user;
    
    @Column(name = "email_enterprise_user", nullable = false , length = 100)
    private String email_enterprise_user;
    
    @JsonIgnoreProperties("users")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
               joinColumns = @JoinColumn(name = "id_enterprise_user"),
               inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RolesUserSupplierVO> rol_enterprise_user;
    
    @Column(name = "fecha_registro_proveedor", nullable = false)
    private Date regist_date_enterprise_user;
    
    @Column(name = "state_enterprise_user", nullable = false)
    private boolean state_enterprise_user;
    
    @Column(name = "image", nullable = false , length = 1000)
    private String image;
    
    @OneToMany(mappedBy = "enterprise_user", fetch = FetchType.EAGER)
    private Set<TransactionsVO> transactions;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "workforce",
               joinColumns = @JoinColumn(name = "chief_id"),
               inverseJoinColumns = @JoinColumn(name = "clerk_id"))
    private Set<EnterpriseUserVO> workforce;
	
	
	/*---------------------*/

	public EnterpriseUserVO() { 
		
		transactions = new HashSet<>();
		workforce = new HashSet<>();
		rol_enterprise_user = new HashSet<>();
	}


	public EnterpriseUserVO(Long id_enterprise_user, String name_enterprise_user, String password_enterprise_user,
			String username_enterprise_user, String lastname_enterprise_user, String email_enterprise_user,
			Set<RolesUserSupplierVO> rol_enterprise_user, Date regist_date_enterprise_user, boolean state_enterprise_user,
			String image, Set<TransactionsVO> transactions, Set<EnterpriseUserVO> workforce) {
		super();
		this.id_enterprise_user = id_enterprise_user;
		this.name_enterprise_user = name_enterprise_user;
		this.password_enterprise_user = password_enterprise_user;
		this.username_enterprise_user = username_enterprise_user;
		this.lastname_enterprise_user = lastname_enterprise_user;
		this.email_enterprise_user = email_enterprise_user;
		this.rol_enterprise_user = rol_enterprise_user;
		this.regist_date_enterprise_user = regist_date_enterprise_user;
		this.state_enterprise_user = state_enterprise_user;
		this.image = image;
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


	public String getPassword_enterprise_user() {
		return password_enterprise_user;
	}


	public void setPassword_enterprise_user(String password_enterprise_user) {
		this.password_enterprise_user = password_enterprise_user;
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


	public Set<RolesUserSupplierVO> getRol_enterprise_user() {
		return rol_enterprise_user;
	}


	public void setRol_enterprise_user(Set<RolesUserSupplierVO> rol_enterprise_user) {
		this.rol_enterprise_user = rol_enterprise_user;
	}


	public Date getRegist_date_enterprise_user() {
		return regist_date_enterprise_user;
	}


	public void setRegist_date_enterprise_user(Date regist_date_enterprise_user) {
		this.regist_date_enterprise_user = regist_date_enterprise_user;
	}


	public boolean isState_enterprise_user() {
		return state_enterprise_user;
	}


	public void setState_enterprise_user(boolean state_enterprise_user) {
		this.state_enterprise_user = state_enterprise_user;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Set<TransactionsVO> getTransactions() {
		return transactions;
	}


	public void setTransactions(Set<TransactionsVO> transactions) {
		this.transactions = transactions;
	}


	public Set<EnterpriseUserVO> getWorkforce() {
		return workforce;
	}


	public void setWorkforce(Set<EnterpriseUserVO> workforce) {
		this.workforce = workforce;
	}
	
}