package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_InitiatorAddChargeBack {
	
	private String bankcode ;
	private String card ;
	private String reference ;
	private String reason ;
	private String bin ;
	
	public OpgEnt_InitiatorAddChargeBack() {
		super();
	}

	public OpgEnt_InitiatorAddChargeBack(String bankcode, String card, String reference, String reason, String bin) {
		super();
		this.bankcode = bankcode;
		this.card = card;
		this.reference = reference;
		this.reason = reason;
		this.bin = bin;
	}

	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getBin() {
		return bin;
	}

	public void setBin(String bin) {
		this.bin = bin;
	}
	
	
	

}
