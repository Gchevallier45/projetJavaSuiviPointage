/*
 * Employee.java
 * Manages things related to employees
 */

package guillaume.projet.java.company;

import java.util.ArrayList;

import guillaume.projet.java.time.Check;
import guillaume.projet.java.time.WorkingDay;

public class Employee {

	private static int count = 0;
	private int idEmployee = 0;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private int age;
	private Department department;
	private ArrayList<Check> checks;
	private WorkingDay workingDay;
	
	public Employee(String firstName, String lastName, String phone, int age, String email, WorkingDay workingDay) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
		this.phone = phone;
		this.workingDay = workingDay;
		checks = new ArrayList<Check>();
		idEmployee = count++;
	}
	
	public String toString() {
		String employeeString;
		employeeString = "Employee " + this.idEmployee + " : " + this.firstName + " " + this.lastName + " - Details : " + this.age + ", " + this.email + ", " +  this.phone + ", " +  this.workingDay.toString() + "\n";
		return employeeString;
	}
	
	@Override
	public boolean equals(Object o) {
	    if (o == null) return false;
	    if (o == this) return true;
	    Employee employee = (Employee)o;
	    if(age == employee.getAge() && email.equals(employee.getEmail()) && phone.equals(employee.getPhone()) && 
	       firstName.equals(employee.getFirstName()) && lastName.equals(employee.getLastName())) {
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
	
	public Department getDepartment() {
		return department;
	}

	/**
	 * Set employee department
	 * !!! SHOULD NEVER BE CALLED OUTSIDE Company methods or will cause data integrity issues !!!
	 * @param Department the new department of the employee
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	public ArrayList<Check> getChecks() {
		return null;
	}

	public void addCheck(Check check) {

	}
	
	public int getId() {
		return idEmployee;
	}
	
	/**
	 * @return the workingDay
	 */
	public WorkingDay getWorkingDay() {
		return workingDay;
	}

	/**
	 * @param workingDay the workingDay to set
	 */
	public void setWorkingDay(WorkingDay workingDay) {
		this.workingDay = workingDay;
	}

}

