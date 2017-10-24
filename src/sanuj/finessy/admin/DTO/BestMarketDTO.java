package sanuj.finessy.admin.DTO;

public class BestMarketDTO {

	private int fieldId;
	private int countryId;
	
	public BestMarketDTO() {}

	public BestMarketDTO(int fieldId, int countryId) {
		this.fieldId = fieldId;
		this.countryId = countryId;
	}

	public int getFieldId() {
		return fieldId;
	}

	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	@Override
	public String toString() {
		return "BestMarketDTO [fieldId=" + fieldId + ", countryId=" + countryId + "]";
	}
	
}
