package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_IniatorGetRepos {

	private String data;
	private String institution;

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public OpgEnt_IniatorGetRepos(String data, String institution) {
		super();
		this.data = data;
		this.institution = institution;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public OpgEnt_IniatorGetRepos() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
