package guillaume.projet.java.company;

import guillaume.projet.java.company.Employee;
import guillaume.projet.java.time.WorkingDay;

public class Manager extends Employee {
	public Manager(String firstName, String lastName, String phone, int age, String email, WorkingDay workingDay) {
		super(firstName,lastName,phone,age,email,workingDay);
	}
	
	public Manager(Employee e) {
		super(e.getFirstName(),e.getLastName(),e.getPhone(),e.getAge(),e.getEmail(),e.getWorkingDay());
	}
}
