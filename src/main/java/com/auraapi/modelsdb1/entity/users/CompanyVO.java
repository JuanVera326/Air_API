package com.auraapi.modelsdb1.entity.users;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "companies")
public class CompanyVO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "names", nullable = false , length = 80)
	private String name_company;
	
	@Column(name = "ruc_company", nullable = false , length = 80)
	private String ruc;
	
	@Column(name = "adress", nullable = false , length = 800)
	private String address;
	
	@Column(name = "email", nullable = false , length = 100)
	private String email;
	
	@Column(name = "phone", nullable = false , length = 30)
	private String phone;
	
	@Column(name = "type_activity", nullable = false , length = 256)
	private String type_activity;
	
	@Column(name = "type_taxpayer", nullable = false , length = 80)
	private String type_taxpayer;
	
	@Column(name = "date_regist", nullable = false)
	private Date date_regist;
	
	@OneToOne
	@JoinColumn(name = "id_user_supplier", nullable = true)
	private EnterpriseUserVO owner; // REPRESENTANTE LEGAL 
	
	@Column(name = "companie_state", nullable = false)
	private boolean state;
	
	
	public CompanyVO(Long id, String name_company, String ruc, String address, String email, String phone,
			String type_activity, String type_taxpayer, Date date_regist, EnterpriseUserVO owner, boolean state) {
		super();
		this.id = id;
		this.name_company = name_company;
		this.ruc = ruc;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.type_activity = type_activity;
		this.type_taxpayer = type_taxpayer;
		this.date_regist = date_regist;
		this.owner = owner;
		this.state = state;
	}
	
	public CompanyVO() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName_company() {
		return name_company;
	}

	public void setName_company(String name_company) {
		this.name_company = name_company;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getType_activity() {
		return type_activity;
	}

	public void setType_activity(String type_activity) {
		this.type_activity = type_activity;
	}

	public String getType_taxpayer() {
		return type_taxpayer;
	}

	public void setType_taxpayer(String type_taxpayer) {
		this.type_taxpayer = type_taxpayer;
	}

	public Date getDate_regist() {
		return date_regist;
	}

	public void setDate_regist(Date date_regist) {
		this.date_regist = date_regist;
	}

	public EnterpriseUserVO getOwner() {
		return owner;
	}

	public void setOwner(EnterpriseUserVO owner) {
		this.owner = owner;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
}
