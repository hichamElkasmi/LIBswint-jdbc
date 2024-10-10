package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_InitiatorRedemption;

public class OpgReq_Redemption {
	
	private OpgEnt_Header header;
	private OpgEnt_InitiatorRedemption initiator;
	
	public OpgReq_Redemption() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OpgReq_Redemption(OpgEnt_Header header, OpgEnt_InitiatorRedemption initiator) {
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
	public OpgEnt_InitiatorRedemption getInitiator() {
		return initiator;
	}
	public void setInitiator(OpgEnt_InitiatorRedemption initiator) {
		this.initiator = initiator;
	}

}
