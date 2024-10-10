package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_FilterValidateCardPin;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;

public class OpgReq_ValidateCardPin {
	  private OpgEnt_Header header;
	  private OpgEnt_FilterValidateCardPin initiator;
	
	  public OpgReq_ValidateCardPin() {
			super();
		}
		
	  public OpgEnt_Header getHeader() {
			return header;
		}

		public void setHeader(OpgEnt_Header header) {
			this.header = header;
		} 
	
	public OpgReq_ValidateCardPin(OpgEnt_Header header, OpgEnt_FilterValidateCardPin initiator) {
			super();
			this.header = header;
			this.initiator = initiator;
		}

	public OpgEnt_FilterValidateCardPin getInitiator() {
		return initiator;
	}

	public void setInitiator(OpgEnt_FilterValidateCardPin initiator) {
		this.initiator = initiator;
	}
}
