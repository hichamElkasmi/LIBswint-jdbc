package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_InitiatorManageAddress;

public class OpgReq_ManageAddress {
	
	private OpgEnt_Header header;
	private OpgEnt_InitiatorManageAddress initiator;
	
	public OpgReq_ManageAddress() {
		super();
	}

	public OpgReq_ManageAddress(OpgEnt_Header header, OpgEnt_InitiatorManageAddress initiator) {
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

	public OpgEnt_InitiatorManageAddress getInitiator() {
		return initiator;
	}

	public void setInitiator(OpgEnt_InitiatorManageAddress initiator) {
		this.initiator = initiator;
	}
	
	

}
