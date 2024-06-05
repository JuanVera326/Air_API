package com.auraapi.modelsdb1.entity.inventory;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.auraapi.modelsdb1.entity.users.EnterpriseUserVO;

import jakarta.persistence.*;

@Entity
@Table(name = "transactions_products_inventory")
public class TransactionsVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_transaction_product")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idtransactionproduct;
	
	@Column(name = "datetransaction", nullable = false)
	private Date datetransaction;
	
	@Column(name = "description", nullable = false , length = 800)
	private String description;
	
	@Column(name = "type", nullable = false)
	private int type;

	@OneToMany(mappedBy = "transaction")
	private Set<ProductsVO> products;
	
	@Column(name = "amount", nullable = false)
	private int amount;
	
	@Column(name = "state", nullable = false)
	private boolean state;
	
	@Column(name = "note", nullable = false , length = 800)
	private String note;
	
	@Column(name = "color_flag", nullable = true , length = 80)
	private String colorflag;
	
	@ManyToOne
	@JoinColumn(name = "idtransactionhistoryproduct")
	private TransactionHistoryVO history;
	
	@ManyToOne
	@JoinColumn(name = "id_enterprise_user")
	private EnterpriseUserVO enterprise_user;
	
	
	public TransactionsVO(  ) {
		
		products = new HashSet<>();
	}
	
	public TransactionsVO( Long idtransactionproduct, Date datetransaction,
			String description, int type, Set<ProductsVO> products, int amount, 
			boolean state, String note, String colorflag, TransactionHistoryVO history,
			EnterpriseUserVO enterprise_user ) {
		
		super();
		this.idtransactionproduct = idtransactionproduct;
		this.datetransaction = datetransaction;
		this.description = description;
		this.type = type;
		this.products = products;
		this.amount = amount;
		this.state = state;
		this.note = note;
		this.colorflag = colorflag;
		this.history = history;
		this.enterprise_user = enterprise_user;
	}

	
	public Long getIdtransactionproduct() {
		return idtransactionproduct;
	}

	public void setIdtransactionproduct(Long id) {
		this.idtransactionproduct = id;
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

	public Set<ProductsVO> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductsVO> products) {
		this.products = products;
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

	public TransactionHistoryVO getHistory() {
		return history;
	}

	public void setHistory(TransactionHistoryVO history) {
		this.history = history;
	}

	public EnterpriseUserVO getEnterprise_user() {
		return enterprise_user;
	}

	public void setEnterprise_user(EnterpriseUserVO enterprise_user) {
		this.enterprise_user = enterprise_user;
	}
	
}
