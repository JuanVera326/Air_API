package com.auraapi.modelsdb1.entity.inventory;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "products_inventory")
public class ProductsVO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_product", nullable = false)
	private Long idproduct;
	
	@Column(name = "name", nullable = false , length = 80)
	private String name;
	
	@Column(name = "price_unit", nullable = false)
	private double priceunit;
	
	@Column(name = "amount", nullable = false)
	private int amount;
	
	@ManyToMany
	@JoinTable(name = "categories_products",
	joinColumns = @JoinColumn(name = "idproduct"),
	inverseJoinColumns = @JoinColumn(name = "idcategoryproduct"))
	private Set<CategoryVO> categories;
	
	@ManyToMany
	@JoinTable(name = "suppliers_products",
	joinColumns = @JoinColumn(name = "idproduct"),
	inverseJoinColumns = @JoinColumn(name = "idsupplierproduct"))
	private Set<SupplierProductsVO> suppliers;
	
	@OneToOne
	@JoinColumn(name = "idlocationproduct")
	private LocationVO location;
	
	@Column(name = "state", nullable = false)
	private boolean state;
	
	@Column(name = "note", nullable = false , length = 800)
	private String note;
	
	@Column(name = "color_flag", nullable = true , length = 80)
	private String colorflag;
	
	@ManyToOne
	@JoinColumn(name = "idtransactionproduct", nullable = true)
	private TransactionsVO transaction;
	
	@ManyToOne
	@JoinColumn(name = "idbookingproduct", nullable = true)
	private BookingsVO booking;
	
	
	public ProductsVO (  ) { 
		suppliers = new HashSet<SupplierProductsVO>(); 
		categories = new HashSet<CategoryVO>();
	}
	
	public ProductsVO ( Long idproduct, String name, double priceunit, int amount,
			Set<CategoryVO> categories, Set<SupplierProductsVO> suppliers, 
			LocationVO location, boolean state, String note, String colorflag,
			TransactionsVO transaction, BookingsVO booking ) {
		
		super();
		this.idproduct = idproduct;
		this.name = name;
		this.priceunit = priceunit;
		this.amount = amount;
		this.categories = categories;
		this.suppliers = suppliers;
		this.location = location;
		this.state = state;
		this.note = note;
		this.colorflag = colorflag;
		this.transaction = transaction;
		this.booking = booking;
	}

	
	public Long getIdproduct() {
		return idproduct;
	}

	public void setIdproduct(Long id) {
		this.idproduct = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPriceunit() {
		return priceunit;
	}

	public void setPriceunit(double priceunit) {
		this.priceunit = priceunit;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Set<CategoryVO> getCategories() {
		return categories;
	}

	public void setCategories(Set<CategoryVO> categories) {
		this.categories = categories;
	}

	public Set<SupplierProductsVO> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(Set<SupplierProductsVO> suppliers) {
		this.suppliers = suppliers;
	}

	public LocationVO getLocation() {
		return location;
	}

	public void setLocation(LocationVO location) {
		this.location = location;
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

	public TransactionsVO getTransaction() {
		return transaction;
	}

	public void setTransaction(TransactionsVO transaction) {
		this.transaction = transaction;
	}

	public BookingsVO getBooking() {
		return booking;
	}

	public void setBooking(BookingsVO booking) {
		this.booking = booking;
	}
	
}
