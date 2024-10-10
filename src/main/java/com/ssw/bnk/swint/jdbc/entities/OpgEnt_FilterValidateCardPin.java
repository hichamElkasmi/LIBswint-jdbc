package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_FilterValidateCardPin {
    private String card;
    private String expiry_date;
    private String cvv;
    private String encrypted_pin;
    private String institution;
    private String track1;
    private String track2;
    private String track3;

    public OpgEnt_FilterValidateCardPin(String card, String expiry_date, String cvv, String encrypted_pin, String institution, String track1, String track2, String track3) {
        this.card = card;
        this.expiry_date = expiry_date;
        this.cvv = cvv;
        this.encrypted_pin = encrypted_pin;
        this.institution = institution;
        this.track1 = track1;
        this.track2 = track2;
        this.track3 = track3;
    }

    public String getCard() {
        return card;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public String getCvv() {
        return cvv;
    }

    public String getEncrypted_pin() {
        return encrypted_pin;
    }

    public String getInstitution() {
        return institution;
    }

    public String getTrack1() {
        return track1;
    }

    public String getTrack2() {
        return track2;
    }

    public String getTrack3() {
        return track3;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setEncrypted_pin(String encrypted_pin) {
        this.encrypted_pin = encrypted_pin;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public void setTrack1(String track1) {
        this.track1 = track1;
    }

    public void setTrack2(String track2) {
        this.track2 = track2;
    }

    public void setTrack3(String track3) {
        this.track3 = track3;
    } 
}