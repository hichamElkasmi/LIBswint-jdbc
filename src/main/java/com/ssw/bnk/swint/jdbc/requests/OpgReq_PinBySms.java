package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_FilterPin;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;

public class OpgReq_PinBySms {

	private OpgEnt_Header header;
	private OpgEnt_FilterPin initiator;

	public OpgReq_PinBySms(OpgEnt_Header header, OpgEnt_FilterPin initiator) {
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

	public OpgEnt_FilterPin getInitiator() {
		return initiator;
	}

	public void setInitiator(OpgEnt_FilterPin initiator) {
		this.initiator = initiator;
	}

	@Override
	public String toString() {
		return "OpgReq_PinBySms [header=" + header + ", initiator=" + initiator + "]";
	}

}
