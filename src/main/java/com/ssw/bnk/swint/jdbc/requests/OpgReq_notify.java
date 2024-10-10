package com.ssw.bnk.swint.jdbc.requests;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_notify;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;

public class OpgReq_notify {

    private OpgEnt_Header header;
    private OpgEnt_notify initiator;

   
    public OpgReq_notify() {
        super();
    }

   
    public OpgReq_notify(OpgEnt_Header header, OpgEnt_notify initiator) {
        this.header = header;
        this.initiator = initiator;
    }

   
    public OpgEnt_Header getHeader() {
        return header;
    }

    public void setHeader(OpgEnt_Header header) {
        this.header = header;
    }

    public OpgEnt_notify getInitiator() {
        return initiator;
    }

    public void setInitiator(OpgEnt_notify initiator) {
        this.initiator = initiator;
    }

    @Override
    public String toString() {
        return "OpgReq_notify " +
                "header=" + header +
                ", initiator=" + initiator +
                '}';
    }

}