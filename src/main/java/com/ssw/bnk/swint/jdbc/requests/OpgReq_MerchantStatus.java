package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_InitiatorStatusMerchant;

public class OpgReq_MerchantStatus {
	
	private OpgEnt_Header header;
	private OpgEnt_InitiatorStatusMerchant initiator;
	
	public OpgReq_MerchantStatus() {
		super();
	}

	public OpgReq_MerchantStatus(OpgEnt_Header header, OpgEnt_InitiatorStatusMerchant initiator) {
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

	public OpgEnt_InitiatorStatusMerchant getInitiator() {
		return initiator;
	}

	public void setInitiator(OpgEnt_InitiatorStatusMerchant initiator) {
		this.initiator = initiator;
	}
	
	

}
