package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_AnonymDebitCard;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_AnonymPrepaidCard;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;

public class OpgReq_anonymDebitCard {
	
    public OpgEnt_Header header;
    public OpgEnt_AnonymDebitCard initiator;
    
    
	public OpgReq_anonymDebitCard() {
		super();
	}


	public OpgReq_anonymDebitCard(OpgEnt_Header header, OpgEnt_AnonymDebitCard initiator) {
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


	public OpgEnt_AnonymDebitCard getInitiator() {
		return initiator;
	}


	public void setInitiator(OpgEnt_AnonymDebitCard initiator) {
		this.initiator = initiator;
	}
    
    

}
