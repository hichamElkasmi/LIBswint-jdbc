package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Renew;

public class OpgReq_ReNew {
	
	private OpgEnt_Header header;
	private OpgEnt_Renew initiator;
	
	public OpgReq_ReNew(OpgEnt_Header header, OpgEnt_Renew initiator) {
		super();
		this.header = header;
		this.initiator = initiator;
	}

	public OpgReq_ReNew() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OpgEnt_Header getHeader() {
		return header;
	}

	public void setHeader(OpgEnt_Header header) {
		this.header = header;
	}

	public OpgEnt_Renew getInitiator() {
		return initiator;
	}

	public void setInitiator(OpgEnt_Renew initiator) {
		this.initiator = initiator;
	}
	
}
