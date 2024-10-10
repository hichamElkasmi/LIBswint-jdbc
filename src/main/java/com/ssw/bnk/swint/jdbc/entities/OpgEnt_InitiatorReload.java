package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_InitiatorReload {
	
	private String card;
	private String institution;
	private String currency;
	private String reloadamount;
	private String reloadfee;
	private String reloadaccountnumber;
	private String paymentmode;
	
	public OpgEnt_InitiatorReload() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OpgEnt_InitiatorReload(String card, String institution, String currency, String reloadamount,
			String reloadfee, String reloadaccountnumber, String paymentmode) {
		super();
		this.card = card;
		this.institution = institution;
		this.currency = currency;
		this.reloadamount = reloadamount;
		this.reloadfee = reloadfee;
		this.reloadaccountnumber = reloadaccountnumber;
		this.paymentmode = paymentmode;
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
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getReloadamount() {
		return reloadamount;
	}
	public void setReloadamount(String reloadamount) {
		this.reloadamount = reloadamount;
	}
	public String getReloadfee() {
		return reloadfee;
	}
	public void setReloadfee(String reloadfee) {
		this.reloadfee = reloadfee;
	}
	public String getReloadaccountnumber() {
		return reloadaccountnumber;
	}
	public void setReloadaccountnumber(String reloadaccountnumber) {
		this.reloadaccountnumber = reloadaccountnumber;
	}
	public String getPaymentmode() {
		return paymentmode;
	}
	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}

}
