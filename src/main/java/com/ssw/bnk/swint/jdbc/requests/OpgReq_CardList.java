package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_FilterCardList;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;

public class OpgReq_CardList {
	
	private OpgEnt_Header header;
	private OpgEnt_FilterCardList filter;
	
	public OpgReq_CardList(OpgEnt_Header header, OpgEnt_FilterCardList filter) {
		super();
		this.header = header;
		this.filter = filter;
	}
	
	public OpgReq_CardList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OpgEnt_Header getHeader() {
		return header;
	}
	public void setHeader(OpgEnt_Header header) {
		this.header = header;
	}
	public OpgEnt_FilterCardList getFilter() {
		return filter;
	}
	public void setFilter(OpgEnt_FilterCardList filter) {
		this.filter = filter;
	}
	

}
