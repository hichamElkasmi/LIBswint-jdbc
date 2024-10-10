package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_FilterAccountList {
        private String accountcode;
        private String accountID;
	private String type;
	private String institution;
	private String start;
	private String end;
	
	public OpgEnt_FilterAccountList(String accountcode, String type, String institution, String start, String end) {
		super();
		this.accountcode = accountcode;
		this.type = type;
		this.institution = institution;
		this.start = start;
		this.end = end;
	}

	public OpgEnt_FilterAccountList() {
		super();
	}

	public String getAccountCode() {
		return accountcode;
	}

	public void setAccountCode(String accountcode) {
		this.accountcode = accountcode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

        public String getAccountcode() {
            return accountcode;
        }

        public String getAccountID() {
            return accountID;
        }

        public void setAccountcode(String accountcode) {
            this.accountcode = accountcode;
        }

        public void setAccountID(String accountID) {
            this.accountID = accountID;
        }

}
