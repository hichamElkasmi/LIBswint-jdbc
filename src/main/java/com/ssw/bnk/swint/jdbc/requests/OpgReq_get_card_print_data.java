package com.ssw.bnk.swint.jdbc.requests;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_FilterGetPrintData;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;

public class OpgReq_get_card_print_data {
	  private OpgEnt_Header header;
	  private OpgEnt_FilterGetPrintData initiator;
	
	  public OpgReq_get_card_print_data() {
			super();
		}
		
	  public OpgEnt_Header getHeader() {
			return header;
		}

		public void setHeader(OpgEnt_Header header) {
			this.header = header;
		} 
	
	public OpgReq_get_card_print_data(OpgEnt_Header header, OpgEnt_FilterGetPrintData initiator) {
			super();
			this.header = header;
			this.initiator = initiator;
		}

	public OpgEnt_FilterGetPrintData getInitiator() {
		return initiator;
	}

	public void setInitiator(OpgEnt_FilterGetPrintData initiator) {
		this.initiator = initiator;
	}
}
