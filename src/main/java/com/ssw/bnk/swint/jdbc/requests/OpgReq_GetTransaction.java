package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_InitiatorGetTransaction;

public class OpgReq_GetTransaction {
	
    private OpgEnt_Header header;
    private OpgEnt_InitiatorGetTransaction initiator;
    
	public OpgReq_GetTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OpgReq_GetTransaction(OpgEnt_Header header, OpgEnt_InitiatorGetTransaction initiator) {
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
	public OpgEnt_InitiatorGetTransaction getInitiator() {
		return initiator;
	}
	public void setInitiator(OpgEnt_InitiatorGetTransaction initiator) {
		this.initiator = initiator;
	}
    
}
