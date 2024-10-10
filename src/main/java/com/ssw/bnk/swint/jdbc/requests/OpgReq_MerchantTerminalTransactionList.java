package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_FilterMerchantTerminalTransaction;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;

public class OpgReq_MerchantTerminalTransactionList {

	private OpgEnt_Header header;
	private OpgEnt_FilterMerchantTerminalTransaction filter;

	public OpgReq_MerchantTerminalTransactionList(OpgEnt_Header header,
			OpgEnt_FilterMerchantTerminalTransaction filter) {
		super();
		this.header = header;
		this.filter = filter;
	}

	public OpgEnt_Header getHeader() {
		return header;
	}

	public void setHeader(OpgEnt_Header header) {
		this.header = header;
	}

	public OpgEnt_FilterMerchantTerminalTransaction getFilter() {
		return filter;
	}

	public void setFilter(OpgEnt_FilterMerchantTerminalTransaction filter) {
		this.filter = filter;
	}

	@Override
	public String toString() {
		return "OpgReq_MerchantTerminalTransactionList [header=" + header + ", filter=" + filter + "]";
	}

}
