package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_InitiatorReplacement {
	

    private String card;
    private String expiry;
    private String replacement_fee;
    private String pin_recalcul_fee;
    private String new_pan;
    private String pin_generation;
    private String replacement_reason;
    private String name_in_card;
    private String institution;
    private String destination;
	
	public OpgEnt_InitiatorReplacement(String card, String expiry, String replacement_fee, String pin_recalcul_fee,
			String new_pan, String pin_generation, String replacement_reason, String name_in_card, String institution, String destination) {
		super();
		this.card = card;
		this.expiry = expiry;
		this.replacement_fee = replacement_fee;
		this.pin_recalcul_fee = pin_recalcul_fee;
		this.new_pan = new_pan;
		this.pin_generation = pin_generation;
		this.replacement_reason = replacement_reason;
		this.name_in_card = name_in_card;
		this.institution = institution;
		this.destination = destination;
	}

	public OpgEnt_InitiatorReplacement() {
		super();
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
	public String getReplacement_fee() {
		return replacement_fee;
	}
	public void setReplacement_fee(String replacement_fee) {
		this.replacement_fee = replacement_fee;
	}
	public String getPin_recalcul_fee() {
		return pin_recalcul_fee;
	}
	public void setPin_recalcul_fee(String pin_recalcul_fee) {
		this.pin_recalcul_fee = pin_recalcul_fee;
	}
	public String getNew_pan() {
		return new_pan;
	}
	public void setNew_pan(String new_pan) {
		this.new_pan = new_pan;
	}
	public String getPin_generation() {
		return pin_generation;
	}
	public void setPin_generation(String pin_generation) {
		this.pin_generation = pin_generation;
	}
	public String getReplacement_reason() {
		return replacement_reason;
	}
	public void setReplacement_reason(String replacement_reason) {
		this.replacement_reason = replacement_reason;
	}
	public String getName_in_card() {
		return name_in_card;
	}
	public void setName_in_card(String name_in_card) {
		this.name_in_card = name_in_card;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

	
}
