package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_InitiatorAuthReversal;


public class OpgReq_AuthReversal {
	
	private OpgEnt_Header header;
	private OpgEnt_InitiatorAuthReversal initiator;
	
	public OpgReq_AuthReversal() {
		super();
	}

	public OpgReq_AuthReversal(OpgEnt_Header header, OpgEnt_InitiatorAuthReversal initiator) {
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

	public OpgEnt_InitiatorAuthReversal getInitiator() {
		return initiator;
	}

	public void setInitiator(OpgEnt_InitiatorAuthReversal initiator) {
		this.initiator = initiator;
	}
	
	
	

}
