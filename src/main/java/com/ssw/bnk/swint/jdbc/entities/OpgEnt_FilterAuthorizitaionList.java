package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_FilterAuthorizitaionList {
	
	private String institution;
	private String idtrans;
	private String startdate;
	private String enddate;
	private String transactiontype;
	private String start;
	private String end;
	
	public OpgEnt_FilterAuthorizitaionList(String institution, String idtrans, String startdate, String enddate,
			String transactiontype, String start, String end) {
		super();
		this.institution = institution;
		this.idtrans = idtrans;
		this.startdate = startdate;
		this.enddate = enddate;
		this.transactiontype = transactiontype;
		this.start = start;
		this.end = end;
	}
	public OpgEnt_FilterAuthorizitaionList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getIdtrans() {
		return idtrans;
	}
	public void setIdtrans(String idtrans) {
		this.idtrans = idtrans;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getTransactiontype() {
		return transactiontype;
	}
	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
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
