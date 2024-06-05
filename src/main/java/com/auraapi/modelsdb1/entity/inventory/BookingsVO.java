package com.auraapi.modelsdb1.entity.inventory;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.auraapi.modelsdb1.entity.users.UserPosVO;

import jakarta.persistence.*;

@Entity
@Table(name = "bookings_products_inventory")
public class BookingsVO implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_booking_product", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idbookingproduct;
	
	@Column(name = "date_booking", nullable = false)
	private Date datebooking;
	
	@Column(name = "description", nullable = false , length = 800)
	private String description;
	
	@OneToMany(mappedBy = "booking")
	private Set<ProductsVO> products;
	
	@ManyToOne
	@JoinColumn(name = "idpos", nullable = false)
	private UserPosVO clientpos;
	
	@Column(name = "state", nullable = false)
	private boolean state;
	
	@Column(name = "note", nullable = false , length = 800)
	private String note;
	
	@Column(name = "color_flag", nullable = true , length = 80)
	private String colorflag;
	
	@ManyToMany
	@JoinTable(name = "suppliers_bookings",
	joinColumns = @JoinColumn(name = "idbookingproduct"),
	inverseJoinColumns = @JoinColumn(name = "idsupplierproduct"))
	private Set<SupplierProductsVO> suppliers_bookings;
	
	
	public BookingsVO(  ) {
		
		products = new HashSet<ProductsVO>();
		suppliers_bookings = new HashSet<SupplierProductsVO>();
	}
	
	public BookingsVO( Long idbookingproduct, Date datebooking, String description,
			Set<ProductsVO> products, UserPosVO clientpos, boolean state, String note,
			String colorflag, Set<SupplierProductsVO> suppliers_bookings ) {
		
		super();
		this.idbookingproduct = idbookingproduct;
		this.datebooking = datebooking;
		this.description = description;
		this.products = products;
		this.clientpos = clientpos;
		this.state = state;
		this.note = note;
		this.colorflag = colorflag;
		this.suppliers_bookings = suppliers_bookings;
	}

	
	public Long getIdbookingproduct() {
		return idbookingproduct;
	}

	public void setIdbookingproduct(Long id) {
		this.idbookingproduct = id;
	}

	public Date getDatebooking() {
		return datebooking;
	}

	public void setDatebooking(Date datebooking) {
		this.datebooking = datebooking;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<ProductsVO> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductsVO> products) {
		this.products = products;
	}

	public UserPosVO getClientpos() {
		return clientpos;
	}

	public void setClientpos(UserPosVO clientpos) {
		this.clientpos = clientpos;
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

	public Set<SupplierProductsVO> getSuppliers_bookings() {
		return suppliers_bookings;
	}

	public void setSuppliers_bookings(Set<SupplierProductsVO> suppliers_bookings) {
		this.suppliers_bookings = suppliers_bookings;
	}
	
}
