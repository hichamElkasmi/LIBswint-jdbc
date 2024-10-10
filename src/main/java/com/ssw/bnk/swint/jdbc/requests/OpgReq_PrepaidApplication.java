package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_InitiatorPrepaidApplication;

public class OpgReq_PrepaidApplication {
	
	private OpgEnt_Header header;
	private OpgEnt_InitiatorPrepaidApplication initiator;
	
	public OpgReq_PrepaidApplication() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OpgReq_PrepaidApplication(OpgEnt_Header header, OpgEnt_InitiatorPrepaidApplication initiator) {
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
	public OpgEnt_InitiatorPrepaidApplication getInitiator() {
		return initiator;
	}
	public void setInitiator(OpgEnt_InitiatorPrepaidApplication initiator) {
		this.initiator = initiator;
	}	

}
