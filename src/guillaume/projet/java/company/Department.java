/*
 * Department.java
 * Manages departments of the company
 */

package guillaume.projet.java.company;

import java.util.ArrayList;

public class Department {

	private String departmentName;
	private Manager manager;
	private ArrayList<Employee> employeeArray;
	
	public Department(String departmentName) {
		this.departmentName = departmentName;
		employeeArray = new ArrayList<Employee>();
	}
	
	public String toString() {
		String departmentString;
		departmentString = "Department : " + departmentName + "\n";
		for(Employee e:employeeArray) {
			departmentString += "    | " + e.toString();
		}
		departmentString += "\n";
		return departmentString;
	}
	
	@Override
	public boolean equals(Object o) {
	    if (o == null) return false;
	    if (o == this) return true;
	    Department department = (Department)o;
	    if(departmentName.equals(department.getName())) {
	    	return true;
	    }
	    else {
	    	return false;
	    }
	}

	public String getName() {
		return departmentName;
	}

	public void setName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	public Manager getManager() {
		return manager;
	}
	
	/**
	 * Check if an employee is already present in the department
	 * @param e the employee to test
	 * @return true if the employee is found, false otherwise
	 */
	public boolean containsEmployee(Employee e) {
		if(employeeArray.contains(e)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Add an employee to the department <br/>
	 * !!! SHOULD NEVER BE CALLED OUTSIDE Company methods or will cause data integrity issues !!!
	 * @param employee the employee to add
	 * @throws Exception
	 */
	public void addEmployee(Employee employee) throws Exception {
		if(!employeeArray.contains(employee)) {
			employeeArray.add(employee);
		}
		else {
			throw new RuntimeException("Employee is already in this department");
		}
	}
	
	/**
	 * Remove an employee from the department
	 * !!! SHOULD NEVER BE CALLED OUTSIDE Company methods or will cause data integrity issues !!!
	 * @param employee the employee to remove
	 * @throws Exception
	 */
	public void removeEmployee(Employee employee) throws Exception{
		if(employeeArray.contains(employee)) {
			employeeArray.remove(employee);
		}
		else {
			throw new RuntimeException("Employee is not in this department");
		}		
	}
	
	/*public Employee getEmployee(int idEmployee) {
		Employee toReturn = null;
		for(Employee e :employees) {
			if(e.getId() == idEmployee) {
				toReturn = e;
				break;
			}
		}
		return toReturn;
	}*/

}
