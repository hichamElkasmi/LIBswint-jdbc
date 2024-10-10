package com.ssw.bnk.swint.jdbc.in;

import com.ssw.bnk.swint.jdbc.entities.*;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author MOKHLISS
 */
@Getter @Setter 
public class SS_Ret {
    
    //BLA BEGIN
    private OpgEnt_Header header;
    private SS_Stt status;
    
	public SS_Ret(OpgEnt_Header header, SS_Stt status) {
		super();
		this.header = header;
		this.status = status;
	}

	public SS_Ret() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OpgEnt_Header getHeader() {
		return header;
	}

	public void setHeader(OpgEnt_Header header) {
		this.header = header;
	}

	public SS_Stt getStatus() {
		return status;
	}

	public void setStatus(SS_Stt status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SS_Ret [header=" + header + ", status=" + status + "]";
	}    
	
	
   
    //BLA END
}
