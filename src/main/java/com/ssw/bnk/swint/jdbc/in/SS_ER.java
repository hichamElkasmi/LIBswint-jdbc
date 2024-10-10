/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssw.bnk.swint.jdbc.in;

import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Status;

/**
 *
 * @author S2M
 */
public class SS_ER {
    
    public OpgEnt_Header header ; 
    public OpgEnt_Status status;

    public SS_ER(OpgEnt_Header header, OpgEnt_Status status) {
        this.header = header;
        this.status = status;
    }

    public SS_ER() {
    }

    public OpgEnt_Header getHeader() {
        return header;
    }

    public OpgEnt_Status getStatus() {
        return status;
    }

    public void setHeader(OpgEnt_Header header) {
        this.header = header;
    }

    public void setStatus(OpgEnt_Status status) {
        this.status = status;
    }    
    
}
