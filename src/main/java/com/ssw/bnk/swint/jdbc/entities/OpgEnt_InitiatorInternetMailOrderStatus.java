package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_InitiatorInternetMailOrderStatus {
	
	private String ecommerce ;
	private String bankcode ;
	private String card ;
	
	public OpgEnt_InitiatorInternetMailOrderStatus() {
		super();
	}

	public OpgEnt_InitiatorInternetMailOrderStatus(String purchase_status, String bankcode, String limit, String amount,
			String currency, String idlimit, String card) {
		super();
		this.ecommerce = purchase_status;
		this.bankcode = bankcode;
		this.card = card;
	}

        public String getEcommerce() {
            return ecommerce;
        }

        public void setEcommerce(String ecommerce) {
            this.ecommerce = ecommerce;
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
	
	

}
