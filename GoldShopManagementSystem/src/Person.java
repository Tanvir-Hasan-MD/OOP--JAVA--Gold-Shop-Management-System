
public class Person {
	private String name;
	private String gender;
	private String contact;
	private String address;
	
	public Person(String name, String gender, String contact, String address)
	{
		this.setName(name);
		this.setGender(gender);
		this.setContact(contact);
		this.setAddress(address);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

}
