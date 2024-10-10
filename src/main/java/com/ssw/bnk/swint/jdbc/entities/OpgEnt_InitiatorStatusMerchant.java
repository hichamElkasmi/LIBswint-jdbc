package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_InitiatorStatusMerchant {
	
	private String bankcode;
	private String merchantID;
	private String status;
	
	public OpgEnt_InitiatorStatusMerchant() {
		super();
	}

	public OpgEnt_InitiatorStatusMerchant(String bankcode, String merchantID, String status) {
		super();
		this.bankcode = bankcode;
		this.merchantID = merchantID;
		this.status = status;
	}

	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

        public void setMerchantID(String merchantID) {
            this.merchantID = merchantID;
        }

        public String getMerchantID() {
            return merchantID;
        }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
