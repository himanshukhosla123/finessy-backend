package sanuj.finessy.admin.DTO;

public class ScholarsDTO {

	private int universityId;
	private String scholars;
	
	public ScholarsDTO() {}

	@Override
	public String toString() {
		return "ScholarsDTO [universityId=" + universityId + ", scholars=" + scholars + "]";
	}

	public ScholarsDTO(int universityId, String scholars) {
		this.universityId = universityId;
		this.scholars = scholars;
	}

	public int getUniversityId() {
		return universityId;
	}

	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}

	public String getScholars() {
		return scholars;
	}

	public void setScholars(String scholars) {
		this.scholars = scholars;
	}
	
	
}
