package com.ssw.bnk.swint.jdbc.requests;

import java.util.List;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Risk;

public class OpgReq_RiskList {

	private OpgEnt_Header header;
	private List<OpgEnt_Risk> initiator;

	public OpgReq_RiskList(OpgEnt_Header header, List<OpgEnt_Risk> initiator) {
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

	public List<OpgEnt_Risk> getInitiator() {
		return initiator;
	}

	public void setInitiator(List<OpgEnt_Risk> initiator) {
		this.initiator = initiator;
	}

	@Override
	public String toString() {
		return "OpgReq_RiskList [header=" + header + ", initiator=" + initiator + "]";
	}

}
