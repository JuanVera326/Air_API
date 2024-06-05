package com.auraapi.modelsdb1.entity.inventory;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "suppliers_products_inventory")
public class SupplierProductsVO implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_supplier_product")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idsupplierproduct;
	
	@Column(name = "business_name", nullable = false , length = 100)
	private String businessname;
	
	@Column(name = "phone", nullable = false , length = 30)
	private String phone;
	
	@Column(name = "address", nullable = false , length = 250)
	private String address;
	
	@Column(name = "email", nullable = false , length = 100)
	private String email;
	
	@Column(name = "state", nullable = false)
	private boolean state;
	
	@Column(name = "note", nullable = false , length = 800)
	private String note;
	
	@Column(name = "color_flag", nullable = true , length = 80)
	private String colorflag;
	
	@ManyToMany(mappedBy = "suppliers")
	private Set<ProductsVO> products;
	
	@ManyToMany(mappedBy = "suppliers_bookings")
	private Set<BookingsVO> bookings;

	
	public SupplierProductsVO (  ) {
		
		products = new HashSet<ProductsVO>();
	}
	
	public SupplierProductsVO ( Long idsupplierproduct, String businessname, String phone,
			String address, String email, boolean state, String note, String colorflag,
			Set<ProductsVO> products) {
		
		super();
		this.idsupplierproduct = idsupplierproduct;
		this.businessname = businessname;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.state = state;
		this.note = note;
		this.colorflag = colorflag;
		this.products = products;
	}
	

	public Long getIdsupplierproduct() {
		return idsupplierproduct;
	}

	public void setIdsupplierproduct(Long id) {
		this.idsupplierproduct = id;
	}

	public String getBusinessname() {
		return businessname;
	}

	public void setBusinessname(String businessname) {
		this.businessname = businessname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getColorflag() {
		return colorflag;
	}

	public void setColorflag(String colorflag) {
		this.colorflag = colorflag;
	}

	public Set<ProductsVO> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductsVO> products) {
		this.products = products;
	}
	
}
