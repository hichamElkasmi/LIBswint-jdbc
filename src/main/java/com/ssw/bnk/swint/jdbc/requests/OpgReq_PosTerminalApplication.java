package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_InitiatorPosTerminalApplication;

public class OpgReq_PosTerminalApplication {
	
	private OpgEnt_Header header;
	private OpgEnt_InitiatorPosTerminalApplication initiator;
	
	public OpgReq_PosTerminalApplication() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OpgReq_PosTerminalApplication(OpgEnt_Header header, OpgEnt_InitiatorPosTerminalApplication initiator) {
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
	public OpgEnt_InitiatorPosTerminalApplication getInitiator() {
		return initiator;
	}
	public void setInitiator(OpgEnt_InitiatorPosTerminalApplication initiator) {
		this.initiator = initiator;
	}

}
