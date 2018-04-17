package guillaume.projet.java.time;

import java.time.LocalTime;

public class WorkingDay {
	private LocalTime inTime;
	private LocalTime outTime;
	
	/**
	 * 
	 */
	public WorkingDay() {
		inTime = LocalTime.now().withNano(0);
		outTime = LocalTime.now().withNano(0);
	}
	
	/**
	 * 
	 * @param inTime
	 * @param outTime
	 */
	public WorkingDay(LocalTime inTime, LocalTime outTime) {
		this.inTime = inTime;
		this.outTime = outTime;
	}
	
	public String toString() {
		return "Works from " + inTime.toString() + " to " + outTime.toString();
	}
	
	/**
	 * @return the inTime
	 */
	public LocalTime getInTime() {
		return inTime;
	}
	
	/**
	 * @param inTime the inTime to set
	 */
	public void setInTime(LocalTime inTime) {
		this.inTime = inTime;
	}
	
	/**
	 * @return the outTime
	 */
	public LocalTime getOutTime() {
		return outTime;
	}
	
	/**
	 * @param outTime the outTime to set
	 */
	public void setOutTime(LocalTime outTime) {
		this.outTime = outTime;
	}
	
	
}
