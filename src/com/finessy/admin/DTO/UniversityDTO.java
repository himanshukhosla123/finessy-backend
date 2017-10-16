package com.finessy.admin.DTO;

import java.sql.Date;

public class UniversityDTO {
	
	private int universityId;
	private String universityName;
	private String campusSize;
	private Date founded;
	private String type;
	private String mapLocation;
	private String symbol;
	private String endowment;
	private String graduateEmploybilityRanking;
	private int totalStudents;
	private int totalUndergraduateStudents;
	private int totalGraduateStudents;
	private String ranking;
	private String percentageOfInternationalStudents;
	private String studentGroups;
	private String safetyIssues;
	private String acceptanceRate;
	private String contactDetails;
	
	public UniversityDTO() {}

	public UniversityDTO(int universityId, String universityName, String campusSize, Date founded, String type,
			String mapLocation, String symbol, String endowment, String graduateEmploybilityRanking, int totalStudents,
			int totalUndergraduateStudents, int totalGraduateStudents, String ranking,
			String percentageOfInternationalStudents, String studentGroups, String safetyIssues, String acceptanceRate,
			String contactDetails) {
		super();
		this.universityId = universityId;
		this.universityName = universityName;
		this.campusSize = campusSize;
		this.founded = founded;
		this.type = type;
		this.mapLocation = mapLocation;
		this.symbol = symbol;
		this.endowment = endowment;
		this.graduateEmploybilityRanking = graduateEmploybilityRanking;
		this.totalStudents = totalStudents;
		this.totalUndergraduateStudents = totalUndergraduateStudents;
		this.totalGraduateStudents = totalGraduateStudents;
		this.ranking = ranking;
		this.percentageOfInternationalStudents = percentageOfInternationalStudents;
		this.studentGroups = studentGroups;
		this.safetyIssues = safetyIssues;
		this.acceptanceRate = acceptanceRate;
		this.contactDetails = contactDetails;
	}

	public int getUniversityId() {
		return universityId;
	}

	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getCampusSize() {
		return campusSize;
	}

	public void setCampusSize(String campusSize) {
		this.campusSize = campusSize;
	}

	public Date getFounded() {
		return founded;
	}

	public void setFounded(Date founded) {
		this.founded = founded;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMapLocation() {
		return mapLocation;
	}

	public void setMapLocation(String mapLocation) {
		this.mapLocation = mapLocation;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getEndowment() {
		return endowment;
	}

	public void setEndowment(String endowment) {
		this.endowment = endowment;
	}

	public String getGraduateEmploybilityRanking() {
		return graduateEmploybilityRanking;
	}

	public void setGraduateEmploybilityRanking(String graduateEmploybilityRanking) {
		this.graduateEmploybilityRanking = graduateEmploybilityRanking;
	}

	public int getTotalStudents() {
		return totalStudents;
	}

	public void setTotalStudents(int totalStudents) {
		this.totalStudents = totalStudents;
	}

	public int getTotalUndergraduateStudents() {
		return totalUndergraduateStudents;
	}

	public void setTotalUndergraduateStudents(int totalUndergraduateStudents) {
		this.totalUndergraduateStudents = totalUndergraduateStudents;
	}

	public int getTotalGraduateStudents() {
		return totalGraduateStudents;
	}

	public void setTotalGraduateStudents(int totalGraduateStudents) {
		this.totalGraduateStudents = totalGraduateStudents;
	}

	public String getRanking() {
		return ranking;
	}

	public void setRanking(String ranking) {
		this.ranking = ranking;
	}

	public String getPercentageOfInternationalStudents() {
		return percentageOfInternationalStudents;
	}

	public void setPercentageOfInternationalStudents(String percentageOfInternationalStudents) {
		this.percentageOfInternationalStudents = percentageOfInternationalStudents;
	}

	public String getStudentGroups() {
		return studentGroups;
	}

	public void setStudentGroups(String studentGroups) {
		this.studentGroups = studentGroups;
	}

	public String getSafetyIssues() {
		return safetyIssues;
	}

	public void setSafetyIssues(String safetyIssues) {
		this.safetyIssues = safetyIssues;
	}

	public String getAcceptanceRate() {
		return acceptanceRate;
	}

	public void setAcceptanceRate(String acceptanceRate) {
		this.acceptanceRate = acceptanceRate;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	@Override
	public String toString() {
		return "UniversityDTO [universityId=" + universityId + ", universityName=" + universityName + ", campusSize="
				+ campusSize + ", founded=" + founded + ", type=" + type + ", mapLocation=" + mapLocation + ", symbol="
				+ symbol + ", endowment=" + endowment + ", graduateEmploybilityRanking=" + graduateEmploybilityRanking
				+ ", totalStudents=" + totalStudents + ", totalUndergraduateStudents=" + totalUndergraduateStudents
				+ ", totalGraduateStudents=" + totalGraduateStudents + ", ranking=" + ranking
				+ ", percentageOfInternationalStudents=" + percentageOfInternationalStudents + ", studentGroups="
				+ studentGroups + ", safetyIssues=" + safetyIssues + ", acceptanceRate=" + acceptanceRate
				+ ", contactDetails=" + contactDetails + "]";
	}

}
