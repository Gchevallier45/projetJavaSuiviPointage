package guillaume.projet.java.time;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TimeTest {
	LocalTime testTime;
	
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testRoundedTimeBackward(){
    	testTime = LocalTime.of(15, 51);
    	assertEquals("Rounded time backward problem",Time.getRoundedTime(testTime),LocalTime.of(15, 45));
    }
    
    @Test
    public void testRoundedTimeForward(){
    	testTime = LocalTime.of(15, 55);
    	assertEquals("Rounded time forward problem",Time.getRoundedTime(testTime),LocalTime.of(16, 00));
    }
    
    @Test
    public void testTimeDifference() {
    	testTime = LocalTime.of(15, 55);
    	assertEquals("Time difference problem",Time.substractTimes(testTime,LocalTime.of(16, 00)),LocalTime.of(0, 5));
    }
}

