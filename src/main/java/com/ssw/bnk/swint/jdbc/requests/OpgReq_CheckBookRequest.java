package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_InitiatorCheckBookRequest;

public class OpgReq_CheckBookRequest {
	
	private OpgEnt_Header header;
    private OpgEnt_InitiatorCheckBookRequest initiator;
    
	public OpgReq_CheckBookRequest(OpgEnt_Header header, OpgEnt_InitiatorCheckBookRequest initiator) {
		super();
		this.header = header;
		this.initiator = initiator;
	}
	public OpgReq_CheckBookRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OpgEnt_Header getHeader() {
		return header;
	}
	public void setHeader(OpgEnt_Header header) {
		this.header = header;
	}
	public OpgEnt_InitiatorCheckBookRequest getInitiator() {
		return initiator;
	}
	public void setInitiator(OpgEnt_InitiatorCheckBookRequest initiator) {
		this.initiator = initiator;
	}
    
}
