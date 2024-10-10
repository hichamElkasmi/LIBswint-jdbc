package com.ssw.bnk.swint.jdbc.entities;

public class OpgRent_FilterPosMonitoring {

	private String merchantId;
	private String start;
	private String end;

	public OpgRent_FilterPosMonitoring(String merchantId, String start, String end) {
		super();
		this.merchantId = merchantId;
		this.start = start;
		this.end = end;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
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

	@Override
	public String toString() {
		return "OpgRent_FilterPosMonitoring [merchantId=" + merchantId + ", start=" + start + ", end=" + end + "]";
	}

}
