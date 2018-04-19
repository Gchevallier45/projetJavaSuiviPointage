/**
 * Company.java
 * Implements the company management, adds and removes of the departments and employees
 * @author Guillaume CHEVALLIER
 */

package guillaume.projet.java.model.company;

import java.util.ArrayList;

public class Company {

	private String companyName;
	private ArrayList<Department> departments;
	private ArrayList<Employee> employees;
	private ArrayList<Manager> managers;

	/**
	 * Creates a new company
	 * @param companyName the name of the company
	 */
	public Company(String companyName) {
		this.companyName = companyName;
		departments = new ArrayList<Department>();
		employees = new ArrayList<Employee>();
		managers = new ArrayList<Manager>();
	}
	
	/**
	 * Returns a string representing the company
	 */
	@Override
	public String toString() {
		String companyString;
		companyString = "Printing company " + companyName + "\n";
		for(Department d : departments) {
			companyString += "  | " + d.toString();
		}
		return companyString;
	}

	/**
	 * Gets the company name
	 * @return the company name
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * Change the company name
	 * @param companyName the name
	 */
	public void changeCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * Gets the employees of the company
	 * @return a copy of the list containing the employees of the company (to protect the original lists from being modified)
	 */
	public ArrayList<Employee> getEmployees() {
		return new ArrayList<Employee>(employees);
	}

	/**
	 * Gets the departments of the company
	 * @return a copy of the list containing the departments of the company (to protect the original lists from being modified)
	 */
	public ArrayList<Department> getDepartments() {
		return new ArrayList<Department>(departments);
	}
	
	/**
	 * Gets the managers of the company
	 * @return a copy of the list containing the managers of the company (to protect the original lists from being modified)
	 */
	public ArrayList<Manager> getManagers() {
		return new ArrayList<Manager>(managers);
	}

	/**
	 * Adds an employee to the company and affect it to a department
	 * @param employee the employee to add
	 * @param department the department of the future employee
	 * @throws Exception
	 */
	public void addMember(Employee employee,Department department) throws Exception {
		if(!employees.contains(employee)) {
			employees.add(employee);
			department.add(employee);
		}
		else {
			throw new RuntimeException("Employee is already in the company");
		}
	}
	
	/**
	 * Adds a manager to the company and affect it to a department
	 * @param manager the manager to add
	 * @param department the department of the future manager
	 * @throws Exception 
	 */
	public void addMember(Manager manager, Department department) throws Exception {
		if(!managers.contains(manager)) {
			managers.add(manager);
			department.add(manager);
		}
		else {
			throw new RuntimeException("Manager is already in the company");
		}
	}
	
	/**
	 * Removes an employee from the company
	 * @param employee the employee to delete
	 * @throws Exception
	 */
	public void removeMember(Employee employee) throws Exception {
		if(employees.contains(employee)) {
			employee.getDepartment().remove(employee);
			employees.remove(employee);
		}
		else {
			throw new RuntimeException("Employee is not in the company");
		}
	}
	
	/**
	 * Removes a manager from the company
	 * @param manager the manager to remove
	 * @throws Exception 
	 */
	public void removeMember(Manager manager) throws Exception {
		if(managers.contains(manager)) {
			manager.getDepartment().remove(manager);
			managers.remove(manager);
		}
		else {
			throw new RuntimeException("Manager is not in the company");
		}
	}
	
	/**
	 * Move an employee from a department to another
	 * @param employeeToMove the employee to move
	 * @param newDepartment the new department of the employee
 	 * @throws Exception 
	 */
	public void moveMember(Employee employeeToMove, Department newDepartment) throws Exception {
		employeeToMove.getDepartment().remove(employeeToMove);
		newDepartment.add(employeeToMove);
	}
	
	/**
	 * Move a manager from a department to another
	 * @param managerToMove the manager to move
	 * @param newDepartment the new department of the manager
	 * @throws Exception 
	 */
	public void moveMember(Manager managerToMove, Department newDepartment) throws Exception {
		managerToMove.getDepartment().remove(managerToMove);
		newDepartment.add(managerToMove);
	}

	/**
	 * Adds a department to the company
	 * @param department the department to add
	 * @throws Exception 
	 */
	public void addDepartment(Department department) throws Exception {
		if(!departments.contains(department)) {
			departments.add(department);
		}
		else {
			throw new RuntimeException("This department already exists");
		}
	}

	/**
	 * Removes an entire department from the company<br/>
	 * !!! Also deletes the employees and the managers of the department !!!
	 * @param department the department to delete
	 * @throws Exception 
	 */
	public void removeDepartment(Department department) throws Exception {
		for(Employee e: department.getEmployees()) {
			removeMember(e);
		}
		for(Manager m: department.getPotentialManagers()) {
			removeMember(m);
		}
		departments.remove(department);
	}
	
	/**
	 * Returns an Employee object from a given id
	 * @param idEmployee the id to search in the list of employees
	 * @return the employee object corresponding to the id if it's found, null otherwise
	 */
	public Employee getEmployeeById(int idEmployee) {
		for(Employee e : employees) {
			if(e.getId() == idEmployee) {
				return e;
			}
		}
		return null;
	}
	
	/**
	 * Returns a Manager object from a given id
	 * @param idManager the id to search in the list of employees
	 * @return the manager object corresponding to the id if it's found, null otherwise
	 */
	public Manager getManagerById(int idManager) {
		for(Manager m : managers) {
			if(m.getId() == idManager) {
				return m;
			}
		}
		return null;
	}
	
	/**
	 * Returns a Department object from a given department name
	 * @param departmentName the department name to search in the list of department
	 * @return the department object corresponding to the department name if it's found, null otherwise
	 */
	public Department getDepartmentByName(String departmentName) {
		for(Department d : departments) {
			if(departmentName.equals(d.getName())) {
				return d;
			}
		}
		return null;
	}
}
