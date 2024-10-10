package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_InitiatorInternetMailOrderStatus;

public class OpgReq_InternetMailOrderStatus {
	
	private OpgEnt_Header header;
	private OpgEnt_InitiatorInternetMailOrderStatus initiator;
	
	public OpgReq_InternetMailOrderStatus() {
		super();
	}

	public OpgReq_InternetMailOrderStatus(OpgEnt_Header header, OpgEnt_InitiatorInternetMailOrderStatus initiator) {
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

	public OpgEnt_InitiatorInternetMailOrderStatus getInitiator() {
		return initiator;
	}

	public void setInitiator(OpgEnt_InitiatorInternetMailOrderStatus initiator) {
		this.initiator = initiator;
	}
	
	
	

}
