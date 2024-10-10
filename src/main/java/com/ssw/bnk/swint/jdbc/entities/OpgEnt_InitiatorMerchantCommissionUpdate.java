package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_InitiatorMerchantCommissionUpdate {
	
	private String bankcode;
	private String merchantcode;
	private String mercommission;
	
	public OpgEnt_InitiatorMerchantCommissionUpdate() {
		super();
	}

	public OpgEnt_InitiatorMerchantCommissionUpdate(String bankcode, String merchantcode, String mercommission) {
		super();
		this.bankcode = bankcode;
		this.merchantcode = merchantcode;
		this.mercommission = mercommission;
	}

	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	public String getMerchantcode() {
		return merchantcode;
	}

	public void setMerchantcode(String merchantcode) {
		this.merchantcode = merchantcode;
	}

	public String getMercommission() {
		return mercommission;
	}

	public void setMercommission(String mercommission) {
		this.mercommission = mercommission;
	}
	
	
	

}
