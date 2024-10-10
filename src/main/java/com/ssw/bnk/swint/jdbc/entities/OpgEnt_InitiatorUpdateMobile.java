package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_InitiatorUpdateMobile {
	
	private String phonenumber;
	private String bankcode ;
	private String cardcode;
	
	public OpgEnt_InitiatorUpdateMobile() {
		super();
	}

	public OpgEnt_InitiatorUpdateMobile(String phonenumber, String bankcode, String cardcode) {
		super();
		this.phonenumber = phonenumber;
		this.bankcode = bankcode;
		this.cardcode = cardcode;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	public String getCardcode() {
		return cardcode;
	}

	public void setCardcode(String cardcode) {
		this.cardcode = cardcode;
	}
	
	

}
