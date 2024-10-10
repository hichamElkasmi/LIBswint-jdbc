package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_InitiatorPurchaseAdvice;

public class OpgReq_PurchaseAdvice {
	
	private OpgEnt_Header header;
	private OpgEnt_InitiatorPurchaseAdvice initiator;
	
	public OpgReq_PurchaseAdvice() {
		super();
	}

	public OpgReq_PurchaseAdvice(OpgEnt_Header header, OpgEnt_InitiatorPurchaseAdvice initiator) {
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

	public OpgEnt_InitiatorPurchaseAdvice getInitiator() {
		return initiator;
	}

	public void setInitiator(OpgEnt_InitiatorPurchaseAdvice initiator) {
		this.initiator = initiator;
	}
	
	

}
