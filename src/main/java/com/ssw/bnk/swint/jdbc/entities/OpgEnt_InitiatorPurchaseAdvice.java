package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_InitiatorPurchaseAdvice {
	
	private String bankcode ;
	private String operation ;
	private String card ;
	private String procode ;
	private String transactioncode ;
	private String expirydate ;
	private String currency ;
	private String amount ;
	private String cvv  ;
	private String merchantcode ;
	private String moto;
	private String terminal;
	
	public OpgEnt_InitiatorPurchaseAdvice() {
		super();
	}



	public OpgEnt_InitiatorPurchaseAdvice(String bankcode, String operation, String card, String procode,
			String transactioncode, String expirydate, String currency, String amount, String cvv, String merchantcode,
			String moto, String terminal) {
		super();
		this.bankcode = bankcode;
		this.operation = operation;
		this.card = card;
		this.procode = procode;
		this.transactioncode = transactioncode;
		this.expirydate = expirydate;
		this.currency = currency;
		this.amount = amount;
		this.cvv = cvv;
		this.merchantcode = merchantcode;
		this.moto = moto;
		this.terminal = terminal;
	}



	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getProcode() {
		return procode;
	}

	public void setProcode(String procode) {
		this.procode = procode;
	}

	public String getTransactioncode() {
		return transactioncode;
	}

	public void setTransactioncode(String transactioncode) {
		this.transactioncode = transactioncode;
	}

	public String getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getMerchantcode() {
		return merchantcode;
	}

	public void setMerchantcode(String merchantcode) {
		this.merchantcode = merchantcode;
	}

	public String getMoto() {
		return moto;
	}

	public void setMoto(String moto) {
		this.moto = moto;
	}
	
	public String getTerminal() {
		return terminal;
	}





	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	
	

}
