/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssw.bnk.swint.jdbc.in;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Balance;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Status;

/**
 *
 * @author S2M
 */
public class SS_Ba {

    public OpgEnt_Header header;
    public OpgEnt_Balance balance;
    public OpgEnt_Status status ;

    
    public SS_Ba() {
    }


	public SS_Ba(OpgEnt_Header header, OpgEnt_Balance balance, OpgEnt_Status status) {
		super();
		this.header = header;
		this.balance = balance;
		this.status = status;
	}


	public OpgEnt_Header getHeader() {
		return header;
	}


	public void setHeader(OpgEnt_Header header) {
		this.header = header;
	}


	public OpgEnt_Balance getBalance() {
		return balance;
	}


	public void setBalance(OpgEnt_Balance balance) {
		this.balance = balance;
	}


	public OpgEnt_Status getStatus() {
		return status;
	}

	public void setStatus(OpgEnt_Status status) {
		this.status = status;
	}

}
