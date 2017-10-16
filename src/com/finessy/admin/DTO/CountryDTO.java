package com.finessy.admin.DTO;

public class CountryDTO {
	
	private int countryId;
	private String countryName;
	private int noOfStudents;
	private int internationalStudentsPercent;
	private String status;
	private String happinessIndex;
	private String languagesSpoken;
	private String politicalStability;
	private String climate;
	private String safetyIndex;
	private String disasterProne;
	private String studentSatisfactionIndex;
	private String easeOfSettlement;
	private String easeOfBusiness;
	private int expenseForInternationalStudents;
	private String bestThing;
	private String smokingDrinkingLaws;
	private String currencyStrength;
	private String studentFriendlyCities;
	private String cuisinesAvailable;
	private String peculiarLaws;
	private String unknownFacts;
	
	public CountryDTO() {}

	public CountryDTO(int countryId, String countryName, int noOfStudents, int internationalStudentsPercent,
			String status, String happinessIndex, String languagesSpoken, String politicalStability, String climate,
			String safetyIndex, String disasterProne, String studentSatisfactionIndex, String easeOfSettlement,
			String easeOfBusiness, int expenseForInternationalStudents, String bestThing, String smokingDrinkingLaws,
			String currencyStrength, String studentFriendlyCities, String cuisinesAvailable, String peculiarLaws,
			String unknownFacts) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.noOfStudents = noOfStudents;
		this.internationalStudentsPercent = internationalStudentsPercent;
		this.status = status;
		this.happinessIndex = happinessIndex;
		this.languagesSpoken = languagesSpoken;
		this.politicalStability = politicalStability;
		this.climate = climate;
		this.safetyIndex = safetyIndex;
		this.disasterProne = disasterProne;
		this.studentSatisfactionIndex = studentSatisfactionIndex;
		this.easeOfSettlement = easeOfSettlement;
		this.easeOfBusiness = easeOfBusiness;
		expenseForInternationalStudents = expenseForInternationalStudents;
		this.bestThing = bestThing;
		this.smokingDrinkingLaws = smokingDrinkingLaws;
		this.currencyStrength = currencyStrength;
		this.studentFriendlyCities = studentFriendlyCities;
		this.cuisinesAvailable = cuisinesAvailable;
		this.peculiarLaws = peculiarLaws;
		this.unknownFacts = unknownFacts;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	public int getInternationalStudentsPercent() {
		return internationalStudentsPercent;
	}

	public void setInternationalStudentsPercent(int internationalStudentsPercent) {
		this.internationalStudentsPercent = internationalStudentsPercent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHappinessIndex() {
		return happinessIndex;
	}

	public void setHappinessIndex(String happinessIndex) {
		this.happinessIndex = happinessIndex;
	}

	public String getLanguagesSpoken() {
		return languagesSpoken;
	}

	public void setLanguagesSpoken(String languagesSpoken) {
		this.languagesSpoken = languagesSpoken;
	}

	public String getPoliticalStability() {
		return politicalStability;
	}

	public void setPoliticalStability(String politicalStability) {
		this.politicalStability = politicalStability;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public String getSafetyIndex() {
		return safetyIndex;
	}

	public void setSafetyIndex(String safetyIndex) {
		this.safetyIndex = safetyIndex;
	}

	public String getDisasterProne() {
		return disasterProne;
	}

	public void setDisasterProne(String disasterProne) {
		this.disasterProne = disasterProne;
	}

	public String getStudentSatisfactionIndex() {
		return studentSatisfactionIndex;
	}

	public void setStudentSatisfactionIndex(String studentSatisfactionIndex) {
		this.studentSatisfactionIndex = studentSatisfactionIndex;
	}

	public String getEaseOfSettlement() {
		return easeOfSettlement;
	}

	public void setEaseOfSettlement(String easeOfSettlement) {
		this.easeOfSettlement = easeOfSettlement;
	}

	public String getEaseOfBusiness() {
		return easeOfBusiness;
	}

	public void setEaseOfBusiness(String easeOfBusiness) {
		this.easeOfBusiness = easeOfBusiness;
	}

	public int getExpenseForInternationalStudents() {
		return expenseForInternationalStudents;
	}

	public void setExpenseForInternationalStudents(int expenseForInternationalStudents) {
		expenseForInternationalStudents = expenseForInternationalStudents;
	}

	public String getBestThing() {
		return bestThing;
	}

	public void setBestThing(String bestThing) {
		this.bestThing = bestThing;
	}

	public String getSmokingDrinkingLaws() {
		return smokingDrinkingLaws;
	}

	public void setSmokingDrinkingLaws(String smokingDrinkingLaws) {
		this.smokingDrinkingLaws = smokingDrinkingLaws;
	}

	public String getCurrencyStrength() {
		return currencyStrength;
	}

	public void setCurrencyStrength(String currencyStrength) {
		this.currencyStrength = currencyStrength;
	}

	public String getStudentFriendlyCities() {
		return studentFriendlyCities;
	}

	public void setStudentFriendlyCities(String studentFriendlyCities) {
		this.studentFriendlyCities = studentFriendlyCities;
	}

	public String getCuisinesAvailable() {
		return cuisinesAvailable;
	}

	public void setCuisinesAvailable(String cuisinesAvailable) {
		this.cuisinesAvailable = cuisinesAvailable;
	}

	public String getPeculiarLaws() {
		return peculiarLaws;
	}

	public void setPeculiarLaws(String peculiarLaws) {
		this.peculiarLaws = peculiarLaws;
	}

	public String getUnknownFacts() {
		return unknownFacts;
	}

	public void setUnknownFacts(String unknownFacts) {
		this.unknownFacts = unknownFacts;
	}

	@Override
	public String toString() {
		return "CountryDTO [countryId=" + countryId + ", countryName=" + countryName + ", noOfStudents=" + noOfStudents
				+ ", internationalStudentsPercent=" + internationalStudentsPercent + ", status=" + status
				+ ", happinessIndex=" + happinessIndex + ", languagesSpoken=" + languagesSpoken
				+ ", politicalStability=" + politicalStability + ", climate=" + climate + ", safetyIndex=" + safetyIndex
				+ ", disasterProne=" + disasterProne + ", studentSatisfactionIndex=" + studentSatisfactionIndex
				+ ", easeOfSettlement=" + easeOfSettlement + ", easeOfBusiness=" + easeOfBusiness
				+ ", ExpenseForInternationalStudents=" + expenseForInternationalStudents + ", bestThing=" + bestThing
				+ ", smokingDrinkingLaws=" + smokingDrinkingLaws + ", currencyStrength=" + currencyStrength
				+ ", studentFriendlyCities=" + studentFriendlyCities + ", cuisinesAvailable=" + cuisinesAvailable
				+ ", peculiarLaws=" + peculiarLaws + ", unknownFacts=" + unknownFacts + "]";
	}

}
