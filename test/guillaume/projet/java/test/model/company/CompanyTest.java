/**
 * CompanyTest.java
 * Various tests for the Company class
 * @author Guillaume CHEVALLIER
 */

package guillaume.projet.java.test.model.company;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import guillaume.projet.java.model.company.Company;
import guillaume.projet.java.model.company.Department;
import guillaume.projet.java.model.company.Employee;
import guillaume.projet.java.model.company.Manager;
import guillaume.projet.java.model.time.WorkingDay;

public class CompanyTest {
	Company testCompany;
	
    @Before
    public void setUp(){
    	testCompany = new Company("testcompany");
    }

    @Test
    public void testAddAndRemoveDepartment() {
    	try {
    		Manager testManager = new Manager("testm","testm","0123456789",42,"test@test.fr",new WorkingDay(LocalTime.of(8,15),LocalTime.of(18,15)));
    		Employee testEmployee = new Employee("test","test","0123456789",42,"test@test.fr",new WorkingDay(LocalTime.of(8,15),LocalTime.of(18,15)));
    		Department testDepartment = new Department("testdepartment");
        	testCompany.addDepartment(testDepartment);
	    	testCompany.addMember(testEmployee, testDepartment);  
	    	testCompany.addMember(testManager, testDepartment);
	    	assertEquals("Add employee problem",1,testCompany.getEmployees().size());
	    	assertEquals("Add employee problem",1,testDepartment.getEmployees().size());
	    	assertEquals("Add manager problem",1,testCompany.getManagers().size());
	    	assertEquals("Add manager problem",1,testDepartment.getPotentialManagers().size());
        	assertEquals("Add department problem",1,testCompany.getDepartments().size());
        	testCompany.removeDepartment(testDepartment);
	    	assertEquals("Remove employee problem",0,testCompany.getEmployees().size());
	    	assertEquals("Remove employee problem",0,testDepartment.getEmployees().size());
	    	assertEquals("Remove manager problem",0,testCompany.getManagers().size());
	    	assertEquals("Remove manager problem",0,testDepartment.getPotentialManagers().size());
        	assertEquals("Remove department problem",0,testCompany.getDepartments().size());
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
    }
    
    @Test
    public void testAddAndRemoveEmployee(){
    	try {
			Employee testEmployee = new Employee("test","test","0123456789",42,"test@test.fr",new WorkingDay(LocalTime.of(8,15),LocalTime.of(18,15)));
	    	Department testDepartment = new Department("testdepartment");
	    	testCompany.addDepartment(testDepartment);
	    	testCompany.addMember(testEmployee, testDepartment);
	    	assertEquals("Add employee problem",testCompany.getEmployees().size(),1);
	    	assertEquals("Add department in employee problem","testdepartment",testEmployee.getDepartment().getName());
	    	assertEquals("Add employee in department problem",1,testDepartment.getEmployees().size());
	    	testCompany.removeMember(testEmployee);
	    	assertEquals("Remove employee problem",0,testCompany.getEmployees().size());
	    	assertEquals("Remove department in employee problem",null,testEmployee.getDepartment());
	    	assertEquals("Remove employee from department problem",0,testDepartment.getEmployees().size());
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Test
    public void testMoveEmployee() {
    	try {
			Employee testEmployee = new Employee("test","test","0123456789",42,"test@test.fr",new WorkingDay(LocalTime.of(8,15),LocalTime.of(18,15)));
	    	Department testDepartment = new Department("testdepartment");
	    	Department testDepartment2 = new Department("testdepartmenttwo");
	    	testCompany.addDepartment(testDepartment);
	    	testCompany.addDepartment(testDepartment2);
	    	testCompany.addMember(testEmployee, testDepartment);
	    	assertEquals("Add employee in department problem",true,testDepartment.getEmployees().contains(testEmployee));
	    	assertEquals("Employee should not be here",false,testDepartment2.getEmployees().contains(testEmployee));
	    	assertEquals("Add department in employee problem","testdepartment",testEmployee.getDepartment().getName());
	    	testCompany.moveMember(testEmployee, testDepartment2);
	    	assertEquals("Employee should not be here anymore",false,testDepartment.getEmployees().contains(testEmployee));
	    	assertEquals("Add employee in department problem",true,testDepartment2.getEmployees().contains(testEmployee));
	    	assertEquals("Add department in employee problem","testdepartmenttwo",testEmployee.getDepartment().getName());
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}   	
    }
    
    @Test
    public void testAddAndRemoveManager(){
    	try {
			Manager testManager = new Manager("testm","testm","0123456789",42,"test@test.fr",new WorkingDay(LocalTime.of(8,15),LocalTime.of(18,15)));
	    	Department testDepartment = new Department("testdepartment");;
	    	testCompany.addDepartment(testDepartment);
	    	testCompany.addMember(testManager, testDepartment);
	    	testDepartment.setManager(testManager);
	    	assertEquals("Add manager problem",1,testCompany.getManagers().size());
	    	assertEquals("Add department in employee problem",testDepartment,testManager.getDepartment());
	    	assertEquals("Add manager to department problem",testManager,testDepartment.getManager());
	    	testCompany.removeMember(testManager);
	    	assertEquals("Remove manager problem",0,testCompany.getManagers().size());
	    	assertEquals("Remove department in employee problem",null,testManager.getDepartment());
	    	assertEquals("Remove manager from department problem",null,testDepartment.getManager());
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Test
    public void testMoveManager() {
    	try {
    		Manager testManager = new Manager("testm","testm","0123456789",42,"test@test.fr",new WorkingDay(LocalTime.of(8,15),LocalTime.of(18,15)));
   	    	Department testDepartment = new Department("testdepartment");
	    	Department testDepartment2 = new Department("testdepartmenttwo");
	    	testCompany.addDepartment(testDepartment);
	    	testCompany.addDepartment(testDepartment2);
	    	testCompany.addMember(testManager, testDepartment);
	    	testDepartment.setManager(testManager);
	    	assertEquals("Add manager problem",1,testCompany.getManagers().size());
	    	assertEquals("Add department in manager problem",testDepartment,testManager.getDepartment());
	    	assertEquals("Add departmentManaged in manager problem",testDepartment,testManager.getDepartmentManaged());
	    	assertEquals("Add manager to department problem",testManager,testDepartment.getManager());
	    	testCompany.moveMember(testManager, testDepartment2);
	    	testDepartment2.setManager(testManager);
	    	assertEquals("Move manager problem",1,testCompany.getManagers().size());
	    	assertEquals("Add department in manager problem",testDepartment2,testManager.getDepartment());
	    	assertEquals("Add departmentManaged in manager problem",testDepartment2,testManager.getDepartmentManaged());
	    	assertEquals("Manager not in new department",testManager,testDepartment2.getManager());
	    	assertEquals("Manager still in the old department",null,testDepartment.getManager());
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}  
    }
}
