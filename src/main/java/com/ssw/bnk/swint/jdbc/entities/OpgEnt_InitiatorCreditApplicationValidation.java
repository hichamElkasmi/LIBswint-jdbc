package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_InitiatorCreditApplicationValidation {
	
	private String applicationid;
	private String action;
	private String bankcode;
	
	public OpgEnt_InitiatorCreditApplicationValidation() {
		super();
	}

	public OpgEnt_InitiatorCreditApplicationValidation(String applicationid, String action, String bankcode) {
		super();
		this.applicationid = applicationid;
		this.action = action;
		this.bankcode = bankcode;
	}

	public String getApplicationid() {
		return applicationid;
	}

	public void setApplicationid(String applicationid) {
		this.applicationid = applicationid;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}
	
	
	
	

}
