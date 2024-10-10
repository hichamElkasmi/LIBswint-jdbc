package com.ssw.bnk.swint.jdbc.entities;

import java.util.List;

public class OpgEnt_MerchantUpdate {
	
	@Override
	public String toString() {
		return "OpgEnt_MerchantUpdate [operation=" + operation + ", merchantappid=" + merchantappid + ", institution="
				+ institution + ", branch=" + branch + ", corporatename=" + corporatename + ", nameDBA=" + nameDBA
				+ ", companytype=" + companytype + ", licence=" + licence + ", serialnumber=" + serialnumber
				+ ", commercialregister=" + commercialregister + ", capitalamount=" + capitalamount
				+ ", socialsecuritynumber=" + socialsecuritynumber + ", taxidentity=" + taxidentity
				+ ", contractnumber=" + contractnumber + ", paymentmode=" + paymentmode + ", address=" + address + "]";
	}

	private String operation;
	private String merchantappid;
	private String institution;
	private String branch;
	private String corporatename;
	private String nameDBA;
	private String companytype;
	private String licence;
	private String serialnumber;
	private String commercialregister;
	private String capitalamount;
	private String socialsecuritynumber;
	private String taxidentity;
	private String contractnumber;
	private List<OpgEnt_MerPaymentMode>  paymentmode;
	private List<OpgEnt_Address>  address;
	private String merchantprogram;
	
	public String getMerchantprogram() {
		return merchantprogram;
	}

	public void setMerchantprogram(String merchantprogram) {
		this.merchantprogram = merchantprogram;
	}

	public OpgEnt_MerchantUpdate(String operation, String merchantappid, String institution, String branch,
			String corporatename, String nameDBA, String companytype, String licence, String serialnumber,
			String commercialregister, String capitalamount, String socialsecuritynumber, String taxidentity,
			String contractnumber, List<OpgEnt_MerPaymentMode> paymentmode, List<OpgEnt_Address> address) {
		super();
		this.operation = operation;
		this.merchantappid = merchantappid;
		this.institution = institution;
		this.branch = branch;
		this.corporatename = corporatename;
		this.nameDBA = nameDBA;
		this.companytype = companytype;
		this.licence = licence;
		this.serialnumber = serialnumber;
		this.commercialregister = commercialregister;
		this.capitalamount = capitalamount;
		this.socialsecuritynumber = socialsecuritynumber;
		this.taxidentity = taxidentity;
		this.contractnumber = contractnumber;
		this.paymentmode = paymentmode;
		this.address = address;
	}

	public OpgEnt_MerchantUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getMerchantappid() {
		return merchantappid;
	}

	public void setMerchantappid(String merchantappid) {
		this.merchantappid = merchantappid;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCorporatename() {
		return corporatename;
	}

	public void setCorporatename(String corporatename) {
		this.corporatename = corporatename;
	}

	public String getNameDBA() {
		return nameDBA;
	}

	public void setNameDBA(String nameDBA) {
		this.nameDBA = nameDBA;
	}

	public String getCompanytype() {
		return companytype;
	}

	public void setCompanytype(String companytype) {
		this.companytype = companytype;
	}

	public String getLicence() {
		return licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

	public String getSerialnumber() {
		return serialnumber;
	}

	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}

	public String getCommercialregister() {
		return commercialregister;
	}

	public void setCommercialregister(String commercialregister) {
		this.commercialregister = commercialregister;
	}

	public String getCapitalamount() {
		return capitalamount;
	}

	public void setCapitalamount(String capitalamount) {
		this.capitalamount = capitalamount;
	}

	public String getSocialsecuritynumber() {
		return socialsecuritynumber;
	}

	public void setSocialsecuritynumber(String socialsecuritynumber) {
		this.socialsecuritynumber = socialsecuritynumber;
	}

	public String getTaxidentity() {
		return taxidentity;
	}

	public void setTaxidentity(String taxidentity) {
		this.taxidentity = taxidentity;
	}

	public String getContractnumber() {
		return contractnumber;
	}

	public void setContractnumber(String contractnumber) {
		this.contractnumber = contractnumber;
	}

	public List<OpgEnt_MerPaymentMode> getPaymentmode() {
		return paymentmode;
	}

	public void setPaymentmode(List<OpgEnt_MerPaymentMode> paymentmode) {
		this.paymentmode = paymentmode;
	}

	public List<OpgEnt_Address> getAddress() {
		return address;
	}

	public void setAddress(List<OpgEnt_Address> address) {
		this.address = address;
	}
	
}
