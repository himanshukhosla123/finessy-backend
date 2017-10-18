package com.finessy.admin.DTO;

public class LanguagesDTO {
	
	private int country_id;
	private String languagesSpoken;
	
	public LanguagesDTO() {}

	public LanguagesDTO(int country_id, String languagesSpoken) {
		super();
		this.country_id = country_id;
		this.languagesSpoken = languagesSpoken;
	}

	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

	public String getLanguagesSpoken() {
		return languagesSpoken;
	}

	public void setLanguagesSpoken(String languagesSpoken) {
		this.languagesSpoken = languagesSpoken;
	}

	@Override
	public String toString() {
		return "LanguagesDTO [country_id=" + country_id + ", languagesSpoken=" + languagesSpoken + "]";
	}

}
