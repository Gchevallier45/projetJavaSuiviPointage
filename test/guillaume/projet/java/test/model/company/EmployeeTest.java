/**
 * EmployeeTest.java
 * Various tests for the Employee class
 * @author Guillaume CHEVALLIER
 */

package guillaume.projet.java.test.model.company;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import guillaume.projet.java.model.company.Employee;
import guillaume.projet.java.model.time.Check;
import guillaume.projet.java.model.time.Time;
import guillaume.projet.java.model.time.WorkingDay;

public class EmployeeTest {
	Employee testEmployee;
	
	@Before
    public void setUp(){
		testEmployee = new Employee("test","test","0123456789",42,"test@test.fr",new WorkingDay(LocalTime.of(8,15),LocalTime.of(18,15)));
	}
    
    @Test
    public void testSupMinutes() {
    	try {
	    	Check testCheck = new Check();
	    	testCheck.setInCheck(LocalTime.of(0, 0));
	    	testEmployee.setWorkingDay(new WorkingDay(LocalTime.of(0, 0),LocalTime.of(0, 15)));
	    	testEmployee.getChecksHistory().add(testCheck);
			testEmployee.check();
	    	assertEquals("SupMinutes problem",(Time.getRoundedTime(LocalTime.now()).toSecondOfDay()/60)-(LocalTime.of(0, 15).toSecondOfDay()/60),testEmployee.getSupMinutes());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @Test
    public void testCheck_ReturnException(){
    	try {
	    	assertEquals("There should not be checks here",0,testEmployee.getChecksHistory().size());
			testEmployee.check();
			assertEquals("There should be checks here",1,testEmployee.getChecksHistory().size());
			assertEquals("There should be an intime",Time.getRoundedTime(LocalTime.now()),testEmployee.getChecksHistory().get(0).getInCheck());
			assertEquals("There should be no outtime",null,testEmployee.getChecksHistory().get(0).getOutCheck());
			testEmployee.check();
			assertEquals("There should be an outtime",Time.getRoundedTime(LocalTime.now()),testEmployee.getChecksHistory().get(0).getOutCheck());
			testEmployee.check(); //Should return an exception "Employee already checked 2 times"
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
	    
}
