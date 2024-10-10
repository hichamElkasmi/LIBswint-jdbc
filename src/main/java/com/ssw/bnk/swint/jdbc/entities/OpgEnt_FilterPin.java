package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_FilterPin {

	private String card;
	private String cardcode;
	private String institution;

	public OpgEnt_FilterPin(String card, String cardcode, String institution) {
		super();
		this.card = card;
		this.cardcode = cardcode;
		this.institution = institution;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getCardcode() {
		return cardcode;
	}

	public void setCardcode(String cardcode) {
		this.cardcode = cardcode;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	@Override
	public String toString() {
		return "OpgEnt_FilterPin [card=" + card + ", cardcode=" + cardcode + ", institution=" + institution + "]";
	}

}
