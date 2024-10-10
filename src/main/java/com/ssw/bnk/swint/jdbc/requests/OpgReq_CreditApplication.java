package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_InitiatorCreditApplication;

public class OpgReq_CreditApplication {
	
	private OpgEnt_Header header;
	private OpgEnt_InitiatorCreditApplication initiator;
	
	
	
	public OpgReq_CreditApplication() {
		super();
	}
	public OpgReq_CreditApplication(OpgEnt_Header header, OpgEnt_InitiatorCreditApplication initiator) {
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
	public OpgEnt_InitiatorCreditApplication getInitiator() {
		return initiator;
	}
	public void setInitiator(OpgEnt_InitiatorCreditApplication initiator) {
		this.initiator = initiator;
	}

}
