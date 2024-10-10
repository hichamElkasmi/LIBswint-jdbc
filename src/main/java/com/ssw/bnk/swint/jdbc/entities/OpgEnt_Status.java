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
 * @author S2M
 */

@Getter @Setter
public class OpgEnt_Status {
    
    public String errorcode;
    public String errordesc;

    public OpgEnt_Status(String errorcode, String errordesc) {
        this.errorcode = errorcode;
        this.errordesc = errordesc;
    }
    
    public OpgEnt_Status() {
       
    }

	public String getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}

	public String getErrordesc() {
		return errordesc;
	}

	public void setErrordesc(String errordesc) {
		this.errordesc = errordesc;
	}
    
}
