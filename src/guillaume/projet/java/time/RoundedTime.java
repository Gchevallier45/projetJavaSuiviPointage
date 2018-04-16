/*
 * RoundedTime.java
 * Generates a rounded time from a given time
 */

package guillaume.projet.java.time;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class RoundedTime {
	
	private LocalDateTime rawTime;
	private LocalDateTime roundedTime;

	/**
	 * Constructeur avec paramètre
	 * @param rawTime
	 */
	public RoundedTime(LocalDateTime rawTime) {
		setRawTime(rawTime);
	}

	/**
	 * Retourne l'horaire arrondie
	 * @return l'horaire arrondi
	 */
	public LocalDateTime getRoundedTime() {
		return roundedTime;
	}

	/**
	 * Retourne l'horaire au format brut
	 * @return l'horaire réel de pointage
	 */
	public LocalDateTime getRawTime() {
		return rawTime;
	}

	/**
	 * Copie l'horaire réel de pointage dans la classe et calcule le temps arrondi
	 * @param rawTime l'horaire réel de pointage
	 */
	private void setRawTime(LocalDateTime rawTime) {
		this.rawTime = rawTime;
		
		long roundedSeconds = this.rawTime.toEpochSecond(ZoneOffset.UTC);
		roundedTime = LocalDateTime.ofEpochSecond(roundedSeconds%(15*60), 0, ZoneOffset.UTC);
		if(roundedTime.getMinute()>7) {
			roundedTime = rawTime.plusSeconds(15*60-(roundedTime.getMinute()*60+roundedTime.getSecond()));
		}
		else {
			roundedTime = rawTime.minusSeconds(roundedTime.getMinute()*60+roundedTime.getSecond());
		}
		
		roundedTime = roundedTime.withNano(0);
	}

}
