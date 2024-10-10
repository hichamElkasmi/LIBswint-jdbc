package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_FilterCardList {
	   //DSLAOUI 31032021 AJOUT NUMERO DE COMPTE DANS LE FILTRE
	private String account;
	private String card;
	private String customer;
	private String name_on_card;
	private String institution;
	private String start;
	private String end;
	private String pan;
     
	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	
	public OpgEnt_FilterCardList(String account,String card, String customer, String name_on_card, String institution, String start,
			String end, String pan) {
		super();
                   //DSLAOUI 31032021 AJOUT NUMERO DE COMPTE DANS LE FILTRE
                this.account = account;
		this.card = card;
		this.customer = customer;
		this.name_on_card = name_on_card;
		this.institution = institution;
		this.start = start;
		this.end = end;
		this.pan = pan;
              
	}

	public OpgEnt_FilterCardList() {
		super();
		// TODO Auto-generated constructor stub
	}
        
        //DSLAOUI 31032021 AJOUT NUMERO DE COMPTE DANS LE FILTRE
public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getName_on_card() {
		return name_on_card;
	}

	public void setName_on_card(String name_on_card) {
		this.name_on_card = name_on_card;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
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

}
