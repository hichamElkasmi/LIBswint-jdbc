package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_FilterCustomerList;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;

public class OpgReq_CustomerList {
	
	private OpgEnt_Header header;
	private OpgEnt_FilterCustomerList filter;
	
	public OpgReq_CustomerList(OpgEnt_Header header, OpgEnt_FilterCustomerList filter) {
		super();
		this.header = header;
		this.filter = filter;
	}

	public OpgReq_CustomerList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OpgEnt_Header getHeader() {
		return header;
	}

	public void setHeader(OpgEnt_Header header) {
		this.header = header;
	}

	public OpgEnt_FilterCustomerList getFilter() {
		return filter;
	}

	public void setFilter(OpgEnt_FilterCustomerList filter) {
		this.filter = filter;
	}	

}
