package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_InitiatorReplacement;

public class OpgReq_Replacement {
	
	private OpgEnt_Header  header;
	private OpgEnt_InitiatorReplacement initiator;
	
	public OpgReq_Replacement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OpgReq_Replacement(OpgEnt_Header header, OpgEnt_InitiatorReplacement initiator) {
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

	public OpgEnt_InitiatorReplacement getInitiator() {
		return initiator;
	}

	public void setInitiator(OpgEnt_InitiatorReplacement initiator) {
		this.initiator = initiator;
	}
	
	

}
