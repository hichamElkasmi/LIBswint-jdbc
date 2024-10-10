package com.ssw.bnk.swint.jdbc.requests;


import com.ssw.bnk.swint.jdbc.entities.OpgEnt_FilterCreditApplicationList;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;

public class OpgReq_CreditApplicationList {
	
	private OpgEnt_Header header;
	private OpgEnt_FilterCreditApplicationList filter;
	
	public OpgReq_CreditApplicationList() {
		super();
	}

	public OpgReq_CreditApplicationList(OpgEnt_Header header, OpgEnt_FilterCreditApplicationList filter) {
		super();
		this.header = header;
		this.filter = filter;
	}

	public OpgEnt_Header getHeader() {
		return header;
	}

	public void setHeader(OpgEnt_Header header) {
		this.header = header;
	}

	public OpgEnt_FilterCreditApplicationList getFilter() {
		return filter;
	}

	public void setFilter(OpgEnt_FilterCreditApplicationList filter) {
		this.filter = filter;
	}
	
	
	

}
