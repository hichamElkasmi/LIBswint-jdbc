package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_InitiatorCreditApplicationValidation;

public class OpgReq_CreditApplicationValidation {

	private OpgEnt_Header header;
	private OpgEnt_InitiatorCreditApplicationValidation initiator;
	
	public OpgReq_CreditApplicationValidation() {
		super();
	}
	public OpgReq_CreditApplicationValidation(OpgEnt_Header header, OpgEnt_InitiatorCreditApplicationValidation  initiator) {
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
	public OpgEnt_InitiatorCreditApplicationValidation getInitiator() {
		return initiator;
	}
	public void setInitiator(OpgEnt_InitiatorCreditApplicationValidation  initiator) {
		this.initiator = initiator;
	}

}
