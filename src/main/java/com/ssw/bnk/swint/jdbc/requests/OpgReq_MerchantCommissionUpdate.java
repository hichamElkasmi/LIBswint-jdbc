package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_InitiatorMerchantCommissionUpdate;


public class OpgReq_MerchantCommissionUpdate {
	
	private OpgEnt_Header header;
	private OpgEnt_InitiatorMerchantCommissionUpdate initiator;
	
	public OpgReq_MerchantCommissionUpdate() {
		super();
	}

	public OpgReq_MerchantCommissionUpdate(OpgEnt_Header header, OpgEnt_InitiatorMerchantCommissionUpdate initiator) {
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

	public OpgEnt_InitiatorMerchantCommissionUpdate getInitiator() {
		return initiator;
	}

	public void setInitiator(OpgEnt_InitiatorMerchantCommissionUpdate initiator) {
		this.initiator = initiator;
	}
	
	

}
