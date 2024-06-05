package com.auraapi.modelsdb1.dto;

import java.util.Date;
import java.util.Set;

public class TransactionsDTO {
	
	private Long idtransactionproduct;
    private Date datetransaction;
    private String description;
    private int type;
    private int amount;
    private boolean state;
    private String note;
    private String colorflag;
    private Set<ProductsDTO> products;
    private Long historyId;
    private Long enterpriseUserId;
    
	public TransactionsDTO() {}

	public TransactionsDTO(Long idtransactionproduct, Date datetransaction, String description, int type, int amount,
			boolean state, String note, String colorflag, Set<ProductsDTO> products, Long historyId,
			Long enterpriseUserId) {
		super();
		this.idtransactionproduct = idtransactionproduct;
		this.datetransaction = datetransaction;
		this.description = description;
		this.type = type;
		this.amount = amount;
		this.state = state;
		this.note = note;
		this.colorflag = colorflag;
		this.products = products;
		this.historyId = historyId;
		this.enterpriseUserId = enterpriseUserId;
	}

	public Long getIdtransactionproduct() {
		return idtransactionproduct;
	}

	public void setIdtransactionproduct(Long idtransactionproduct) {
		this.idtransactionproduct = idtransactionproduct;
	}

	public Date getDatetransaction() {
		return datetransaction;
	}

	public void setDatetransaction(Date datetransaction) {
		this.datetransaction = datetransaction;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
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

	public Set<ProductsDTO> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductsDTO> products) {
		this.products = products;
	}

	public Long getHistoryId() {
		return historyId;
	}

	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
	}

	public Long getEnterpriseUserId() {
		return enterpriseUserId;
	}

	public void setEnterpriseUserId(Long enterpriseUserId) {
		this.enterpriseUserId = enterpriseUserId;
	}
    
}
