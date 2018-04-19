/**
 * Employee.java
 * Implements, manage and store employees
 * @author Guillaume CHEVALLIER
 */

package guillaume.projet.java.model.company;

import java.time.LocalDate;
import java.util.ArrayList;

import guillaume.projet.java.model.time.Check;
import guillaume.projet.java.model.time.Time;
import guillaume.projet.java.model.time.WorkingDay;

public class Employee {

	private static int count = 0;
	private int idEmployee = 0;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private int age;
	private int supMinutes;
	private Department department;
	private ArrayList<Check> checksHistory;
	private WorkingDay workingDay;
	
	/**
	 * Creates a new employee
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param phone the phone number
	 * @param age the age
	 * @param email the email
	 * @param workingDay the working hours of the employee
	 */
	public Employee(String firstName, String lastName, String phone, int age, String email, WorkingDay workingDay) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
		this.phone = phone;
		this.workingDay = workingDay;
		supMinutes = 0;
		checksHistory = new ArrayList<Check>();
		idEmployee = count++;
	}
	
	/**
	 * Returns a string representing the employee
	 */
	@Override
	public String toString() {
		String employeeString;
		employeeString = "Member " + this.idEmployee + " : " + this.firstName + " " + this.lastName + " - Details : " + this.age + ", " + this.email + ", " +  this.phone + ", " +  this.workingDay.toString() + "\n";
		return employeeString;
	}
	
	/**
	 * Override equals() method to add member by member comparison
	 */
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
	
	/**
	 * Gets the first name of the employee
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name of the employee
	 * @param firstName the first name to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name of the employee
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name of the employee
	 * @param lastName the last name to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the age of the employee
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age of the employee
	 * @param firstName the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Gets the email of the employee
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email of the employee
	 * @param firstName the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the phone number of the employee
	 * @return the phone number
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the first name of the employee
	 * @param firstName the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * Gets the department of the employee
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}
	
	/**
	 * Set employee department
	 * !!! SHOULD NEVER BE CALLED OUTSIDE Department methods or will cause data integrity issues !!!
	 * @param Department the new department of the employee
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * Gets the checks history
	 * @return the list containing all the checks history (returns the real list, not a copy)
	 */
	public ArrayList<Check> getChecksHistory() {
		return checksHistory;
	}
	
	/**
	 * Gets the id of the employee
	 * @return the id of the employee
	 */
	public int getId() {
		return idEmployee;
	}
	
	/**
	 * Gets the working hours of the employee
	 * @return the workingDay object containing the working hours
	 */
	public WorkingDay getWorkingDay() {
		return workingDay;
	}

	/**
	 * Sets the working hours of the employee
	 * @param workingDay the workingDay to set
	 */
	public void setWorkingDay(WorkingDay workingDay) {
		this.workingDay = workingDay;
	}

	/**
	 * Gets the minutes count of the employee
	 * @return the minutes count of the employee
	 */
	public int getSupMinutes() {
		return supMinutes;
	}
	
	/**
	 * Performs a check and add the check in the check history, also computes the minutes count
	 * @throws Exception
	 */
	public void check() throws Exception {
		if(checksHistory.isEmpty() || !checksHistory.get(checksHistory.size()-1).getDate().equals(LocalDate.now())) {
			checksHistory.add(new Check());
		}

		checksHistory.get(checksHistory.size()-1).processCheck();
		if(checksHistory.get(checksHistory.size()-1).getOutCheck() != null) { //If the employees check for the second time, supMinutes counter is updated
			Check dayCheck = checksHistory.get(checksHistory.size()-1);
			supMinutes += (Time.substractTimes(dayCheck.getInCheck(), dayCheck.getOutCheck()).toSecondOfDay() - Time.substractTimes(workingDay.getInTime(), workingDay.getOutTime()).toSecondOfDay()) / 60;
		}
	}

}

