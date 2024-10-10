package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_FilterMerchantTerminalsList {

	private String merchantId;
	private String institution;

	
	
	public OpgEnt_FilterMerchantTerminalsList() {
		super();
	}

	public OpgEnt_FilterMerchantTerminalsList(String merchantId, String institution) {
		super();
		this.merchantId = merchantId;
		this.institution = institution;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	@Override
	public String toString() {
		return "OpgEnt_FilterMerchantTerminalsList [merchantId=" + merchantId + ", institution=" + institution + "]";
	}

}
