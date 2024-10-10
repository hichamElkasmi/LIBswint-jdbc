package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_FilterMerchantTerminalsList;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;

public class OpgReq_MerchantTerminalsList {

	private OpgEnt_Header header;
	private OpgEnt_FilterMerchantTerminalsList initiator;

	public OpgReq_MerchantTerminalsList(OpgEnt_Header header, OpgEnt_FilterMerchantTerminalsList initiator) {
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

	public OpgEnt_FilterMerchantTerminalsList getInitiator() {
		return initiator;
	}

	public void setInitiator(OpgEnt_FilterMerchantTerminalsList initiator) {
		this.initiator = initiator;
	}

	@Override
	public String toString() {
		return "OpgReq_MerchantTerminalsList [header=" + header + ", initiator=" + initiator + "]";
	}

}
