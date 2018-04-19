/**
 * Check.java
 * Implements check system of the company
 * @author Guillaume CHEVALLIER
 */

package guillaume.projet.java.model.time;

import java.time.LocalDate;
import java.time.LocalTime;

public class Check {
	LocalDate date;
	LocalTime inCheck;
	LocalTime outCheck;
	
	/**
	 * Creates a check object
	 */
	public Check() {
		date = LocalDate.now();
	}

	/**
	 * Creates a check object from 2 LocalTime objects
	 * @param inCheck the inCheck
	 * @param outCheck the outCheck
	 */
	public Check(LocalTime inCheck, LocalTime outCheck) {
		this.inCheck = inCheck;
		this.outCheck = outCheck;
		date = LocalDate.now();
	}

	/**
	 * Gets the first check of the day
	 * @return the in check
	 */
	public LocalTime getInCheck() {
		return inCheck;
	}
	
	/**
	 * Sets the first check of the day
	 * @param inCheck the time of the check
	 */
	public void setInCheck(LocalTime inCheck) {
		this.inCheck = inCheck;
	}

	/**
	 * Gets the second check of the day
	 * @return the out check
	 */
	public LocalTime getOutCheck() {
		return outCheck;
	}
	
	/**
	 * Sets the second check of the day
	 * @param outCheck the time of the check
	 */
	public void setOutCheck(LocalTime outCheck) {
		this.outCheck = outCheck;
	}
	
	/**
	 * Gets the date corresponding to the check 
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Process a check request
	 * @throws Exception
	 */
	public void processCheck() throws Exception {
		if(inCheck == null) {
			inCheck = Time.getRoundedTime(LocalTime.now());			
		}
		else if(inCheck != null && outCheck == null) {
			outCheck = Time.getRoundedTime(LocalTime.now());			
		}
		else if(inCheck != null && outCheck != null){
			throw new RuntimeException("Employee already checked 2 times");
		}
		else {
			throw new RuntimeException("Checks integrity error");
		}
	}

}
