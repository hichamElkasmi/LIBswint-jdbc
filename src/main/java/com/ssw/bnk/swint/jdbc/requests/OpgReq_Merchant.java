package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Merchant;

public class OpgReq_Merchant {
	
	private OpgEnt_Header header;
	private OpgEnt_Merchant merchant;
	
	public OpgReq_Merchant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OpgReq_Merchant(OpgEnt_Header header, OpgEnt_Merchant merchant) {
		super();
		this.header = header;
		this.merchant = merchant;
	}
	public OpgEnt_Header getHeader() {
		return header;
	}
	public void setHeader(OpgEnt_Header header) {
		this.header = header;
	}
	public OpgEnt_Merchant getMerchant() {
		return merchant;
	}
	public void setMerchant(OpgEnt_Merchant merchant) {
		this.merchant = merchant;
	}

}
