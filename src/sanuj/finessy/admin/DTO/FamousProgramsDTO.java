package sanuj.finessy.admin.DTO;

public class FamousProgramsDTO {

	private int universityId;
	private String famousPrograms;
	
	public FamousProgramsDTO() {}

	@Override
	public String toString() {
		return "FamousProgramsDTO [universityId=" + universityId + ", famousPrograms=" + famousPrograms + "]";
	}

	public FamousProgramsDTO(int universityId, String famousPrograms) {
		this.universityId = universityId;
		this.famousPrograms = famousPrograms;
	}

	public int getUniversityId() {
		return universityId;
	}

	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}

	public String getFamousPrograms() {
		return famousPrograms;
	}

	public void setFamousPrograms(String famousPrograms) {
		this.famousPrograms = famousPrograms;
	}
	
	
}
