package com.ssw.bnk.swint.jdbc.in;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author MOKHLISS
 */
@Getter @Setter 
public class SS_Stt {
    
    public String codestatus;
    public String descstatus;
    public String codeerror;
    public String msgerror;

    public SS_Stt() {
    }

    public SS_Stt(String codestatus, String descstatus, String codeerror, String msgerror) {
        this.codestatus = codestatus;
        this.descstatus = descstatus;
        this.codeerror = codeerror;
        this.msgerror = msgerror;
    }

	public String getCodestatus() {
		return codestatus;
	}

	public void setCodestatus(String codestatus) {
		this.codestatus = codestatus;
	}

	public String getDescstatus() {
		return descstatus;
	}

	public void setDescstatus(String descstatus) {
		this.descstatus = descstatus;
	}

	public String getCodeerror() {
		return codeerror;
	}

	public void setCodeerror(String codeerror) {
		this.codeerror = codeerror;
	}

	public String getMsgerror() {
		return msgerror;
	}

	public void setMsgerror(String msgerror) {
		this.msgerror = msgerror;
	}

	@Override
	public String toString() {
		return "SS_Stt [codestatus=" + codestatus + ", descstatus=" + descstatus + ", codeerror=" + codeerror
				+ ", msgerror=" + msgerror + "]";
	}
    
    
}
