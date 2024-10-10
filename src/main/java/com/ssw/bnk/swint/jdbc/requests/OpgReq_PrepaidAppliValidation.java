package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_InitiatorPrepaidAppliValidation;

public class OpgReq_PrepaidAppliValidation {
	
	private OpgEnt_Header header;
	private OpgEnt_InitiatorPrepaidAppliValidation initiator;
	
	public OpgReq_PrepaidAppliValidation(OpgEnt_Header header, OpgEnt_InitiatorPrepaidAppliValidation initiator) {
		super();
		this.header = header;
		this.initiator = initiator;
	}
	public OpgReq_PrepaidAppliValidation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OpgEnt_Header getHeader() {
		return header;
	}
	public void setHeader(OpgEnt_Header header) {
		this.header = header;
	}
	public OpgEnt_InitiatorPrepaidAppliValidation getInitiator() {
		return initiator;
	}
	public void setInitiator(OpgEnt_InitiatorPrepaidAppliValidation initiator) {
		this.initiator = initiator;
	}
	
}
