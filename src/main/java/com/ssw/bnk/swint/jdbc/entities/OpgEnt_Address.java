package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_Address {
	
	private String addresstype;
	private String addresscorresp;
	private String address1;
	private String address2;
	private String addressstre;
	private String addresszipd;
	private String phonenumber1;
	private String phonenumber2;
	private String fax;
	private String email;
	private String city;
	private String postalcode;
	private String country;
	
	public OpgEnt_Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OpgEnt_Address(String addresstype, String addresscorresp, String address1, String address2,
			String addressstre, String addresszipd, String phonenumber1, String phonenumber2, String fax, String email,
			String city, String postalcode, String country) {
		super();
		this.addresstype = addresstype;
		this.addresscorresp = addresscorresp;
		this.address1 = address1;
		this.address2 = address2;
		this.addressstre = addressstre;
		this.addresszipd = addresszipd;
		this.phonenumber1 = phonenumber1;
		this.phonenumber2 = phonenumber2;
		this.fax = fax;
		this.email = email;
		this.city = city;
		this.postalcode = postalcode;
		this.country = country;
	}

	public String getAddresstype() {
		return addresstype;
	}

	public void setAddresstype(String addresstype) {
		this.addresstype = addresstype;
	}

	public String getAddresscorresp() {
		return addresscorresp;
	}

	public void setAddresscorresp(String addresscorresp) {
		this.addresscorresp = addresscorresp;
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

	public String getAddressstre() {
		return addressstre;
	}

	public void setAddressstre(String addressstre) {
		this.addressstre = addressstre;
	}

	public String getAddresszipd() {
		return addresszipd;
	}

	public void setAddresszipd(String addresszipd) {
		this.addresszipd = addresszipd;
	}

	public String getPhonenumber1() {
		return phonenumber1;
	}

	public void setPhonenumber1(String phonenumber1) {
		this.phonenumber1 = phonenumber1;
	}

	public String getPhonenumber2() {
		return phonenumber2;
	}

	public void setPhonenumber2(String phonenumber2) {
		this.phonenumber2 = phonenumber2;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "OpgEnt_Address [addresstype=" + addresstype + ", addresscorresp=" + addresscorresp + ", address1="
				+ address1 + ", address2=" + address2 + ", addressstre=" + addressstre + ", addresszipd=" + addresszipd
				+ ", phonenumber1=" + phonenumber1 + ", phonenumber2=" + phonenumber2 + ", fax=" + fax + ", email="
				+ email + ", city=" + city + ", postalcode=" + postalcode + ", Country=" + country + "]";
	}
	
}
