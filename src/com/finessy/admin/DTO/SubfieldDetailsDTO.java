package com.finessy.admin.DTO;

public class SubfieldDetailsDTO {
	
	private int fieldId;
	private String discipline;
	private String program;
	private String jobs;
	
	public SubfieldDetailsDTO() {}

	public SubfieldDetailsDTO(int fieldId, String discipline, String program, String jobs) {
		super();
		this.fieldId = fieldId;
		this.discipline = discipline;
		this.program = program;
		this.jobs = jobs;
	}

	public int getFieldId() {
		return fieldId;
	}

	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}

	public String getDiscipline() {
		return discipline;
	}

	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getJobs() {
		return jobs;
	}

	public void setJobs(String jobs) {
		this.jobs = jobs;
	}

	@Override
	public String toString() {
		return "SubfieldDetailsDTO [fieldId=" + fieldId + ", discipline=" + discipline + ", program=" + program
				+ ", jobs=" + jobs + "]";
	}

}
