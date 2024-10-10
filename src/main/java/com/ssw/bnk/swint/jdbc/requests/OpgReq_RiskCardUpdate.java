package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_InitiatorRiskCardUpdate;

public class OpgReq_RiskCardUpdate {
	
	private OpgEnt_Header header;
	private OpgEnt_InitiatorRiskCardUpdate initiator;
	
	public OpgReq_RiskCardUpdate() {
		super();
	}

	public OpgReq_RiskCardUpdate(OpgEnt_Header header, OpgEnt_InitiatorRiskCardUpdate initiator) {
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

	public OpgEnt_InitiatorRiskCardUpdate getInitiator() {
		return initiator;
	}

	public void setInitiator(OpgEnt_InitiatorRiskCardUpdate initiator) {
		this.initiator = initiator;
	}
	
	
	

}
