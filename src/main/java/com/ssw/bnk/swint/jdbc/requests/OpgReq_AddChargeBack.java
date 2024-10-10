package com.ssw.bnk.swint.jdbc.requests;


import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_InitiatorAddChargeBack;

public class OpgReq_AddChargeBack {
	
    public OpgEnt_Header header;
    public OpgEnt_InitiatorAddChargeBack initiator;
    
	public OpgReq_AddChargeBack() {
		super();
	}

	public OpgReq_AddChargeBack(OpgEnt_Header header, OpgEnt_InitiatorAddChargeBack initiator) {
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

	public OpgEnt_InitiatorAddChargeBack getInitiator() {
		return initiator;
	}

	public void setInitiator(OpgEnt_InitiatorAddChargeBack initiator) {
		this.initiator = initiator;
	}
    
    

}
