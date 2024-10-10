package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_FilterPosApplicationList {
	
	private String applicationid; 
    private String institution;
    private String start;
	private String end;
	 
	public OpgEnt_FilterPosApplicationList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OpgEnt_FilterPosApplicationList(String applicationid, String institution, String start, String end) {
		super();
		this.applicationid = applicationid;
		this.institution = institution;
		this.start = start;
		this.end = end;
	}
	
	public String getApplicationid() {
		return applicationid;
	}
	public void setApplicationid(String applicationid) {
		this.applicationid = applicationid;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
}
