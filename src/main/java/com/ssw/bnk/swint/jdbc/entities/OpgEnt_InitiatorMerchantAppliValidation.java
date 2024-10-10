package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_InitiatorMerchantAppliValidation {
	
	private String applicationid;
	private String action;
	private String institution;
	
	public OpgEnt_InitiatorMerchantAppliValidation() {
		super();
	}
	public OpgEnt_InitiatorMerchantAppliValidation(String applicationid, String action, String institution) {
		super();
		this.applicationid = applicationid;
		this.action = action;
		this.institution = institution;
	}
	public String getApplicationid() {
		return applicationid;
	}
	public void setApplicationid(String applicationid) {
		this.applicationid = applicationid;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}

}
