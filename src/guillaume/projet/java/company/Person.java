package guillaume.projet.java.company;

public class Person {

	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private int age;

	public Person(String firstName, String lastName, String phone, int age, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
		this.phone = phone;
	}
	
	@Override
	public boolean equals(Object o) {
	    if (o == null) return false;
	    if (o == this) return true;
	    Person person = (Person)o;
	    if(age == person.getAge() && email.equals(person.getEmail()) && phone.equals(person.getPhone()) && 
	       firstName.equals(person.getFirstName()) && lastName.equals(person.getLastName())) {
	    	return true;
	    }
	    else {
	    	return false;
	    }
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
