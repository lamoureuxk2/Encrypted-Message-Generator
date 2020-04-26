package customer;

/**
 * A customer is represented by 3 strings and has methods for accessing those strings
 * @author lamoureuxk
 *
 */
public class Customer {

	private String firstName;
	private String lastName;
	private String emailAddress;
	private String type;
	
	public Customer(String type) {
		firstName = "firstName";
		lastName = "lastName";
		emailAddress = "default@example.com";
		this.type = type;
	}
	
	public Customer(String type, String fName, String lName, String emailAddr) {
		firstName = fName; lastName = lName; emailAddress = emailAddr; this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
