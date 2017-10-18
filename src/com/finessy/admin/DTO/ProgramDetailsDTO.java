package com.finessy.admin.DTO;

import java.sql.Date;

public class ProgramDetailsDTO {
	
	private int universityId;
	private String degree;
	private int fieldId;
	private int intakeAvailable;
	private Date programApplicationDeadline;
	private String requirements;
	
	public ProgramDetailsDTO() {}

	public ProgramDetailsDTO(int universityId, String degree, int fieldId, int intakeAvailable,
			Date programApplicationDeadline, String requirements) {
		super();
		this.universityId = universityId;
		this.degree = degree;
		this.fieldId = fieldId;
		this.intakeAvailable = intakeAvailable;
		this.programApplicationDeadline = programApplicationDeadline;
		this.requirements = requirements;
	}

	public int getUniversityId() {
		return universityId;
	}

	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public int getFieldId() {
		return fieldId;
	}

	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}

	public int getIntakeAvailable() {
		return intakeAvailable;
	}

	public void setIntakeAvailable(int intakeAvailable) {
		this.intakeAvailable = intakeAvailable;
	}

	public Date getProgramApplicationDeadline() {
		return programApplicationDeadline;
	}

	public void setProgramApplicationDeadline(Date programApplicationDeadline) {
		this.programApplicationDeadline = programApplicationDeadline;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	@Override
	public String toString() {
		return "ProgramDetailsDTO [universityId=" + universityId + ", degree=" + degree + ", fieldId=" + fieldId
				+ ", intakeAvailable=" + intakeAvailable + ", programApplicationDeadline=" + programApplicationDeadline
				+ ", requirements=" + requirements + "]";
	}

}
