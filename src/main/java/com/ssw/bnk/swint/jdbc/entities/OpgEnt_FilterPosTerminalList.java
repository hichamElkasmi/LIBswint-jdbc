package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_FilterPosTerminalList {
	
	private String terminalid; 
    private String institution;
    private String start;
	private String end;
	 
	public OpgEnt_FilterPosTerminalList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OpgEnt_FilterPosTerminalList(String terminalid, String institution, String start, String end) {
		super();
		this.terminalid = terminalid;
		this.institution = institution;
		this.start = start;
		this.end = end;
	}
	
	public String getTerminalid() {
		return terminalid;
	}
	public void setTerminalid(String terminalid) {
		this.terminalid = terminalid;
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
