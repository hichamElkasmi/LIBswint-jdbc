package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_FilterPrepaidApplicationList {
	
	private String customerid;
	private String nationalid;
	private String accountnumber;
	private String applicationcode;
	private String applicationid;
	private String branchcode;
	private String institution;
	private String start;
	private String end;
	
	public OpgEnt_FilterPrepaidApplicationList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OpgEnt_FilterPrepaidApplicationList(String customerid, String nationalid, String accountnumber,
			String applicationcode, String applicationid, String branchcode, String institution, String start,
			String end) {
		super();
		this.customerid = customerid;
		this.nationalid = nationalid;
		this.accountnumber = accountnumber;
		this.applicationcode = applicationcode;
		this.applicationid = applicationid;
		this.branchcode = branchcode;
		this.institution = institution;
		this.start = start;
		this.end = end;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getNationalid() {
		return nationalid;
	}

	public void setNationalid(String nationalid) {
		this.nationalid = nationalid;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getApplicationcode() {
		return applicationcode;
	}

	public void setApplicationcode(String applicationcode) {
		this.applicationcode = applicationcode;
	}

	public String getApplicationid() {
		return applicationid;
	}

	public void setApplicationid(String applicationid) {
		this.applicationid = applicationid;
	}

	public String getBranchcode() {
		return branchcode;
	}

	public void setBranchcode(String branchcode) {
		this.branchcode = branchcode;
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
