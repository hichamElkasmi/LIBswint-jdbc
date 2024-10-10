package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_InitiatorRestPin {
	
	private String expiry;
	private String card;
	private String institution;
	
	
	public OpgEnt_InitiatorRestPin(String expiry, String card, String institution) {
		super();
		this.expiry = expiry;
		this.card = card;
		this.institution = institution;
	}

	public OpgEnt_InitiatorRestPin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}
	
	
}
