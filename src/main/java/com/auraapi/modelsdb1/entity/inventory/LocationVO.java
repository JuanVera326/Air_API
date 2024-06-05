package com.auraapi.modelsdb1.entity.inventory;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "locations_products_inventory")
public class LocationVO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_location_product", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idlocationproduct;
	
	@Column(name = "name", nullable = false , length = 80)
	private String name;
	
	@Column(name = "description", nullable = false , length = 800)
	private String description;
	
	@Column(name = "state", nullable = false)
	private boolean state;
	
	@Column(name = "note", nullable = false , length = 800)
	private String note;
	
	@Column(name = "color_flag", nullable = true , length = 80)
	private String colorflag;
	
	@OneToOne(mappedBy = "location")
	private ProductsVO products;
	
	
	public LocationVO(  ) {}
	
	public LocationVO( Long idlocationproduct, String name, String description,
			boolean state, String note, String colorflag, ProductsVO products ) {
		
		super();
		this.idlocationproduct = idlocationproduct;
		this.name = name;
		this.description = description;
		this.state = state;
		this.note = note;
		this.colorflag = colorflag;
		this.products = products;
	}
	
	
	public Long getIdlocationproduct() {
		return idlocationproduct;
	}

	public void setIdlocationproduct(Long id) {
		this.idlocationproduct = id;
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

}
