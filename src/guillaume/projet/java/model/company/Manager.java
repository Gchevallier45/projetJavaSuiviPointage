/**
 * Manager.java
 * Implements managers structure
 * @author Guillaume CHEVALLIER
 */

package guillaume.projet.java.model.company;

import guillaume.projet.java.model.company.Employee;
import guillaume.projet.java.model.time.WorkingDay;

public class Manager extends Employee {
	private Department departmentManaged;
	
	/**
	 * Creates a new manager
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param phone the phone number
	 * @param age the age
	 * @param email the email
	 * @param workingDay the working hours of the manager
	 */
	public Manager(String firstName, String lastName, String phone, int age, String email, WorkingDay workingDay) {
		super(firstName,lastName,phone,age,email,workingDay);
	}
	
	/**
	 * Creates a manager from an employee
	 * @param e the employee
	 */
	public Manager(Employee e) {
		super(e.getFirstName(),e.getLastName(),e.getPhone(),e.getAge(),e.getEmail(),e.getWorkingDay());
	}
	
	/**
	 * Gets the department managed by the manager
	 * @return the department managed by the manager
	 */
	public Department getDepartmentManaged() {
		return departmentManaged;
	}
	
	/**
	 * Sets the department managed by the manager
	 * !!! SHOULD NEVER BE CALLED OUTSIDE Department methods or will cause data integrity issues !!!
	 * @param departmentManaged the department to be managed by the manager
	 */
	public void setDepartmentManaged(Department departmentManaged) {
		this.departmentManaged = departmentManaged;
	}
}
