package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_InitiatorRiskCardUpdate {
	
	private String bankcode ;
	private String card ;
	private String riskcode ;
	
	public OpgEnt_InitiatorRiskCardUpdate() {
		super();
	}

	public OpgEnt_InitiatorRiskCardUpdate(String bankcode, String card, String riskcode) {
		super();
		this.bankcode = bankcode;
		this.card = card;
		this.riskcode = riskcode;
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

	public String getRiskcode() {
		return riskcode;
	}

	public void setRiskcode(String riskcode) {
		this.riskcode = riskcode;
	}
	
	
	

}
