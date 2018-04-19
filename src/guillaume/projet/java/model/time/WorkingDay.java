/**
 * WorkingDay.java
 * Implements the working hours
 * @author Guillaume CHEVALLIER
 */

package guillaume.projet.java.model.time;

import java.time.LocalTime;

public class WorkingDay {
	private LocalTime inTime;
	private LocalTime outTime;
	
	/**
	 * Creates a working day
	 */
	public WorkingDay() {
		inTime = LocalTime.now().withNano(0);
		outTime = LocalTime.now().withNano(0);
	}
	
	/**
	 * Creates a working day from 2 LocalTime objects
	 * @param inTime the inTime, when the employee comes in the company
	 * @param outTime the outTime, when the employee goes out of the company
	 */
	public WorkingDay(LocalTime inTime, LocalTime outTime) {
		this.inTime = inTime;
		this.outTime = outTime;
	}
	
	/**
	 * Returns a string representing the working day
	 */
	public String toString() {
		return "Works from " + inTime.toString() + " to " + outTime.toString();
	}
	
	/**
	 * Gets the inTime
	 * @return the inTime
	 */
	public LocalTime getInTime() {
		return inTime;
	}
	
	/**
	 * Sets the inTime
	 * @param inTime the inTime to set
	 */
	public void setInTime(LocalTime inTime) {
		this.inTime = inTime;
	}
	
	/**
	 * Gets the outTime
	 * @return the outTime
	 */
	public LocalTime getOutTime() {
		return outTime;
	}
	
	/**
	 * Sets the outTime
	 * @param outTime the outTime to set
	 */
	public void setOutTime(LocalTime outTime) {
		this.outTime = outTime;
	}
	
	
}
