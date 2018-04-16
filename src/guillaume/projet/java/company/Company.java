package guillaume.projet.java.company;

import java.util.ArrayList;
import guillaume.projet.java.time.Check;

public class Company {

	private String companyName;
	private Person boss;
	private ArrayList<Department> departmentArray;
	private ArrayList<Employee> employeeArray;	

	public Company(String companyName, Person boss) {
		this.companyName = companyName;
		this.boss = boss;
		departmentArray = new ArrayList<Department>();
		employeeArray = new ArrayList<Employee>();
	}
	
	public Company() {
		departmentArray = new ArrayList<Department>();
		employeeArray = new ArrayList<Employee>();
	}

	public void stubFunction() {
		try {
			Check check = new Check();
			check.check();
			check.check();
			System.out.println(check.getOutCheck().getRoundedTime());
			Employee e = new Employee("jean","bon","0123456789",42,"jeanbon@beurre.fr");
			Employee er = new Employee("jean","ninja","0123458789",42,"jeanninja@beurre.fr");
			Employee ere = new Employee("jean","bon","0123456789",42,"jeanbon@beurre.fr");
			addEmployee(e);
			addEmployee(ere);
			System.out.println(e.getId());
			System.out.println(er.getId());
			System.out.println(e.getLastName());
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Person getBoss() {
		return boss;
	}
	
	public void setBoss(Person boss) {
		this.boss = boss;
	}

	public ArrayList<Employee> getEmployees() {
		return employeeArray;
	}

	public ArrayList<Department> getDepartments() {
		return departmentArray;
	}

	public void addEmployee(Employee employee) throws Exception {
		if(!employeeArray.contains(employee)) {
			employeeArray.add(employee);
		}
		else {
			throw new RuntimeException("L'employé est déjà dans l'entreprise");
		}
	}

	public void deleteEmployee(Employee employee) throws Exception {
		if(employeeArray.contains(employee)) {
			employeeArray.remove(employee);
		}
		else {
			throw new RuntimeException("L'employé n'est pas dans l'entreprise");
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
			throw new RuntimeException("Ce département existe déjà dans l'entreprise");
		}
	}

	/**
	 * Deletes an entire department <br/>
	 * !!! Also deletes the employees linked to the department !!!
	 * @param department the department to delete
	 */
	public void deleteDepartment(Department department) throws Exception {
		if(departmentArray.contains(department)) {
			for(Employee e:employeeArray) {
				if(department.equals(e.getDepartment())) {
					employeeArray.remove(e);
				}
			}
			departmentArray.remove(department);
		}
		else {
			throw new RuntimeException("Ce département n'existe pas dans l'entreprise");
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
			if(departmentName.equals(d.getDepartmentName())) {
				return d;
			}
		}
		return null;
	}

}
