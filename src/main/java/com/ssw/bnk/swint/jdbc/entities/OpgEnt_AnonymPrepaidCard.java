package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_AnonymPrepaidCard {
	
	public String  bankcode ;
	public String  currencyid ;
	public String  cardprogramcode ;
	public String  prepaidprogramcode ;
	public String  quantity;
	public String  branchcode ;
	public String  cardcategory ;
	public String  target_audience ;
	public String  initamount ;
	
	public OpgEnt_AnonymPrepaidCard() {
		super();
	}

	public OpgEnt_AnonymPrepaidCard(String bankcode, String currencyid, String cardprogramcode,
			String prepaidprogramcode, String quantity, String branchcode, String cardcategory, String target_audience,
			String initamount) {
		super();
		this.bankcode = bankcode;
		this.currencyid = currencyid;
		this.cardprogramcode = cardprogramcode;
		this.prepaidprogramcode = prepaidprogramcode;
		this.quantity = quantity;
		this.branchcode = branchcode;
		this.cardcategory = cardcategory;
		this.target_audience = target_audience;
		this.initamount = initamount;
	}

	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	public String getCurrencyid() {
		return currencyid;
	}

	public void setCurrencyid(String currencyid) {
		this.currencyid = currencyid;
	}

	public String getCardprogramcode() {
		return cardprogramcode;
	}

	public void setCardprogramcode(String cardprogramcode) {
		this.cardprogramcode = cardprogramcode;
	}

	public String getPrepaidprogramcode() {
		return prepaidprogramcode;
	}

	public void setPrepaidprogramcode(String prepaidprogramcode) {
		this.prepaidprogramcode = prepaidprogramcode;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getBranchcode() {
		return branchcode;
	}

	public void setBranchcode(String branchcode) {
		this.branchcode = branchcode;
	}

	public String getCardcategory() {
		return cardcategory;
	}

	public void setCardcategory(String cardcategory) {
		this.cardcategory = cardcategory;
	}

	public String getTarget_audience() {
		return target_audience;
	}

	public void setTarget_audience(String target_audience) {
		this.target_audience = target_audience;
	}

	public String getInitamount() {
		return initamount;
	}

	public void setInitamount(String initamount) {
		this.initamount = initamount;
	}

	
	
	
	
	

}
