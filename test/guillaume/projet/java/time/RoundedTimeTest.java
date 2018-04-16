package guillaume.projet.java.time;

import guillaume.projet.java.time.RoundedTime;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class RoundedTimeTest {
	LocalDateTime testDateTime;
	RoundedTime roundedTime;
	
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testRawTime(){
    	testDateTime = LocalDateTime.of(2018, 4, 16, 15, 51);
    	roundedTime = new RoundedTime(testDateTime);
    	assertEquals(roundedTime.getRawTime(),LocalDateTime.of(2018, 4, 16, 15, 51));
    }

    @Test
    public void testRoundedTimeBackward(){
    	testDateTime = LocalDateTime.of(2018, 4, 16, 15, 51);
    	roundedTime = new RoundedTime(testDateTime);
    	assertEquals(roundedTime.getRoundedTime(),LocalDateTime.of(2018, 4, 16, 15, 45));
    }
    
    @Test
    public void testRoundedTimeForward(){
    	testDateTime = LocalDateTime.of(2018, 4, 16, 15, 58);
    	roundedTime = new RoundedTime(testDateTime);
    	assertEquals(roundedTime.getRoundedTime(),LocalDateTime.of(2018, 4, 16, 16, 00));
    }
}

