package com.finessy.admin.DTO;

public class AlumniDTO {
	
	private int universityId;
	private String famousAlumni;
	private String image;
	
	public AlumniDTO() {}

	public AlumniDTO(int universityId, String famousAlumni, String image) {
		super();
		this.universityId = universityId;
		this.famousAlumni = famousAlumni;
		this.image = image;
	}

	public int getUniversityId() {
		return universityId;
	}

	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}

	public String getFamousAlumni() {
		return famousAlumni;
	}

	public void setFamousAlumni(String famousAlumni) {
		this.famousAlumni = famousAlumni;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "AlumniDTO [universityId=" + universityId + ", famousAlumni=" + famousAlumni + ", image=" + image + "]";
	}

}
