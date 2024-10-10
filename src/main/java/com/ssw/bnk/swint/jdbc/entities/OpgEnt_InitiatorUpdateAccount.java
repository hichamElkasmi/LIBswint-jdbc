package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_InitiatorUpdateAccount {
	
	private String accountnumber;
	private String bankcode ;
	private String newaccountnumber;
	
	public OpgEnt_InitiatorUpdateAccount() {
		super();
	}

	public OpgEnt_InitiatorUpdateAccount(String accountnumber, String bankcode, String newaccountnumber) {
		super();
		this.accountnumber = accountnumber;
		this.bankcode = bankcode;
		this.newaccountnumber = newaccountnumber;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	public String getNewaccountnumber() {
		return newaccountnumber;
	}

	public void setNewaccountnumber(String newaccountnumber) {
		this.newaccountnumber = newaccountnumber;
	}
	
	

}
