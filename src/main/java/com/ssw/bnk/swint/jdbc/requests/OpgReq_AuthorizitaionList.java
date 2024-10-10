package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_FilterAuthorizitaionList;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;

public class OpgReq_AuthorizitaionList {
	
	private OpgEnt_Header header;
	private OpgEnt_FilterAuthorizitaionList filter;
	
	public OpgReq_AuthorizitaionList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OpgReq_AuthorizitaionList(OpgEnt_Header header, OpgEnt_FilterAuthorizitaionList filter) {
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
	public OpgEnt_FilterAuthorizitaionList getFilter() {
		return filter;
	}
	public void setFilter(OpgEnt_FilterAuthorizitaionList filter) {
		this.filter = filter;
	}
	
	

}
