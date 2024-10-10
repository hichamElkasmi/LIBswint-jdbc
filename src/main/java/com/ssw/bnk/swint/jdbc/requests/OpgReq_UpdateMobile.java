package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_InitiatorUpdateMobile;

public class OpgReq_UpdateMobile {
	
	private OpgEnt_Header header;
	private OpgEnt_InitiatorUpdateMobile initiator;
	
	public OpgReq_UpdateMobile() {
		super();
	}

	public OpgReq_UpdateMobile(OpgEnt_Header header, OpgEnt_InitiatorUpdateMobile initiator) {
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

	public OpgEnt_InitiatorUpdateMobile getInitiator() {
		return initiator;
	}

	public void setInitiator(OpgEnt_InitiatorUpdateMobile initiator) {
		this.initiator = initiator;
	}
	
	
	
	

}
