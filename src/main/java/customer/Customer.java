package customer;

public abstract class Customer {

	private String firstName;
	private String lastName;
	private String emailAddress;
	
	public Customer() {
		firstName = "firstName";
		lastName = "lastName";
		emailAddress = "default@example.com";
	}
	
	public Customer(String fName, String lName, String emailAddr) {
		firstName = fName; lastName = lName; emailAddress = emailAddr;
	}
	
	public String getFullName() { return firstName + " " + lastName; }
	
	@Override
	public String toString() { return firstName + " " + lastName + "\nEmail: " + emailAddress; }
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	
}
