/**
 * Department.java
 * Implements departments structure of the company
 * @author Guillaume CHEVALLIER
 */

package guillaume.projet.java.model.company;

import java.util.ArrayList;

public class Department {

	private String departmentName;
	private Manager manager;
	private ArrayList<Employee> employees;
	private ArrayList<Manager> potentialManagers;
	
	/**
	 * Creates a new department
	 * @param departmentName the name of the department
	 */
	public Department(String departmentName) {
		this.departmentName = departmentName;
		employees = new ArrayList<Employee>();
		potentialManagers = new ArrayList<Manager>();
	}
	
	/**
	 * Returns a string representing the department
	 */
	@Override
	public String toString() {
		String departmentString = "Department : " + departmentName;
		if(manager != null)
			departmentString += ", manager : " + manager.getFirstName() + " " + manager.getLastName();
		departmentString += "\n";
		for(Employee e:employees) {
			departmentString += "    | " + e.toString();
		}
		for(Manager m:potentialManagers) {
			departmentString += "    | " + m.toString();
		}
		departmentString += "\n";
		return departmentString;
	}
	
	/**
	 * Override equals() method to add member by member comparison
	 */
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

	/**
	 * Gets the name of the department
	 * @return the department name
	 */
	public String getName() {
		return departmentName;
	}

	/**
	 * Sets the name of the department
	 * @param departmentName the department name to set
	 */
	public void setName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	/**
	 * Gets the manager of the department
	 * @return the manager of the department
	 */
	public Manager getManager() {
		return manager;
	}
	
	/**
	 * Sets the manager of the department
	 * @param manager the future manager of the department
	 * @throws Exception
	 */
	public void setManager(Manager manager) throws Exception {
		if(manager == null) {
			if(this.manager != null)
				this.manager.setDepartmentManaged(null);
			this.manager = null;
		}
		else if(potentialManagers.contains(manager)){
			if(this.manager != null)
				this.manager.setDepartmentManaged(null);
			manager.setDepartmentManaged(this);
			this.manager = manager;
		}
		else {
			throw new RuntimeException("Manager has to be in the department in order to manage it");
		}
	}
	
	/**
	 * Add an employee to the department <br/>
	 * !!! SHOULD NEVER BE CALLED OUTSIDE Company methods or will cause data integrity issues !!!
	 * @param employee the employee to add
	 * @throws Exception
	 */
	public void add(Employee employee) throws Exception {
		if(!employees.contains(employee)) {
			employee.setDepartment(this);
			employees.add(employee);
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
	public void remove(Employee employee) throws Exception{
		if(employees.contains(employee)) {
			employees.remove(employee);
			employee.setDepartment(null);
		}
		else {
			throw new RuntimeException("Employee is not in this department");
		}
	}
	
	/**
	 * Add a potential manager to the department <br/>
	 * !!! SHOULD NEVER BE CALLED OUTSIDE Company methods or will cause data integrity issues !!!
	 * @param manager the potential manager to add
	 * @throws Exception
	 */
	public void add(Manager manager) throws Exception {
		if(!potentialManagers.contains(manager)) {
			manager.setDepartment(this);
			potentialManagers.add(manager);
		}
		else {
			throw new RuntimeException("Manager is already in this department");
		}
	}
	
	/**
	 * Remove a potential manager from the department
	 * !!! SHOULD NEVER BE CALLED OUTSIDE Company methods or will cause data integrity issues !!!
	 * @param manager the potential manager to remove
	 * @throws Exception
	 */
	public void remove(Manager manager) throws Exception{
		if(potentialManagers.contains(manager)) {
			if(manager.equals(this.manager)) { //If the manager to remove is the actual manager of the department, the current manager of the department is set to null
				this.manager = null;
				manager.setDepartmentManaged(null);
			}
			potentialManagers.remove(manager);
			manager.setDepartment(null);
		}
		else {
			throw new RuntimeException("Manager is not in this department");
		}
	}
	
	/**
	 * Gets the employees of the department
	 * @return a copy of the list containing the employees of the department
	 */
	public ArrayList<Employee> getEmployees() {
		return new ArrayList<Employee>(employees);
	}
	
	/**
	 * Gets the potential managers of the department
	 * @return a copy of the list containing the potential managers of the department
	 */
	public ArrayList<Manager> getPotentialManagers() {
		return new ArrayList<Manager>(potentialManagers);
	}

}
