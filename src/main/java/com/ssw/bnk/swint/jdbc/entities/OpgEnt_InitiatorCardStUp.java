package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_InitiatorCardStUp {
	
	
	private String status;
	private String expiry;
	private String card;
	private String institution;
	
	
	
	public OpgEnt_InitiatorCardStUp(String status, String expiry, String card, String institution) {
		super();
		this.status = status;
		this.expiry = expiry;
		this.card = card;
		this.institution = institution;
	}

	public OpgEnt_InitiatorCardStUp(String status, String expiry, String card) {
		super();
		this.status = status;
		this.expiry = expiry;
		this.card = card;
	}

	public OpgEnt_InitiatorCardStUp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
