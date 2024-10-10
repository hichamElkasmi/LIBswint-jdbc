
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ssw.bnk.swint.jdbc.entities;

import lombok.Getter;
import lombok.Setter;
/**
 *
 * @author BLA
 */
@Getter @Setter
public class OpgEnt_Header {
    private String idmsg;
    private String mac;

    public OpgEnt_Header() {
    }
    
    public OpgEnt_Header(String idmsg, String mac) {
        this.idmsg = idmsg;
        this.mac = mac;
    }

	public String getIdmsg() {
		return idmsg;
	}

	public void setIdmsg(String idmsg) {
		this.idmsg = idmsg;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}
    
    
}
