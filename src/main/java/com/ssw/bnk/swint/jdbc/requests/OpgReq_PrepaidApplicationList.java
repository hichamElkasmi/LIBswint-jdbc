package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_FilterPrepaidApplicationList;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;

public class OpgReq_PrepaidApplicationList {
	
	private OpgEnt_Header header;
	private OpgEnt_FilterPrepaidApplicationList filter;
	
	public OpgReq_PrepaidApplicationList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OpgReq_PrepaidApplicationList(OpgEnt_Header header, OpgEnt_FilterPrepaidApplicationList filter) {
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
	public OpgEnt_FilterPrepaidApplicationList getFilter() {
		return filter;
	}
	public void setFilter(OpgEnt_FilterPrepaidApplicationList filter) {
		this.filter = filter;
	}
	
}
