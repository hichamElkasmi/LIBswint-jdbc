package com.ssw.bnk.swint.jdbc.requests;


import com.ssw.bnk.swint.jdbc.entities.OpgEnt_FilterGetListInterface;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;

public class OpgReq_InterfaceList {
	
	private OpgEnt_Header header;
	private OpgEnt_FilterGetListInterface filter;
	
	public OpgReq_InterfaceList() {
		super();
	}

	public OpgReq_InterfaceList(OpgEnt_Header header, OpgEnt_FilterGetListInterface filter) {
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

	public OpgEnt_FilterGetListInterface getFilter() {
		return filter;
	}

	public void setFilter(OpgEnt_FilterGetListInterface filter) {
		this.filter = filter;
	}
	
	
	
	

}
