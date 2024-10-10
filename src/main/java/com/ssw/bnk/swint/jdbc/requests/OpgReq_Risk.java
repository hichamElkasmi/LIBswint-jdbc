package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Risk;

public class OpgReq_Risk {

	private OpgEnt_Header header;
	private OpgEnt_Risk initiator;

	public OpgReq_Risk(OpgEnt_Header header, OpgEnt_Risk initiator) {
		super();
		this.header = header;
		this.initiator = initiator;
	}

        public OpgReq_Risk() {
        }

	public OpgEnt_Header getHeader() {
		return header;
	}

	public void setHeader(OpgEnt_Header header) {
		this.header = header;
	}

	public OpgEnt_Risk getInitiator() {
		return initiator;
	}

	public void setInitiator(OpgEnt_Risk initiator) {
		this.initiator = initiator;
	}

	@Override
	public String toString() {
		return "OpgReq_Risk [header=" + header + ", initiator=" + initiator + "]";
	}

}
