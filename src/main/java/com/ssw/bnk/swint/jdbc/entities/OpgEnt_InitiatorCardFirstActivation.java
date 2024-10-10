package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_InitiatorCardFirstActivation {
	
	private String card;
	private String institution;
	
	public OpgEnt_InitiatorCardFirstActivation(String status, String expiry, String card, String institution) {
		super();
		this.card = card;
		this.institution = institution;
	}

	public OpgEnt_InitiatorCardFirstActivation(String status, String expiry, String card) {
		super();
		this.card = card;
	}

	public OpgEnt_InitiatorCardFirstActivation() {
		super();
		// TODO Auto-generated constructor stub
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
