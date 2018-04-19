/**
 * TimeTest.java
 * Various tests for the Time class
 * @author Guillaume CHEVALLIER
 */

package guillaume.projet.java.test.model.time;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import guillaume.projet.java.model.time.Time;

public class TimeTest {
	LocalTime testTime;
	
    @Before
    public void setUp(){
    }

    @Test
    public void testRoundedTimeBackward_Return1545(){
    	testTime = LocalTime.of(15, 51);
    	assertEquals("Rounded time backward problem",LocalTime.of(15, 45),Time.getRoundedTime(testTime));
    }
    
    @Test
    public void testRoundedTimeForward_Return1600(){
    	testTime = LocalTime.of(15, 55);
    	assertEquals("Rounded time forward problem",LocalTime.of(16, 00),Time.getRoundedTime(testTime));
    }
    
    @Test
    public void testTimeDifference_Return0005() {
    	testTime = LocalTime.of(15, 55);
    	assertEquals("Time difference problem",LocalTime.of(0, 5),Time.substractTimes(testTime,LocalTime.of(16, 00)));
    }
}

