package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_InitiatorUpdateAccount;


public class OpgReq_UpdateAccount {
	
	private OpgEnt_Header header;
	private OpgEnt_InitiatorUpdateAccount initiator;
	
	public OpgReq_UpdateAccount() {
		super();
	}

	public OpgReq_UpdateAccount(OpgEnt_Header header, OpgEnt_InitiatorUpdateAccount initiator) {
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

	public OpgEnt_InitiatorUpdateAccount getInitiator() {
		return initiator;
	}

	public void setInitiator(OpgEnt_InitiatorUpdateAccount initiator) {
		this.initiator = initiator;
	}
	
	

}
