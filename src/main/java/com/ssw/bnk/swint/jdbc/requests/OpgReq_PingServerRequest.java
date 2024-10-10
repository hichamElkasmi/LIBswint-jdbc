/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ssw.bnk.swint.jdbc.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Header;
import com.ssw.bnk.swint.jdbc.entities.OpgEnt_Initiator;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 *
 * @author BLA
 */

public class OpgReq_PingServerRequest {
    public OpgEnt_Header header;
    
   // public OpgEnt_Initiator initiator;

	public OpgEnt_Header getHeader() {
		return header;
	}

	public void setHeader(OpgEnt_Header header) {
		this.header = header;
	}

	//public OpgEnt_Initiator getInitiator() {
	//	return initiator;
	//}

	//public void setInitiator(OpgEnt_Initiator initiator) {
	//	this.initiator = initiator;
	//}
    
    
}
