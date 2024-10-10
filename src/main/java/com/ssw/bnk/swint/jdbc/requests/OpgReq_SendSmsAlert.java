package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_FilterPin;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_SmsAlert;

public class OpgReq_SendSmsAlert {

	private OpgEnt_Header header;
	private OpgEnt_SmsAlert initiator;

	public OpgReq_SendSmsAlert(OpgEnt_Header header, OpgEnt_SmsAlert initiator) {
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

	public OpgEnt_SmsAlert getInitiator() {
		return initiator;
	}

	public void setInitiator(OpgEnt_SmsAlert initiator) {
		this.initiator = initiator;
	}

	@Override
	public String toString() {
		return "OpgReq_PinBySms [header=" + header + ", initiator=" + initiator + "]";
	}

}
