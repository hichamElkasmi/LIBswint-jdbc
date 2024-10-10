package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_FilterProgramRisk {

	private String cardCode;
	private String cardNumber;
	private String programCode;
	private String institution;
	

	public String getProgramCode() {
		return programCode;
	}

	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}

	

	public String getCardCode() {
		return cardCode;
	}

	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public OpgEnt_FilterProgramRisk(String cardCode, String cardNumber, String programCode, String institution) {
		super();
		this.cardCode = cardCode;
		this.cardNumber = cardNumber;
		this.programCode = programCode;
		this.institution = institution;
	}

	@Override
	public String toString() {
		return "OpgEnt_FilterProgramRisk [cardCode=" + cardCode + ", cardNumber=" + cardNumber + ", programCode="
				+ programCode + ", institution=" + institution + "]";
	}


}
