package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_FilterProgramRisk;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;

public class OpgReq_TransSatuts {
	private OpgEnt_Header header;
	private OpgEnt_FilterProgramRisk filter;

	public OpgReq_TransSatuts(OpgEnt_Header header, OpgEnt_FilterProgramRisk opgEnt_FilterCardRisk) {
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

	public OpgEnt_FilterProgramRisk getFilter() {
		return filter;
	}

	public void setFilter(OpgEnt_FilterProgramRisk filter) {
		this.filter = filter;
	}

	@Override
	public String toString() {
		return "OpgReq_CardRisk [header=" + header + ", filter=" + filter + "]";
	}
}
