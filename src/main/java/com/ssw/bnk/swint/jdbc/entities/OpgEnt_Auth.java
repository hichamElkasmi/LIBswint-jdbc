/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ssw.bnk.swint.jdbc.entities;

import com.ssw.bnk.swint.jdbc.in.SS_Stt;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author BLA
 */
@Getter @Setter 
public class OpgEnt_Auth {
    public static final String OK="0";
    
    private OpgEnt_Header header;
    private SS_Stt status;

    public OpgEnt_Auth() {
    }
        
    public OpgEnt_Auth(OpgEnt_Header header, SS_Stt status) {
        this.header = header;
        this.status = status;
    }

    public boolean checkStatus(){
        return status.codestatus.equals(OK);
    }

    public OpgEnt_Header getHeader() {
       return header;      
    }

	public SS_Stt getStatus() {
		return status;
	}

	public void setStatus(SS_Stt status) {
		this.status = status;
	}

	public static String getOk() {
		return OK;
	}

	public void setHeader(OpgEnt_Header header) {
		this.header = header;
	}
    
    
    
}
