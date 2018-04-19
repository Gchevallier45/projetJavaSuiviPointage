/**
 * Time.java
 * Contains static methods to do computation between times,
 * @author Guillaume CHEVALLIER
 */

package guillaume.projet.java.model.time;

import java.time.Duration;
import java.time.LocalTime;

public class Time{	
	/**
	 * Static method that generates rounded time from a given LocalTime object
	 * @param rawTime raw check time
	 */
	public static LocalTime getRoundedTime(LocalTime rawTime) {
		LocalTime roundedTime = rawTime;
		
		long roundedSeconds = rawTime.toSecondOfDay();
		roundedTime = LocalTime.ofSecondOfDay(roundedSeconds%(15*60));
		if(roundedTime.getMinute()>7) {
			roundedTime = rawTime.plusSeconds(15*60-(roundedTime.getMinute()*60+roundedTime.getSecond()));
		}
		else {
			roundedTime = rawTime.minusSeconds(roundedTime.getMinute()*60+roundedTime.getSecond());
		}
		
		roundedTime = roundedTime.withNano(0);
		return roundedTime;
	}
	
	/**
	 * Static method that returns the time difference between two times
	 * @param time1 the first time
	 * @param time2 the second time (should be > first time)
	 * @return the difference between time2 and time1
	 */
	public static LocalTime substractTimes(LocalTime time1, LocalTime time2) {
		return LocalTime.ofSecondOfDay(Duration.between(time1, time2).getSeconds());
	}
}
