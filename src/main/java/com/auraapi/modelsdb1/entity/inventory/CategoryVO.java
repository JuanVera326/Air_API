package com.auraapi.modelsdb1.entity.inventory;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "categories_products_inventory")
public class CategoryVO implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_category_product", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcategoryproduct;
	
	@Column(name = "name", nullable = false , length = 80)
	private String name;
	
	@Column(name = "description", nullable = false , length = 800)
	private String description;
	
	@Column(name = "state")
	private boolean state;
	
	@Column(name = "note", nullable = false , length = 800)
	private String note;
	
	@Column(name = "color_flag", nullable = true , length = 80)
	private String colorflag;
	
	@ManyToMany(mappedBy = "categories")
	private Set<ProductsVO> products;
	
	
	
	public CategoryVO(  ) {
		products = new HashSet<ProductsVO>();
	}
	
	public CategoryVO( Long idcategoryproduct, String name, String description, boolean state, 
			String note, String colorflag, Set<ProductsVO> products ) {
		
		super();
		this.idcategoryproduct = idcategoryproduct;
		this.name = name;
		this.description = description;
		this.state = state;
		this.note = note;
		this.colorflag = colorflag;
		this.products = products;
	}
	
	
	public Long getIdcategoryproduct() {
		return idcategoryproduct;
	}

	public void setIdcategoryproduct(Long id) {
		this.idcategoryproduct = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
