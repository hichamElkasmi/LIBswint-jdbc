package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_MerchantUpdateNoApplication;

public class OpgReq_MerchantUpdateNoApplication {
	
	private OpgEnt_Header header;
	private OpgEnt_MerchantUpdateNoApplication merchant;
	
	public OpgReq_MerchantUpdateNoApplication(OpgEnt_Header header, OpgEnt_MerchantUpdateNoApplication merchant) {
		super();
		this.header = header;
		this.merchant = merchant;
	}
	public OpgReq_MerchantUpdateNoApplication() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OpgEnt_Header getHeader() {
		return header;
	}
	public void setHeader(OpgEnt_Header header) {
		this.header = header;
	}
	public OpgEnt_MerchantUpdateNoApplication getMerchant() {
		return merchant;
	}
	public void setMerchant(OpgEnt_MerchantUpdateNoApplication merchant) {
		this.merchant = merchant;
	}

}
