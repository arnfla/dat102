package no.hib.dat102.modell;

/**
 * Klasse for presentasjon for hobbyer
 * 
 * @author Arne E Flatekval
 *
 */

public class Hobby {
	private String hobbyNavn;

	/**
	 * Tom konstruktoer for hobby
	 */
	public Hobby() {
		this("");
	}

	/**
	 * Konstruktoer for hobby
	 * 
	 * @param hobby
	 *            Hobby
	 */
	public Hobby(String hobby) {
		hobbyNavn = hobby;
	}

	/**
	 * @return the hobbyNavn
	 */
	public String getHobbyNavn() {
		return hobbyNavn;
	}

	/**
	 * @param hobbyNavn
	 *            the hobbyNavn to set
	 */
	public void setHobbyNavn(String hobbyNavn) {
		this.hobbyNavn = hobbyNavn;
	}
	/**
	 * To String <hobbyNavn>
	 */
	public String toString() {
		return "<"+hobbyNavn+">";
	}
	
	/**
	 * Sjekker om to hobbyer er like
	 * @param hobby2
	 * 		Hobby å sjekke opp mot
	 * @return
	 * 		boolean
	 */
	public boolean equals(Object hobby2) {
		Hobby hobbyDenAndre = (Hobby) hobby2;
		return (hobbyNavn.equals(hobbyDenAndre.getHobbyNavn()));
	}

}
