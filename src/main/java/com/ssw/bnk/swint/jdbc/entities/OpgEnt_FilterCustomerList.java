package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_FilterCustomerList {
	
	private String customer;
	private String nationalid;
	private String institution;
	private String start;
	private String end;
	
	public OpgEnt_FilterCustomerList(String customer, String nationalid, String institution, String start, String end) {
		super();
		this.customer = customer;
		this.nationalid = nationalid;
		this.institution = institution;
		this.start = start;
		this.end = end;
	}

	public OpgEnt_FilterCustomerList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getNationalid() {
		return nationalid;
	}

	public void setNationalid(String nationalid) {
		this.nationalid = nationalid;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

}
