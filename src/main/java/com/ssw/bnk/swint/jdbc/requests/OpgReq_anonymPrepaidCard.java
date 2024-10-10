package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_AnonymPrepaidCard;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;

public class OpgReq_anonymPrepaidCard {
	
    public OpgEnt_Header header;
    public OpgEnt_AnonymPrepaidCard initiator;
    
	public OpgReq_anonymPrepaidCard() {
		super();
	}

	public OpgReq_anonymPrepaidCard(OpgEnt_Header header, OpgEnt_AnonymPrepaidCard initiator) {
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

	public OpgEnt_AnonymPrepaidCard getInitiator() {
		return initiator;
	}

	public void setInitiator(OpgEnt_AnonymPrepaidCard initiator) {
		this.initiator = initiator;
	}
   
	
    

}
