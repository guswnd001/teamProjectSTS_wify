package model;

public class TheaterInfo {

	private String company_code;
	private String region_code;
	private String region_name;
	private String theater_code;
	private String theater_name;
	private String exist_4d;
	private String exist_imax;
	private String exist_normal;

	public String getCompany_code() {
		return company_code;
	}

	public void setCompany_code(String company_code) {
		this.company_code = company_code;
	}

	public String getRegion_code() {
		return region_code;
	}

	public void setRegion_code(String region_code) {
		this.region_code = region_code;
	}

	public String getTheater_code() {
		return theater_code;
	}

	public void setTheater_code(String theater_code) {
		this.theater_code = theater_code;
	}

	public String getTheater_name() {
		return theater_name;
	}

	public void setTheater_name(String theater_name) {
		this.theater_name = theater_name;
	}

	public String getExist_4d() {
		return exist_4d;
	}

	public void setExist_4d(String exist_4d) {
		this.exist_4d = exist_4d;
	}

	public String getExist_imax() {
		return exist_imax;
	}

	public void setExist_imax(String exist_imax) {
		this.exist_imax = exist_imax;
	}

	public String getExist_normal() {
		return exist_normal;
	}

	public void setExist_normal(String exist_normal) {
		this.exist_normal = exist_normal;
	}

	public String getRegion_name() {
		return region_name;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	@Override
	public String toString() {
		return "TheaterInfo [company_code=" + company_code + ", region_code=" + region_code + ", region_name="
				+ region_name + ", theater_code=" + theater_code + ", theater_name=" + theater_name + ", exist_4d="
				+ exist_4d + ", exist_imax=" + exist_imax + ", exist_normal=" + exist_normal + "]";
	}
	
	
	
}
