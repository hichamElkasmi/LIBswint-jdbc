package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_InitiatorAccountTransfer;

public class OpgReq_AccountTransfer {
	
	  private OpgEnt_Header header;
	  private OpgEnt_InitiatorAccountTransfer initiator;
	  
	public OpgReq_AccountTransfer(OpgEnt_Header header, OpgEnt_InitiatorAccountTransfer initiator) {
		super();
		this.header = header;
		this.initiator = initiator;
	}
	public OpgReq_AccountTransfer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OpgEnt_Header getHeader() {
		return header;
	}
	public void setHeader(OpgEnt_Header header) {
		this.header = header;
	}
	public OpgEnt_InitiatorAccountTransfer getInitiator() {
		return initiator;
	}
	public void setInitiator(OpgEnt_InitiatorAccountTransfer initiator) {
		this.initiator = initiator;
	}
	  
}
