package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_InitiatorPrepaidAppliValidation {
	
	private String applicationid;
	private String action;
	private String institution;
	
	public OpgEnt_InitiatorPrepaidAppliValidation(String applicationid, String action, String institution) {
		super();
		this.applicationid = applicationid;
		this.action = action;
		this.institution = institution;
	}
	public OpgEnt_InitiatorPrepaidAppliValidation() {
		super();
		// TODO Auto-generated constructor stub
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
