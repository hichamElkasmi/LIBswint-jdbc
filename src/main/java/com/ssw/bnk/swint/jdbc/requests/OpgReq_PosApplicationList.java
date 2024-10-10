package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_FilterPosApplicationList;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;

public class OpgReq_PosApplicationList {
	
	private OpgEnt_Header header;
	private OpgEnt_FilterPosApplicationList filter;
	
	public OpgReq_PosApplicationList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OpgReq_PosApplicationList(OpgEnt_Header header, OpgEnt_FilterPosApplicationList filter) {
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

	public OpgEnt_FilterPosApplicationList getFilter() {
		return filter;
	}

	public void setFilter(OpgEnt_FilterPosApplicationList filter) {
		this.filter = filter;
	}
	
}
