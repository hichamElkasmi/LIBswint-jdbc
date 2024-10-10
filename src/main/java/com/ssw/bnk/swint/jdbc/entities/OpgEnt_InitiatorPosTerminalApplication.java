package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_InitiatorPosTerminalApplication {
	
	private String operation;
	private String terminalid;
	private String terminalname;
	private String merchantid;
	private String currencycode;
	private String configuration;
	private String terminalstatus;
	private String hsmkeycode;
	private String serialnumber;
	private String applicationversion;
	private String institution;
	
	private String purchase;
	private String voidis;
	private String billpayment;
	private String moneytransfer;
	private String pinchange;
	private String cashadvance;
	private String evoucher;
	private String refund;
	private String balanceinquiry;
	private String ministatement;
	
	public OpgEnt_InitiatorPosTerminalApplication() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	public OpgEnt_InitiatorPosTerminalApplication(String operation, String terminalid, String terminalname,
			String merchantid, String currencycode, String configuration, String terminalstatus, String hsmkeycode,
			String serialnumber, String applicationversion, String institution, String purchase, String voidis,
			String billpayment, String moneytransfer, String pinchange, String cashadvance, String evoucher,
			String refund, String balanceinquiry, String ministatement) {
		super();
		this.operation = operation;
		this.terminalid = terminalid;
		this.terminalname = terminalname;
		this.merchantid = merchantid;
		this.currencycode = currencycode;
		this.configuration = configuration;
		this.terminalstatus = terminalstatus;
		this.hsmkeycode = hsmkeycode;
		this.serialnumber = serialnumber;
		this.applicationversion = applicationversion;
		this.institution = institution;
		this.purchase = purchase;
		this.voidis = voidis;
		this.billpayment = billpayment;
		this.moneytransfer = moneytransfer;
		this.pinchange = pinchange;
		this.cashadvance = cashadvance;
		this.evoucher = evoucher;
		this.refund = refund;
		this.balanceinquiry = balanceinquiry;
		this.ministatement = ministatement;
	}



	public String getPurchase() {
		return purchase;
	}



	public void setPurchase(String purchase) {
		this.purchase = purchase;
	}



	public String getVoidis() {
		return voidis;
	}



	public void setVoidis(String voidis) {
		this.voidis = voidis;
	}



	public String getBillpayment() {
		return billpayment;
	}



	public void setBillpayment(String billpayment) {
		this.billpayment = billpayment;
	}



	public String getMoneytransfer() {
		return moneytransfer;
	}



	public void setMoneytransfer(String moneytransfer) {
		this.moneytransfer = moneytransfer;
	}



	public String getPinchange() {
		return pinchange;
	}



	public void setPinchange(String pinchange) {
		this.pinchange = pinchange;
	}



	public String getCashadvance() {
		return cashadvance;
	}



	public void setCashadvance(String cashadvance) {
		this.cashadvance = cashadvance;
	}



	public String getEvoucher() {
		return evoucher;
	}



	public void setEvoucher(String evoucher) {
		this.evoucher = evoucher;
	}



	public String getRefund() {
		return refund;
	}



	public void setRefund(String refund) {
		this.refund = refund;
	}



	public String getBalanceinquiry() {
		return balanceinquiry;
	}



	public void setBalanceinquiry(String balanceinquiry) {
		this.balanceinquiry = balanceinquiry;
	}



	public String getMinistatement() {
		return ministatement;
	}



	public void setMinistatement(String ministatement) {
		this.ministatement = ministatement;
	}



	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getTerminalid() {
		return terminalid;
	}
	public void setTerminalid(String terminalid) {
		this.terminalid = terminalid;
	}
	public String getTerminalname() {
		return terminalname;
	}
	public void setTerminalname(String terminalname) {
		this.terminalname = terminalname;
	}
	public String getMerchantid() {
		return merchantid;
	}
	public void setMerchantid(String merchantid) {
		this.merchantid = merchantid;
	}
	public String getCurrencycode() {
		return currencycode;
	}
	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}
	public String getConfiguration() {
		return configuration;
	}
	public void setConfiguration(String configuration) {
		this.configuration = configuration;
	}
	public String getTerminalstatus() {
		return terminalstatus;
	}
	public void setTerminalstatus(String terminalstatus) {
		this.terminalstatus = terminalstatus;
	}
	public String getHsmkeycode() {
		return hsmkeycode;
	}
	public void setHsmkeycode(String hsmkeycode) {
		this.hsmkeycode = hsmkeycode;
	}
	public String getSerialnumber() {
		return serialnumber;
	}
	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}
	public String getApplicationversion() {
		return applicationversion;
	}
	public void setApplicationversion(String applicationversion) {
		this.applicationversion = applicationversion;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}

}
