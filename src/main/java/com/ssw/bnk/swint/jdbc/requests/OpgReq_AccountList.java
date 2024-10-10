package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_FilterAccountList;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;

public class OpgReq_AccountList {
	
	private OpgEnt_Header header;
	private OpgEnt_FilterAccountList filter;
	
	
	public OpgReq_AccountList(OpgEnt_Header header, OpgEnt_FilterAccountList filter) {
		super();
		this.header = header;
		this.filter = filter;
	}
	public OpgReq_AccountList() {
		super();
	}
	public OpgEnt_Header getHeader() {
		return header;
	}
	public void setHeader(OpgEnt_Header header) {
		this.header = header;
	}
	public OpgEnt_FilterAccountList getFilter() {
		return filter;
	}
	public void setFilter(OpgEnt_FilterAccountList filter) {
		this.filter = filter;
	}
	
	

}
