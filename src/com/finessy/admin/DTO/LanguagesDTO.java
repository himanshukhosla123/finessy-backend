package com.finessy.admin.DTO;

public class LanguagesDTO {
	
	private int countryId;
	private String languagesSpoken;
	
	public LanguagesDTO() {}

	public LanguagesDTO(int countryId, String languagesSpoken) {
		super();
		this.countryId = countryId;
		this.languagesSpoken = languagesSpoken;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getLanguagesSpoken() {
		return languagesSpoken;
	}

	public void setLanguagesSpoken(String languagesSpoken) {
		this.languagesSpoken = languagesSpoken;
	}

	@Override
	public String toString() {
		return "LanguagesDTO [countryId=" + countryId + ", languagesSpoken=" + languagesSpoken + "]";
	}

}
