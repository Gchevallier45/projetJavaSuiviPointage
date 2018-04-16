/*
 * Check.java
 * Implements check system of the company
 */

package guillaume.projet.java.time;

import java.time.LocalDateTime;

public class Check {
	RoundedTime inCheck;
	RoundedTime outCheck;
	
	public Check() {
		
	}

	public Check(RoundedTime inCheck, RoundedTime outCheck) {
		this.inCheck = inCheck;
		this.outCheck = outCheck;
	}

	public RoundedTime getInCheck() {
		return inCheck;
	}

	public void setInCheck(RoundedTime inCheck) {
		this.inCheck = inCheck;
	}

	public RoundedTime getOutCheck() {
		return outCheck;
	}

	public void setOutCheck(RoundedTime outCheck) {
		this.outCheck = outCheck;
	}
	
	/**
	 * G�re les pointages de la journ�e
	 * @throws Exception
	 */
	public void check() throws Exception {
		if(inCheck == null) {
			inCheck = new RoundedTime(LocalDateTime.now());			
		}
		else if(inCheck != null && outCheck == null) {
			outCheck = new RoundedTime(LocalDateTime.now());			
		}
		else if(inCheck != null && outCheck != null){
			throw new RuntimeException("L'employ� � d�j� point� pour la journ�e");
		}
		else {
			throw new RuntimeException("Incoh�rence dans les pointages");
		}
	}

}
