package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_MerchantUpdate;

public class OpgReq_MerchantUpdate {
	
	private OpgEnt_Header header;
	private OpgEnt_MerchantUpdate merchant;
	
	public OpgReq_MerchantUpdate(OpgEnt_Header header, OpgEnt_MerchantUpdate merchant) {
		super();
		this.header = header;
		this.merchant = merchant;
	}
	public OpgReq_MerchantUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OpgEnt_Header getHeader() {
		return header;
	}
	public void setHeader(OpgEnt_Header header) {
		this.header = header;
	}
	public OpgEnt_MerchantUpdate getMerchant() {
		return merchant;
	}
	public void setMerchant(OpgEnt_MerchantUpdate merchant) {
		this.merchant = merchant;
	}

}
