package com.auraapi.modelsdb1.entity.inventory;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.auraapi.modelsdb1.entity.users.EnterpriseUserVO;

import jakarta.persistence.*;

@Entity
@Table(name = "transactions_history_products_inventory")
public class TransactionHistoryVO implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_transaction_history_product")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idtransactionhistoryproduct;
	
	@Column(name = "description", nullable = false , length = 800)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "id_user_supplier")
	private EnterpriseUserVO usersuplier;
	
	@Column(name = "date_action", nullable = false)
	private Date dateaction;
	
	@Column(name = "state", nullable = false)
	private boolean state;
	
	@Column(name = "note", nullable = false , length = 800)
	private String note;
	
	@Column(name = "color_flag", nullable = true , length = 80)
	private String colorflag;
	
	@OneToMany(mappedBy = "history")
	private Set<TransactionsVO> transactions;
	
	
	public TransactionHistoryVO(  ) {
		
		transactions = new HashSet<TransactionsVO>();
	}
	
	public TransactionHistoryVO( Long idtransactionhistoryproduct, 
			TransactionsVO transaction, String description, 
			EnterpriseUserVO usersuplier, Date dateaction, boolean state, 
			String note, String colorflag, Set<TransactionsVO> transactions ) {
		
		super();
		this.idtransactionhistoryproduct = idtransactionhistoryproduct;
		this.description = description;
		this.usersuplier = usersuplier;
		this.dateaction = dateaction;
		this.state = state;
		this.note = note;
		this.colorflag = colorflag;
		this.transactions = transactions;
	}
	
	
	public Long getIdtransactionhistoryproduct() {
		return idtransactionhistoryproduct;
	}

	public void setIdtransactionhistoryproduct(Long id) {
		this.idtransactionhistoryproduct = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EnterpriseUserVO getUserEnterprise() {
		return usersuplier;
	}

	public void setUserEnterprise(EnterpriseUserVO usersuplier) {
		this.usersuplier = usersuplier;
	}

	public Date getDateaction() {
		return dateaction;
	}

	public void setDateaction(Date dateaction) {
		this.dateaction = dateaction;
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

	public Set<TransactionsVO> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<TransactionsVO> transactions) {
		this.transactions = transactions;
	}

}
