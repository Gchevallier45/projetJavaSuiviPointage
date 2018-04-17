package guillaume.projet.java.company;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import guillaume.projet.java.time.WorkingDay;

public class CompanyTest {
	Company testCompany;
	
    @Before
    public void setUp() throws Exception {
    	testCompany = new Company("testcompany");
    }

    @Test
    public void testAddAndRemoveDepartment() {
    	try {
        	Department testDepartment = new Department("testdepartment");
        	testCompany.addDepartment(testDepartment);
        	assertEquals("Add department problem",testCompany.getDepartments().size(),1);
        	testCompany.removeDepartment(testDepartment);
        	assertEquals("Remove department problem",testCompany.getDepartments().size(),0);
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
	    	testCompany.addEmployee(testEmployee, testDepartment);
	    	assertEquals("Add employee problem",testCompany.getEmployees().size(),1);
	    	assertEquals("Add department in employee problem",testEmployee.getDepartment().getName(),"testdepartment");
	    	assertEquals("Add employee in department problem",testDepartment.containsEmployee(testEmployee),true);
	    	testCompany.removeEmployee(testEmployee);
	    	assertEquals("Remove employee problem",testCompany.getEmployees().size(),0);
	    	assertEquals("Remove department in employee problem",testEmployee.getDepartment(),null);
	    	assertEquals("Remove employee from department problem",testDepartment.containsEmployee(testEmployee),false);
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
	    	testCompany.addEmployee(testEmployee, testDepartment);
	    	assertEquals("Add employee in department problem",testDepartment.containsEmployee(testEmployee),true);
	    	assertEquals("Employee should not be here",testDepartment2.containsEmployee(testEmployee),false);
	    	assertEquals("Add department in employee problem",testEmployee.getDepartment().getName(),"testdepartment");
	    	testCompany.moveEmployee(testEmployee, testDepartment2);
	    	assertEquals("Employee should not be here anymore",testDepartment.containsEmployee(testEmployee),false);
	    	assertEquals("Add employee in department problem",testDepartment2.containsEmployee(testEmployee),true);
	    	assertEquals("Add department in employee problem",testEmployee.getDepartment().getName(),"testdepartmenttwo");
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
	    	testCompany.addManager(testManager, testDepartment);
	    	assertEquals("Add manager problem",testCompany.getEmployees().size(),1);
	    	assertEquals("Add manager problem",testCompany.getManagers().size(),1);
	    	assertEquals("Add department in employee problem",testManager.getDepartment(),testDepartment);
	    	assertEquals("Add manager to department problem",testDepartment.getManager(),testManager);
	    	testCompany.removeManager(testManager);
	    	assertEquals("Remove manager problem",testCompany.getEmployees().size(),0);
	    	assertEquals("Remove manager problem",testCompany.getManagers().size(),0);
	    	assertEquals("Remove department in employee problem",testManager.getDepartment(),null);
	    	assertEquals("Remove manager from department problem",testDepartment.getManager(),null);
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }

}
