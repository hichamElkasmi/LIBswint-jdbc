package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_InitiatorCheckBookRequest {

	private String account;
	private String checkbooktype;
	private String pages;
	private String transactiondate;
	private String institution;
	
	public OpgEnt_InitiatorCheckBookRequest(String account, String checkbooktype, String pages, String transactiondate,
			String institution) {
		super();
		this.account = account;
		this.checkbooktype = checkbooktype;
		this.pages = pages;
		this.transactiondate = transactiondate;
		this.institution = institution;
	}
	public OpgEnt_InitiatorCheckBookRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getCheckbooktype() {
		return checkbooktype;
	}
	public void setCheckbooktype(String checkbooktype) {
		this.checkbooktype = checkbooktype;
	}
	public String getPages() {
		return pages;
	}
	public void setPages(String pages) {
		this.pages = pages;
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
