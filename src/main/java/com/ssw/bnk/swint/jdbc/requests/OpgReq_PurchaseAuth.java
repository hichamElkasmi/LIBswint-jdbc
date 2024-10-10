package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_InitiatorPurchaseAuth;

public class OpgReq_PurchaseAuth {
	
	private OpgEnt_Header header;
	private OpgEnt_InitiatorPurchaseAuth initiator;
	
	
	public OpgReq_PurchaseAuth() {
		super();
	}
	
	public OpgReq_PurchaseAuth(OpgEnt_Header header, OpgEnt_InitiatorPurchaseAuth initiator) {
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

	public OpgEnt_InitiatorPurchaseAuth getInitiator() {
		return initiator;
	}

	public void setInitiator(OpgEnt_InitiatorPurchaseAuth initiator) {
		this.initiator = initiator;
	}
	
	
	

}
