package com.ssw.bnk.swint.jdbc.requests;


import com.ssw.bnk.swint.jdbc.entities.OpgEnt_FilterVirtualCard;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;

public class OpgReq_VirtualCard {
	  private OpgEnt_Header header;
	  private OpgEnt_FilterVirtualCard initiator;
	
	  public OpgReq_VirtualCard() {
			super();
		}
		
	  public OpgEnt_Header getHeader() {
			return header;
		}

		public void setHeader(OpgEnt_Header header) {
			this.header = header;
		} 
	
	public OpgReq_VirtualCard(OpgEnt_Header header, OpgEnt_FilterVirtualCard initiator) {
			super();
			this.header = header;
			this.initiator = initiator;
		}

	public OpgEnt_FilterVirtualCard getInitiator() {
		return initiator;
	}

	public void setInitiator(OpgEnt_FilterVirtualCard initiator) {
		this.initiator = initiator;
	}

}
