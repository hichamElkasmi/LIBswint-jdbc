package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_FilterPosTerminalList;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;

public class OpgReq_PosTerminalList {
	
	private OpgEnt_Header header;
	private OpgEnt_FilterPosTerminalList filter;
	
	public OpgReq_PosTerminalList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OpgReq_PosTerminalList(OpgEnt_Header header, OpgEnt_FilterPosTerminalList filter) {
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
	public OpgEnt_FilterPosTerminalList getFilter() {
		return filter;
	}
	public void setFilter(OpgEnt_FilterPosTerminalList filter) {
		this.filter = filter;
	}
}
