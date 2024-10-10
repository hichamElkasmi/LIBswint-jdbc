package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_InitiatorDebitApplication;

public class OpgReq_DebitApplicationTemp {

	private OpgEnt_Header header;
	private OpgEnt_InitiatorDebitApplication initiator;

	public OpgReq_DebitApplicationTemp(OpgEnt_Header header, OpgEnt_InitiatorDebitApplication initiator) {
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

	public OpgEnt_InitiatorDebitApplication getInitiator() {
		return initiator;
	}

	public void setInitiator(OpgEnt_InitiatorDebitApplication initiator) {
		this.initiator = initiator;
	}

	@Override
	public String toString() {
		return "OpgReq_DebitApplicationTemp [header=" + header + ", initiator=" + initiator + "]";
	}

}
