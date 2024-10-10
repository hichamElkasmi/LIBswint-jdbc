package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_FilterMerchantAppliList {
	
	private String mxpaccountnumber;
	private String bankaccountnumber;
	private String applicationid;
	private String applicationcode;
	private String branchcode;
	private String institution;
	private String start;
	private String end;
	
	public OpgEnt_FilterMerchantAppliList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OpgEnt_FilterMerchantAppliList(String mxpaccountnumber, String bankaccountnumber, String applicationid,
			String applicationcode, String branchcode, String institution, String start, String end) {
		super();
		this.mxpaccountnumber = mxpaccountnumber;
		this.bankaccountnumber = bankaccountnumber;
		this.applicationid = applicationid;
		this.applicationcode = applicationcode;
		this.branchcode = branchcode;
		this.institution = institution;
		this.start = start;
		this.end = end;
	}
	public String getMxpaccountnumber() {
		return mxpaccountnumber;
	}
	public void setMxpaccountnumber(String mxpaccountnumber) {
		this.mxpaccountnumber = mxpaccountnumber;
	}
	public String getBankaccountnumber() {
		return bankaccountnumber;
	}
	public void setBankaccountnumber(String bankaccountnumber) {
		this.bankaccountnumber = bankaccountnumber;
	}
	public String getApplicationid() {
		return applicationid;
	}
	public void setApplicationid(String applicationid) {
		this.applicationid = applicationid;
	}
	public String getApplicationcode() {
		return applicationcode;
	}
	public void setApplicationcode(String applicationcode) {
		this.applicationcode = applicationcode;
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
