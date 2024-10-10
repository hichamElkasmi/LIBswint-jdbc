package com.ssw.bnk.swint.jdbc.entities;

import java.util.List;

public class OpgEnt_Merchant {
	

	private String operation;
	private String merchantappid;
	private String institution;
	private String branch;
	private String merchantid;
	private String merchantoldnew;
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
	private String ownerrtitle;
	private String ownerfirstname;
	private String ownerlastname;
	private String ownerbirthdate;
	private String ownerbirthlocation;
	private String ownernationalid;
	private String ownerpassportnumber;
	private String ownergender;
	private String ownernationality;
	private String currency;
	private String mxpaccountnumber;
	private String bankaccountnumber;
	private String accountoldnew;
	private String merchantprogram;
	private String merchantcategory;
	private String category;
	private List<OpgEnt_MerPaymentMode>  paymentmode;
	private List<OpgEnt_Address>  address;
	
	public OpgEnt_Merchant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public OpgEnt_Merchant(String operation, String merchantappid, String institution, String branch, String merchantid,
			String merchantoldnew, String corporatename, String nameDBA, String companytype, String licence,
			String serialnumber, String commercialregister, String capitalamount, String socialsecuritynumber,
			String taxidentity, String contractnumber, String ownerrtitle, String ownerfirstname, String ownerlastname,
			String ownerbirthdate, String ownerbirthlocation, String ownernationalid, String ownerpassportnumber,
			String ownergender, String ownernationality, String currency, String mxpaccountnumber,
			String bankaccountnumber, String accountoldnew, String merchantprogram, String merchantcategory,
			String category, List<OpgEnt_MerPaymentMode> paymentmode, List<OpgEnt_Address> address) {
		super();
		this.operation = operation;
		this.merchantappid = merchantappid;
		this.institution = institution;
		this.branch = branch;
		this.merchantid = merchantid;
		this.merchantoldnew = merchantoldnew;
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
		this.ownerrtitle = ownerrtitle;
		this.ownerfirstname = ownerfirstname;
		this.ownerlastname = ownerlastname;
		this.ownerbirthdate = ownerbirthdate;
		this.ownerbirthlocation = ownerbirthlocation;
		this.ownernationalid = ownernationalid;
		this.ownerpassportnumber = ownerpassportnumber;
		this.ownergender = ownergender;
		this.ownernationality = ownernationality;
		this.currency = currency;
		this.mxpaccountnumber = mxpaccountnumber;
		this.bankaccountnumber = bankaccountnumber;
		this.accountoldnew = accountoldnew;
		this.merchantprogram = merchantprogram;
		this.merchantcategory = merchantcategory;
		this.category = category;
		this.paymentmode = paymentmode;
		this.address = address;
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
	public String getMerchantid() {
		return merchantid;
	}
	public void setMerchantid(String merchantid) {
		this.merchantid = merchantid;
	}
	public String getMerchantoldnew() {
		return merchantoldnew;
	}
	public void setMerchantoldnew(String merchantoldnew) {
		this.merchantoldnew = merchantoldnew;
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
	public String getOwnerrtitle() {
		return ownerrtitle;
	}
	public void setOwnerrtitle(String ownerrtitle) {
		this.ownerrtitle = ownerrtitle;
	}
	public String getOwnerfirstname() {
		return ownerfirstname;
	}
	public void setOwnerfirstname(String ownerfirstname) {
		this.ownerfirstname = ownerfirstname;
	}
	public String getOwnerlastname() {
		return ownerlastname;
	}
	public void setOwnerlastname(String ownerlastname) {
		this.ownerlastname = ownerlastname;
	}
	public String getOwnerbirthdate() {
		return ownerbirthdate;
	}
	public void setOwnerbirthdate(String ownerbirthdate) {
		this.ownerbirthdate = ownerbirthdate;
	}
	public String getOwnerbirthlocation() {
		return ownerbirthlocation;
	}
	public void setOwnerbirthlocation(String ownerbirthlocation) {
		this.ownerbirthlocation = ownerbirthlocation;
	}
	public String getOwnernationalid() {
		return ownernationalid;
	}
	public void setOwnernationalid(String ownernationalid) {
		this.ownernationalid = ownernationalid;
	}
	public String getOwnerpassportnumber() {
		return ownerpassportnumber;
	}
	public void setOwnerpassportnumber(String ownerpassportnumber) {
		this.ownerpassportnumber = ownerpassportnumber;
	}
	public String getOwnergender() {
		return ownergender;
	}
	public void setOwnergender(String ownergender) {
		this.ownergender = ownergender;
	}
	public String getOwnernationality() {
		return ownernationality;
	}
	public void setOwnernationality(String ownernationality) {
		this.ownernationality = ownernationality;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getMxpaccountnumber() {
		return mxpaccountnumber;
	}
	public void setMxpaccountnumber(String mxpaccountnumber) {
		this.mxpaccountnumber = mxpaccountnumber;
	}
	public String getBankaccountnumber() {
		return bankaccountnumber;
	}
	public void setBankaccountnumber(String bankaccountnumber) {
		this.bankaccountnumber = bankaccountnumber;
	}
	public String getAccountoldnew() {
		return accountoldnew;
	}
	public void setAccountoldnew(String accountoldnew) {
		this.accountoldnew = accountoldnew;
	}
	public String getMerchantprogram() {
		return merchantprogram;
	}
	public void setMerchantprogram(String merchantprogram) {
		this.merchantprogram = merchantprogram;
	}
	public String getMerchantcategory() {
		return merchantcategory;
	}
	public void setMerchantcategory(String merchantcategory) {
		this.merchantcategory = merchantcategory;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	@Override
	public String toString() {
		return "OpgEnt_Merchant [operation=" + operation + ", merchantappid=" + merchantappid + ", institution="
				+ institution + ", branch=" + branch + ", merchantid=" + merchantid + ", merchantoldnew="
				+ merchantoldnew + ", corporatename=" + corporatename + ", nameDBA=" + nameDBA + ", companytype="
				+ companytype + ", licence=" + licence + ", serialnumber=" + serialnumber + ", commercialregister="
				+ commercialregister + ", capitalamount=" + capitalamount + ", socialsecuritynumber="
				+ socialsecuritynumber + ", taxidentity=" + taxidentity + ", contractnumber=" + contractnumber
				+ ", ownerrtitle=" + ownerrtitle + ", ownerfirstname=" + ownerfirstname + ", ownerlastname="
				+ ownerlastname + ", ownerbirthdate=" + ownerbirthdate + ", ownerbirthlocation=" + ownerbirthlocation
				+ ", ownernationalid=" + ownernationalid + ", ownerpassportnumber=" + ownerpassportnumber
				+ ", ownergender=" + ownergender + ", ownernationality=" + ownernationality + ", currency=" + currency
				+ ", mxpaccountnumber=" + mxpaccountnumber + ", bankaccountnumber=" + bankaccountnumber
				+ ", accountoldnew=" + accountoldnew + ", merchantprogram=" + merchantprogram + ", merchantcategory="
				+ merchantcategory + ", category=" + category + ", paymentmode=" + paymentmode + ", address=" + address
				+ "]";
	}
}
