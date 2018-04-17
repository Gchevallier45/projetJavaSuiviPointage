/*
 * Check.java
 * Implements check system of the company
 */

package guillaume.projet.java.time;

import java.time.LocalDate;
import java.time.LocalTime;

public class Check {
	LocalDate date;
	LocalTime inCheck;
	LocalTime outCheck;
	
	public Check() {
		
	}

	public Check(LocalTime inCheck, LocalTime outCheck) {
		this.inCheck = inCheck;
		this.outCheck = outCheck;
	}

	public LocalTime getInCheck() {
		return inCheck;
	}

	public void setInCheck(LocalTime inCheck) {
		this.inCheck = inCheck;
	}

	public LocalTime getOutCheck() {
		return outCheck;
	}

	public void setOutCheck(LocalTime outCheck) {
		this.outCheck = outCheck;
	}
	
	/**
	 * Gère les pointages de la journée
	 * @throws Exception
	 */
	public void check() throws Exception {
		if(inCheck == null) {
			inCheck = Time.getRoundedTime(LocalTime.now());			
		}
		else if(inCheck != null && outCheck == null) {
			outCheck = Time.getRoundedTime(LocalTime.now());			
		}
		else if(inCheck != null && outCheck != null){
			throw new RuntimeException("L'employé à déjà pointé pour la journée");
		}
		else {
			throw new RuntimeException("Incohérence dans les pointages");
		}
	}

}
