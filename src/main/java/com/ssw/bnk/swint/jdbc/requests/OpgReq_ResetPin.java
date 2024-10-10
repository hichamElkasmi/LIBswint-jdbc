package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_InitiatorRestPin;

public class OpgReq_ResetPin {
	
	private OpgEnt_Header header;
	private OpgEnt_InitiatorRestPin initiator;
	
	public OpgReq_ResetPin(OpgEnt_Header header, OpgEnt_InitiatorRestPin initiator) {
		super();
		this.header = header;
		this.initiator = initiator;
	}

	public OpgReq_ResetPin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OpgEnt_Header getHeader() {
		return header;
	}

	public void setHeader(OpgEnt_Header header) {
		this.header = header;
	}

	public OpgEnt_InitiatorRestPin getInitiator() {
		return initiator;
	}

	public void setInitiator(OpgEnt_InitiatorRestPin initiator) {
		this.initiator = initiator;
	}
	
	
	

}
