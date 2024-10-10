package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_InitiatorCardStUp;

public class OpgReq_CardStUp {
	
	private OpgEnt_Header header;
	private OpgEnt_InitiatorCardStUp initiator;
	
	public OpgReq_CardStUp(OpgEnt_Header header, OpgEnt_InitiatorCardStUp initiator) {
		super();
		this.header = header;
		this.initiator = initiator;
	}
	public OpgReq_CardStUp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OpgEnt_Header getHeader() {
		return header;
	}
	public void setHeader(OpgEnt_Header header) {
		this.header = header;
	}
	public OpgEnt_InitiatorCardStUp getInitiator() {
		return initiator;
	}
	public void setInitiator(OpgEnt_InitiatorCardStUp initiator) {
		this.initiator = initiator;
	}
	
	
	
}
