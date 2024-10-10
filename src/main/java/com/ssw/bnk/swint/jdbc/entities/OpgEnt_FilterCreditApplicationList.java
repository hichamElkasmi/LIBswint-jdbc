package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_FilterCreditApplicationList {
	
	private String customerid;
	private String applicationcode;
	private String applicationid;
	private String branchcode;
	private String bankcode;
	
	public OpgEnt_FilterCreditApplicationList() {
		super();
	}

	public OpgEnt_FilterCreditApplicationList(String customerid,
			String applicationcode, String applicationid, String branchcode, String bankcode) {
		super();
		this.customerid = customerid;

		this.applicationcode = applicationcode;
		this.applicationid = applicationid;
		this.branchcode = branchcode;
		this.bankcode = bankcode;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
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

	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}
	
	
	

}
