package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_FilterMerchantAppliList;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;

public class OpgReq_MerchantApplicationList {
	
	private OpgEnt_Header header;
	private OpgEnt_FilterMerchantAppliList filter;
	
	public OpgReq_MerchantApplicationList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OpgReq_MerchantApplicationList(OpgEnt_Header header, OpgEnt_FilterMerchantAppliList filter) {
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
	public OpgEnt_FilterMerchantAppliList getFilter() {
		return filter;
	}
	public void setFilter(OpgEnt_FilterMerchantAppliList filter) {
		this.filter = filter;
	}
	
}
