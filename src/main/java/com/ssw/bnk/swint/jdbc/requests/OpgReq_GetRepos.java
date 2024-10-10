package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_IniatorGetRepos;

public class OpgReq_GetRepos {
	
	private OpgEnt_Header header;
	private OpgEnt_IniatorGetRepos initiator;
	
	public OpgReq_GetRepos(OpgEnt_Header header, OpgEnt_IniatorGetRepos initiator) {
		super();
		this.header = header;
		this.initiator = initiator;
	}
	public OpgReq_GetRepos() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OpgEnt_Header getHeader() {
		return header;
	}
	public void setHeader(OpgEnt_Header header) {
		this.header = header;
	}
	public OpgEnt_IniatorGetRepos getInitiator() {
		return initiator;
	}
	public void setInitiator(OpgEnt_IniatorGetRepos initiator) {
		this.initiator = initiator;
	}
	
	

}
