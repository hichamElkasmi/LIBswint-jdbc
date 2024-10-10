package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_FilterMerchantTerminalTransaction {

	private String merchantId;
	private String terminalId;
	private String transactionType;
	private String authenticationNumber;
	private String status;
	private String institution;
	private String startDate;
	private String endDate;
	private String start;
	private String end;

	public OpgEnt_FilterMerchantTerminalTransaction(String merchantId, String terminalId, String transactionType,
			String authenticationNumber, String status, String institution, String startDate, String endDate,
			String start, String end) {
		super();
		this.merchantId = merchantId;
		this.terminalId = terminalId;
		this.transactionType = transactionType;
		this.authenticationNumber = authenticationNumber;
		this.status = status;
		this.institution = institution;
		this.startDate = startDate;
		this.endDate = endDate;
		this.start = start;
		this.end = end;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getAuthenticationNumber() {
		return authenticationNumber;
	}

	public void setAuthenticationNumber(String authenticationNumber) {
		this.authenticationNumber = authenticationNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
		return "OpgEnt_FilterMerchantTerminalTransaction [merchantId=" + merchantId + ", terminalId=" + terminalId
				+ ", transactionType=" + transactionType + ", authenticationNumber=" + authenticationNumber
				+ ", status=" + status + ", institution=" + institution + ", startDate=" + startDate + ", endDate="
				+ endDate + ", start=" + start + ", end=" + end + "]";
	}

}
