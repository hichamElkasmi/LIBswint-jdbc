package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_FilterGetPrintData {
    private String card;
    private String institution;
   

    public OpgEnt_FilterGetPrintData(String card, String institution) {
        this.card = card;
       
        this.institution = institution;
       
    }

    public String getCard() {
        return card;
    }

    
    public String getInstitution() {
        return institution;
    }

   
}