package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_InitiatorReload;

public class OpgReq_Reload {
	
	private OpgEnt_Header header;
	private OpgEnt_InitiatorReload initiator;
	
	public OpgReq_Reload() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OpgReq_Reload(OpgEnt_Header header, OpgEnt_InitiatorReload initiator) {
		super();
		this.header = header;
		this.initiator = initiator;
	}
	public OpgEnt_Header getHeader() {
		return header;
	}
	public void setHeader(OpgEnt_Header header) {
		this.header = header;
	}
	public OpgEnt_InitiatorReload getInitiator() {
		return initiator;
	}
	public void setInitiator(OpgEnt_InitiatorReload initiator) {
		this.initiator = initiator;
	}
	
	

}
