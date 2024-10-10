package com.ssw.bnk.swint.jdbc.entities;


public class OpgEnt_SmsAlert {

	private String card;
	private String phone;
	private String customerid;
	private String institution;
	private String notification;

    public OpgEnt_SmsAlert(String card, String phone, String customerid, String institution, String notification) {
        this.card = card;
        this.phone = phone;
        this.customerid = customerid;
        this.institution = institution;
        this.notification = notification;
    }

    public String getCard() {
        return card;
    }

    public String getPhone() {
        return phone;
    }

    public String getCustomerid() {
        return customerid;
    }

    public String getInstitution() {
        return institution;
    }

    public String getNotification() {
        return notification;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

}
