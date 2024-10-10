package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_MerPaymentMode {
	
	private String paymentmodecode;
	private String paymentmodedefault;
	private String paymentmoderate;
	
	public OpgEnt_MerPaymentMode() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OpgEnt_MerPaymentMode(String paymentmodecode, String paymentmodedefault, String paymentmoderate) {
		super();
		this.paymentmodecode = paymentmodecode;
		this.paymentmodedefault = paymentmodedefault;
		this.paymentmoderate = paymentmoderate;
	}
	
	public String getPaymentmodecode() {
		return paymentmodecode;
	}
	public void setPaymentmodecode(String paymentmodecode) {
		this.paymentmodecode = paymentmodecode;
	}
	public String getPaymentmodedefault() {
		return paymentmodedefault;
	}
	public void setPaymentmodedefault(String paymentmodedefault) {
		this.paymentmodedefault = paymentmodedefault;
	}
	public String getPaymentmoderate() {
		return paymentmoderate;
	}
	public void setPaymentmoderate(String paymentmoderate) {
		this.paymentmoderate = paymentmoderate;
	}

	@Override
	public String toString() {
		return "OpgEnt_MerPaymentMode [paymentmodecode=" + paymentmodecode + ", paymentmodedefault="
				+ paymentmodedefault + ", paymentmoderate=" + paymentmoderate + "]";
	}	
	

}
