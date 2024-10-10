package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_InitiatorManageAddress {
	
	private String bankcode ;
	private String operation ;
	private String entity ;
	private String entityid ;
	private String address1 ;
	private String address2 ;
	private String adr_STR ;
	private String city ;
	private String phone ;
	private String zipaddress ;
	private String fax ;
	private String branchcode ;
	private String adr_id ;
	private String adr_type;
	
	public OpgEnt_InitiatorManageAddress() {
		super();
	}



	public OpgEnt_InitiatorManageAddress(String bankcode, String operation, String entity, String entityid,
			String address1, String address2, String adr_STR, String city, String phone, String zipaddress, String fax,
			String branchcode, String adr_id, String adr_type) {
		super();
		this.bankcode = bankcode;
		this.operation = operation;
		this.entity = entity;
		this.entityid = entityid;
		this.address1 = address1;
		this.address2 = address2;
		this.adr_STR = adr_STR;
		this.city = city;
		this.phone = phone;
		this.zipaddress = zipaddress;
		this.fax = fax;
		this.branchcode = branchcode;
		this.adr_id = adr_id;
		this.adr_type = adr_type;
	}



	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getEntityid() {
		return entityid;
	}

	public void setEntityid(String entityid) {
		this.entityid = entityid;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAdr_STR() {
		return adr_STR;
	}

	public void setAdr_STR(String adr_STR) {
		this.adr_STR = adr_STR;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZipaddress() {
		return zipaddress;
	}

	public void setZipaddress(String zipaddress) {
		this.zipaddress = zipaddress;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getBranchcode() {
		return branchcode;
	}

	public void setBranchcode(String branchcode) {
		this.branchcode = branchcode;
	}

	public String getAdr_id() {
		return adr_id;
	}

	public void setAdr_id(String adr_id) {
		this.adr_id = adr_id;
	}

	public String getAdr_type() {
		return adr_type;
	}

	public void setAdr_type(String adr_type) {
		this.adr_type = adr_type;
	}



	public String getOperation() {
		return operation;
	}



	public void setOperation(String operation) {
		this.operation = operation;
	}

	
	
	
	
	

}
