/**
 * CheckTest.java
 * Various tests for the Check class
 * @author Guillaume CHEVALLIER
 */

package guillaume.projet.java.test.model.time;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import guillaume.projet.java.model.time.Check;
import guillaume.projet.java.model.time.Time;

public class CheckTest {
	Check testCheck;
	
    @Before
    public void setUp(){
    	testCheck = new Check();
    }

    @Test
    public void testCheck(){
    	try {
			testCheck.processCheck();
			assertEquals("incheck fail",Time.getRoundedTime(LocalTime.now()),testCheck.getInCheck());
			assertEquals("outcheck should be null",null,testCheck.getOutCheck());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @Test
    public void testDoubleCheck(){
    	try {
			testCheck.processCheck();
			testCheck.processCheck();
			assertEquals("incheck fail",Time.getRoundedTime(LocalTime.now()),testCheck.getInCheck());
			assertEquals("outcheck fail",Time.getRoundedTime(LocalTime.now()),testCheck.getOutCheck());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }	
}
