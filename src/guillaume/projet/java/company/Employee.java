/*
 * Employee.java
 * Manages things related to employees
 */

package guillaume.projet.java.company;

import java.util.ArrayList;

import guillaume.projet.java.time.Check;

public class Employee extends Person {

	private static int count = 0;
	private int idEmployee = 0;
	private Department department;

	public Employee(String firstName, String lastName, String phone, int age, String email) {
		super(firstName,lastName,phone,age,email);
		idEmployee = count++;
	}
	
	public Department getDepartment() {
		return department;
	}

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

}

