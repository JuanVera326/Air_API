package com.auraapi.modelsdb1.entity.users;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.auraapi.modelsdb1.entity.inventory.BookingsVO;

import jakarta.persistence.*;

@Entity
@Table(name = "users_pos")
public class UserPosVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "idpos", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idpos;
	
	@Column(name = "names", nullable = false , length = 80)
	private String names;
	
	@Column(name = "lastnames", nullable = false , length = 80)
	private String lastnames;
	
	@Column(name = "idnms", nullable = false , length = 80)
	private String idnms;
	
	@Column(name = "address", nullable = true , length = 80)
	private String address;
	
	@Column(name = "city", nullable = true , length = 80)
	private String city;
	
	@Column(name = "province", nullable = true , length = 80)
	private String province;
	
	@Column(name = "postal", nullable = true , length = 80)
	private String postal;
	
	@Column(name = "country", nullable = false , length = 80)
	private String country;
	
	@Column(name = "phone", nullable = false , length = 30)
	private String phone;
	
	@Column(name = "email", nullable = false , length = 100)
	private String email;
	
	@Column(name = "lastservice", nullable = false)
	private Date lastservice;
	
	@Column(name = "billinginfo", nullable = false , length = 80)
	private String billinginfo;
	
	@Column(name = "shoppinghidtory", nullable = false , length = 80)
	private Set<Object> shoppinghistory;
	
	@OneToMany(mappedBy = "clientpos")
	private Set<BookingsVO> bookings;
	
	@Column(name = "state", nullable = false)
	private boolean state;
	
	@Column(name = "note", nullable = true , length = 800)
	private String note;
	
	
	public UserPosVO(  ) {
		
		shoppinghistory = new HashSet<Object>();
		bookings = new HashSet<BookingsVO>();
	}
	
	public UserPosVO( Long idpos, String name, String lastnames, String idnms,
			String address,String city, String province, String postal, String country, String phone,
			String email, Date lastservice, String billinginfo,
			Set<Object> shoppinghistory, Set<BookingsVO> bookings, boolean state, String note ) {
		
		super();
		this.idpos = idpos;
		this.names = name;
		this.lastnames = lastnames;
		this.idnms = idnms;
		this.address = address;
		this.city = city;
		this.province = province;
		this.postal = postal;
		this.country = country;
		this.phone = phone;
		this.lastservice = lastservice;
		this.billinginfo = billinginfo;
		this.shoppinghistory = shoppinghistory;
		this.bookings = bookings;
		this.state = state;
		this.note = note;
	}
	

	public Long getIdpos() {
		return idpos;
	}

	public void setIdpos(Long idpos) {
		this.idpos = idpos;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getLastnames() {
		return lastnames;
	}

	public void setLastnames(String lastnames) {
		this.lastnames = lastnames;
	}

	public String getIdnms() {
		return idnms;
	}

	public void setIdnms(String idnms) {
		this.idnms = idnms;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getLastservice() {
		return lastservice;
	}

	public void setLastservice(Date lastservice) {
		this.lastservice = lastservice;
	}

	public String getBillinginfo() {
		return billinginfo;
	}

	public void setBillinginfo(String billinginfo) {
		this.billinginfo = billinginfo;
	}

	public Set<Object> getShoppinghistory() {
		return shoppinghistory;
	}

	public void setShoppinghistory(Set<Object> shoppinghistory) {
		this.shoppinghistory = shoppinghistory;
	}

	public Set<BookingsVO> getBookings() {
		return bookings;
	}

	public void setBookings(Set<BookingsVO> bookings) {
		this.bookings = bookings;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
