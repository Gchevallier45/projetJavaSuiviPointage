package guillaume.projet.java.company;

import java.util.ArrayList;

public class Company {

	private String companyName;
	private ArrayList<Department> departmentArray;
	private ArrayList<Employee> employeeArray;
	private ArrayList<Manager> managerArray;

	public Company(String companyName) {
		this.companyName = companyName;
		departmentArray = new ArrayList<Department>();
		employeeArray = new ArrayList<Employee>();
		managerArray = new ArrayList<Manager>();
	}
	
	public String toString() {
		String companyString;
		companyString = "Printing company " + companyName + "\n";
		for(Department d : departmentArray) {
			companyString += "  | " + d.toString();
		}
		return companyString;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public ArrayList<Employee> getEmployees() {
		return employeeArray;
	}

	public ArrayList<Department> getDepartments() {
		return departmentArray;
	}
	
	public ArrayList<Manager> getManagers() {
		return managerArray;
	}
	
	/**
	 * Adds a manager to the company and affect it to a department
	 * @param manager the manager to add
	 */
	public void addManager(Manager manager, Department department) throws Exception {
		boolean managerFound = false;
		for(Department d:departmentArray) {
			if(d.getManager() != null) {
				if(d.getManager().getId() == manager.getId()) {
					managerFound = true;
				}
			}
		}
		if(managerFound) {
			throw new RuntimeException("Manager found in another department. A manager can't manage supervise multiple departments");
		}
		else {
			if(!managerArray.contains(manager)) {
				managerArray.add(manager);
				if(!employeeArray.contains(manager)) {
					addEmployee(manager,department);
				}
			}
			department.setManager(manager);
		}
	}
	
	/**
	 * Remove a manager from the company
	 * @param manager the manager to remove
	 * @throws Exception 
	 */
	public void removeManager(Manager manager) throws Exception {
		if(managerArray.contains(manager)) {
			if(manager.getDepartment()!=null) {
				manager.getDepartment().setManager(null);
			}
			managerArray.remove(manager);
			removeEmployee(manager);
		}
		else {
			throw new RuntimeException("Manager is not in the company");
		}
	}

	/**
	 * Adds an employee to the company and affect it to a department
	 * @param employee the employee to add
	 * @param department the department of the future employee
	 * @throws Exception
	 */
	public void addEmployee(Employee employee,Department department) throws Exception {
		if(!employeeArray.contains(employee)) {
			if(departmentArray.contains(department)) {
				employee.setDepartment(department);
				employeeArray.add(employee);
				department.addEmployee(employee);
			}
			else {
				throw new RuntimeException("This department already exists");
			}
		}
		else {
			throw new RuntimeException("Employee is already in the company");
		}
	}

	/**
	 * Remove an employee from the company
	 * @param employee the employee to delete
	 * @throws Exception
	 */
	public void removeEmployee(Employee employee) throws Exception {
		if(employeeArray.contains(employee)) {
			employee.getDepartment().removeEmployee(employee);
			employee.setDepartment(null);
			employeeArray.remove(employee);
		}
		else {
			throw new RuntimeException("Employee is not in the company");
		}
	}
	
	/**
	 * Move an employee from a department to another
	 * @param employeeToMove
	 * @param newDepartment
	 */
	public void moveEmployee(Employee employeeToMove, Department newDepartment) {
		try {
		if(employeeToMove.getDepartment()!=null) {
			employeeToMove.getDepartment().removeEmployee(employeeToMove);
		}
		employeeToMove.setDepartment(newDepartment);
		newDepartment.addEmployee(employeeToMove);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Adds a department to the company
	 * @param department the department to add
	 */
	public void addDepartment(Department department) throws Exception {
		if(!departmentArray.contains(department)) {
			departmentArray.add(department);
		}
		else {
			throw new RuntimeException("This department already exists");
		}
	}

	/**
	 * Remove an entire department from the company<br/>
	 * !!! Also deletes the employees linked to the department !!!
	 * @param department the department to delete
	 */
	public void removeDepartment(Department department) throws Exception {
		if(departmentArray.contains(department)) {
			for(Employee e:employeeArray) {
				if(department.equals(e.getDepartment())) {
					department.removeEmployee(e);
					employeeArray.remove(e);
				}
			}
			departmentArray.remove(department);
		}
		else {
			throw new RuntimeException("This department already exists");
		}
	}
	
	/**
	 * Returns a Employee object from a given id
	 * @param idEmployee the id to search in the list of employees
	 * @return the employee object corresponding to the id if it's found, null otherwise
	 */
	public Employee getEmployeeById(int idEmployee) {
		for(Employee e : employeeArray) {
			if(e.getId() == idEmployee) {
				return e;
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
		for(Department d : departmentArray) {
			if(departmentName.equals(d.getName())) {
				return d;
			}
		}
		return null;
	}
}
