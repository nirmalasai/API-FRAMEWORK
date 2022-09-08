package POJOClassForSerializationAndDeserialization;

public class Employee {
	 String empName;
	int empId;
	String[] empEmail;
	long [] phoneNumber;
	Spouse spouse;

	
	//No arrguement constructor
	public Employee() {

	}

	public Employee(String empName, int empId, String[] empEmail, long[] phoneNumber, Spouse spouse) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.empEmail = empEmail;
		this.phoneNumber = phoneNumber;
		this.spouse = spouse;
	}


	//getter and setter
	public String getEmpName() {
		return empName;
	}
	//parametrized constructor
	
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	


	public Spouse getSpouse() {
		return spouse;
	}


	public void setSpouse(Spouse spouse) {
		this.spouse = spouse;
	}


	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public String[] getEmpEmail() {
		return empEmail;
	}


	public void setEmpEmail(String[] empEmail) {
		this.empEmail = empEmail;
	}


	public long[] getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(long[] phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	



}
