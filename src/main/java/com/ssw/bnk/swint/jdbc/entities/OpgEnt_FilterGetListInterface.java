package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_FilterGetListInterface {
	
	private String bankcode;
	private String interfacetype;

	public OpgEnt_FilterGetListInterface() {
		super();
	}

	public OpgEnt_FilterGetListInterface(String bankcode) {
		super();
		this.bankcode = bankcode;
	}

	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

        public String getInterfacetype() {
            return interfacetype;
        }

        public void setInterfacetype(String interfacetype) {
            this.interfacetype = interfacetype;
        }
}
