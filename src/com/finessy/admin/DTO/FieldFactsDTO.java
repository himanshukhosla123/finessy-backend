package com.finessy.admin.DTO;

public class FieldFactsDTO {
	
	private int fieldId;
	private String bestMarket;
	private int salaryAfter;
	private String scopeInEachCountry;
	private String typesOfJobs;
	private int theirSalaries;
	private int numberOfStudents;
	private int numberOfStudentsInterested;
	private String currentTrends;
	private String valueOfDegreeToWork;
	private String toGetHired;
	
	public FieldFactsDTO() {}

	public FieldFactsDTO(int fieldId, String bestMarket, int salaryAfter, String scopeInEachCountry, String typesOfJobs,
			int theirSalaries, int numberOfStudents, int numberOfStudentsInterested, String currentTrends,
			String valueOfDegreeToWork, String toGetHired) {
		super();
		this.fieldId = fieldId;
		this.bestMarket = bestMarket;
		this.salaryAfter = salaryAfter;
		this.scopeInEachCountry = scopeInEachCountry;
		this.typesOfJobs = typesOfJobs;
		this.theirSalaries = theirSalaries;
		this.numberOfStudents = numberOfStudents;
		this.numberOfStudentsInterested = numberOfStudentsInterested;
		this.currentTrends = currentTrends;
		this.valueOfDegreeToWork = valueOfDegreeToWork;
		this.toGetHired = toGetHired;
	}

	public int getFieldId() {
		return fieldId;
	}

	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}

	public String getBestMarket() {
		return bestMarket;
	}

	public void setBestMarket(String bestMarket) {
		this.bestMarket = bestMarket;
	}

	public int getSalaryAfter() {
		return salaryAfter;
	}

	public void setSalaryAfter(int salaryAfter) {
		this.salaryAfter = salaryAfter;
	}

	public String getScopeInEachCountry() {
		return scopeInEachCountry;
	}

	public void setScopeInEachCountry(String scopeInEachCountry) {
		this.scopeInEachCountry = scopeInEachCountry;
	}

	public String getTypesOfJobs() {
		return typesOfJobs;
	}

	public void setTypesOfJobs(String typesOfJobs) {
		this.typesOfJobs = typesOfJobs;
	}

	public int getTheirSalaries() {
		return theirSalaries;
	}

	public void setTheirSalaries(int theirSalaries) {
		this.theirSalaries = theirSalaries;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	public int getNumberOfStudentsInterested() {
		return numberOfStudentsInterested;
	}

	public void setNumberOfStudentsInterested(int numberOfStudentsInterested) {
		this.numberOfStudentsInterested = numberOfStudentsInterested;
	}

	public String getCurrentTrends() {
		return currentTrends;
	}

	public void setCurrentTrends(String currentTrends) {
		this.currentTrends = currentTrends;
	}

	public String getValueOfDegreeToWork() {
		return valueOfDegreeToWork;
	}

	public void setValueOfDegreeToWork(String valueOfDegreeToWork) {
		this.valueOfDegreeToWork = valueOfDegreeToWork;
	}

	public String getToGetHired() {
		return toGetHired;
	}

	public void setToGetHired(String toGetHired) {
		this.toGetHired = toGetHired;
	}

	@Override
	public String toString() {
		return "FieldFactsDTO [fieldId=" + fieldId + ", bestMarket=" + bestMarket + ", salaryAfter=" + salaryAfter
				+ ", scopeInEachCountry=" + scopeInEachCountry + ", typesOfJobs=" + typesOfJobs + ", theirSalaries="
				+ theirSalaries + ", numberOfStudents=" + numberOfStudents + ", numberOfStudentsInterested="
				+ numberOfStudentsInterested + ", currentTrends=" + currentTrends + ", valueOfDegreeToWork="
				+ valueOfDegreeToWork + ", toGetHired=" + toGetHired + "]";
	}

}
