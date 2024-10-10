package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgRent_FilterPosMonitoring;

public class OpgReq_PosMonitoring {

	private OpgEnt_Header header;
	private OpgRent_FilterPosMonitoring filter;

	public OpgReq_PosMonitoring(OpgEnt_Header header, OpgRent_FilterPosMonitoring filter) {
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

	public OpgRent_FilterPosMonitoring getFilter() {
		return filter;
	}

	public void setFilter(OpgRent_FilterPosMonitoring filter) {
		this.filter = filter;
	}

	@Override
	public String toString() {
		return "OpgReq_PosMonitoring [header=" + header + ", filter=" + filter + "]";
	}

}
