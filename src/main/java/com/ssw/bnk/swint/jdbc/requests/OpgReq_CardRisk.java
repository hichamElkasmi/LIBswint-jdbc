package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_FilterCardRisk;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;

public class OpgReq_CardRisk {

	private OpgEnt_Header header;
	private OpgEnt_FilterCardRisk filter;

	public OpgReq_CardRisk(OpgEnt_Header header, OpgEnt_FilterCardRisk opgEnt_FilterCardRisk) {
		super();
		this.header = header;
		this.filter = opgEnt_FilterCardRisk;
	}

	public OpgEnt_Header getHeader() {
		return header;
	}

	public void setHeader(OpgEnt_Header header) {
		this.header = header;
	}

	public OpgEnt_FilterCardRisk getFilter() {
		return filter;
	}

	public void setFilter(OpgEnt_FilterCardRisk filter) {
		this.filter = filter;
	}

	@Override
	public String toString() {
		return "OpgReq_CardRisk [header=" + header + ", filter=" + filter + "]";
	}

}
