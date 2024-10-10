package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_Renew {
	
	private String card;
	private String expiry;
	private String renew_fe;
	private String pin_recalcul_fee;
	private String pin_generation;
	private String institution;
	
	
	public OpgEnt_Renew(String card, String expiry, String renew_fe, String pin_recalcul_fee, String pin_generation,
			String institution) {
		super();
		this.card = card;
		this.expiry = expiry;
		this.renew_fe = renew_fe;
		this.pin_recalcul_fee = pin_recalcul_fee;
		this.pin_generation = pin_generation;
		this.institution = institution;
	}


	public OpgEnt_Renew() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getCard() {
		return card;
	}


	public void setCard(String card) {
		this.card = card;
	}


	public String getExpiry() {
		return expiry;
	}


	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}


	public String getRenew_fe() {
		return renew_fe;
	}


	public void setRenew_fe(String renew_fe) {
		this.renew_fe = renew_fe;
	}


	public String getPin_recalcul_fee() {
		return pin_recalcul_fee;
	}


	public void setPin_recalcul_fee(String pin_recalcul_fee) {
		this.pin_recalcul_fee = pin_recalcul_fee;
	}


	public String getPin_generation() {
		return pin_generation;
	}


	public void setPin_generation(String pin_generation) {
		this.pin_generation = pin_generation;
	}


	public String getInstitution() {
		return institution;
	}


	public void setInstitution(String institution) {
		this.institution = institution;
	}

}
