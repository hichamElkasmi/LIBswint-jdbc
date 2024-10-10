package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_FilterCardRisk {
    
	private String card;
	private String bankcode;

	public OpgEnt_FilterCardRisk(String cardCode, String cardNumber, String bankcode, String start, String end) {
		super();
		this.card = cardNumber;
		this.bankcode = bankcode;
	}

        public String getCard() {
            return card;
        }

        public String getBankcode() {
            return bankcode;
        }

        public void setCard(String card) {
            this.card = card;
        }

        public void setBankcode(String bankcode) {
            this.bankcode = bankcode;
        }

}
