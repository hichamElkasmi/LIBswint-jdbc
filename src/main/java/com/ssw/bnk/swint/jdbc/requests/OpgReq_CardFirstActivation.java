package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_InitiatorCardFirstActivation;

public class OpgReq_CardFirstActivation {
	
	private OpgEnt_Header header;
	private OpgEnt_InitiatorCardFirstActivation initiator;
	
	public OpgReq_CardFirstActivation(OpgEnt_Header header, OpgEnt_InitiatorCardFirstActivation initiator) {
		super();
		this.header = header;
		this.initiator = initiator;
	}
	public OpgReq_CardFirstActivation() {
		super();
	}
	public OpgEnt_Header getHeader() {
		return header;
	}
	public void setHeader(OpgEnt_Header header) {
		this.header = header;
	}
	public OpgEnt_InitiatorCardFirstActivation getInitiator() {
		return initiator;
	}
	public void setInitiator(OpgEnt_InitiatorCardFirstActivation initiator) {
		this.initiator = initiator;
	}
	
	
	
}
