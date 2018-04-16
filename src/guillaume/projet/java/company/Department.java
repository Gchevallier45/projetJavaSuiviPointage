/*
 * Department.java
 * Manages departments of the company
 */

package guillaume.projet.java.company;

import java.util.ArrayList;

public class Department {

	private String departmentName;
	private Manager manager;
	
	public Department(String departmentName, Manager manager) {
		this.departmentName = departmentName;
		this.manager = manager;
	}
	
	@Override
	public boolean equals(Object o) {
	    if (o == null) return false;
	    if (o == this) return true;
	    Department department = (Department)o;
	    if(departmentName.equals(department.getDepartmentName())) {
	    	return true;
	    }
	    else {
	    	return false;
	    }
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	public Manager getManager() {
		return manager;
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
	}

	public void addEmployee(Employee employee) {
		if(employees.contains(employee) == true) {
			throw new RuntimeException("Employé n°" + employee.getId() + " déjà ajouté");
		}
		else {
			employees.add(employee);
		}
	}

	public void deleteEmployee(int idEmployee) {
		Employee toRemove = getEmployee(idEmployee);
		
		if(toRemove == null) {
			throw new RuntimeException("Employé n°" + idEmployee + " non trouvé");
		}
		else {
			employees.remove(toRemove);
		}
	}*/	

}
