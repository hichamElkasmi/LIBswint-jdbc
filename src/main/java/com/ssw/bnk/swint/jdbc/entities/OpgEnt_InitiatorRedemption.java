package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_InitiatorRedemption {
	
	private String card;
	private String institution;
	private String reason;
	private String fee;
	private String expiry;
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public OpgEnt_InitiatorRedemption() {
		super();
	}

	public OpgEnt_InitiatorRedemption(String card, String institution, String reason, String fee) {
		super();
		this.card = card;
		this.institution = institution;
		this.reason = reason;
		this.fee = fee;
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

        public String getExpiry() {
            return expiry;
        }

        public void setExpiry(String expiry) {
            this.expiry = expiry;
        }

}
