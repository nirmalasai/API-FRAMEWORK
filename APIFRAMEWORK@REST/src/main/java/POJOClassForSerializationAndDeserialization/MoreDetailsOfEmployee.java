package POJOClassForSerializationAndDeserialization;

public class MoreDetailsOfEmployee {



	String empName;
	String [] empEmail;
	long [] empPhoneNumber;
	int id;

	public MoreDetailsOfEmployee(String empName, String[] empEmail, long[] empPhoneNumber, int id) {
		super();
		this.empName = empName;
		this.empEmail = empEmail;
		this.empPhoneNumber = empPhoneNumber;
		this.id = id;
	}

	public MoreDetailsOfEmployee() {
		super();
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String[] getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String[] empEmail) {
		this.empEmail = empEmail;
	}
	public long[] getEmpPhoneNumber() {
		return empPhoneNumber;
	}
	public void setEmpPhoneNumber(long[] empPhoneNumber) {
		this.empPhoneNumber = empPhoneNumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}



}
