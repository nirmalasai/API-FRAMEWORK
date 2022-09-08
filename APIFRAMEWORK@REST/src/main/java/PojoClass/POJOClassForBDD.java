package PojoClass;

public class POJOClassForBDD {
	
	//step1::declare the variables globally
	String createdBy;
	String projectName;
	String status;
    int  teamSize;
    
    
    //Step2::Create a parameterized constructor
	public POJOClassForBDD(String createdBy, String projectName, String status, int teamSize) {
		super();
		this.createdBy = createdBy;
		this.projectName = projectName;
		this.status = status;
		this.teamSize = teamSize;
	}
	
	
	 //Step3::Create a noArguement constructor
	public POJOClassForBDD() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Step4::provide getter and setter methods
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	
	

}
