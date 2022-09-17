
public class Employee extends Person{
	private int empID;

	public Employee(String name, String gender, String contact, String address, int empID) {
		super(name, gender, contact, address);
		this.empID = empID;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

}
