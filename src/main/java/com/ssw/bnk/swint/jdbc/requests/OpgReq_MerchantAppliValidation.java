package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_InitiatorMerchantAppliValidation;

public class OpgReq_MerchantAppliValidation {
	
	private OpgEnt_Header header;
	private OpgEnt_InitiatorMerchantAppliValidation initiator;
	
	public OpgReq_MerchantAppliValidation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OpgReq_MerchantAppliValidation(OpgEnt_Header header, OpgEnt_InitiatorMerchantAppliValidation initiator) {
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
	public OpgEnt_InitiatorMerchantAppliValidation getInitiator() {
		return initiator;
	}
	public void setInitiator(OpgEnt_InitiatorMerchantAppliValidation initiator) {
		this.initiator = initiator;
	}
	
}
