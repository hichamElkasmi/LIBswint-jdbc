package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_InitiatorAccountTransfer {
	
	private String account;
	private String branch;
	private String transactiondate;
	private String institution;
	
	public OpgEnt_InitiatorAccountTransfer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OpgEnt_InitiatorAccountTransfer(String account, String branch, String transactiondate, String institution) {
		super();
		this.account = account;
		this.branch = branch;
		this.transactiondate = transactiondate;
		this.institution = institution;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getTransactiondate() {
		return transactiondate;
	}

	public void setTransactiondate(String transactiondate) {
		this.transactiondate = transactiondate;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}
	
}
