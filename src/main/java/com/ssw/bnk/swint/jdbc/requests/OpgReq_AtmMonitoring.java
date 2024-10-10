package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_AtmMonitoring;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;

public class OpgReq_AtmMonitoring {
	private OpgEnt_Header header;
	private OpgEnt_AtmMonitoring initiator;

        public OpgReq_AtmMonitoring(OpgEnt_Header header, OpgEnt_AtmMonitoring initiator) {
            this.header = header;
            this.initiator = initiator;
        }

	public OpgEnt_Header getHeader() {
		return header;
	}

	public void setHeader(OpgEnt_Header header) {
		this.header = header;
	}

        public OpgEnt_AtmMonitoring getInitiator() {
            return initiator;
        }

        public void setInitiator(OpgEnt_AtmMonitoring initiator) {
            this.initiator = initiator;
        }
        
	@Override
	public String toString() {
		return "OpgReq_PinBySms [header=" + header + ", initiator=" + initiator + "]";
	}

}
