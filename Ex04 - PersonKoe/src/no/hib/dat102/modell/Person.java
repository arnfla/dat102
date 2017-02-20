package no.hib.dat102.modell;

public class Person implements Comparable<Person>{
	
	//Klassevariabler
	private String fornavn;
	private String etternavn;
	private int foedselsaar;
	
	/**
	 * Tom konstruktør
	 */
	public Person() {
		this("","",0);
	}
	
	/*
	 * Standardkonstruktør 
	 */
	public Person(String fornavn, String etternavn, int foedselsaar) {
		this.fornavn = fornavn;
		this.etternavn = etternavn; 
		this.foedselsaar = foedselsaar;
	}
	
	/**
	 * Hent fornavn
	 * 
	 * @return the fornavn
	 */
	public String getFornavn() {
		return fornavn;
	}

	/**
	 * Sett fornavn
	 * 
	 * @param fornavn the fornavn to set
	 */
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	/**
	 * Hent etternavn
	 * 
	 * @return the etternavn
	 */
	public String getEtternavn() {
		return etternavn;
	}

	/**
	 * Sett etternavn
	 * 
	 * @param etternavn the etternavn to set
	 */
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	/**
	 * Hent fødselsår
	 * 
	 * @return the foedselsaar
	 */
	public int getFoedselsaar() {
		return foedselsaar;
	}

	/**
	 * Sett fødslesår
	 * 
	 * @param foedselsaar the foedselsaar to set
	 */
	public void setFoedselsaar(int foedselsaar) {
		this.foedselsaar = foedselsaar;
	}
	
	/**
	 * Returnere data for person
	 * 
	 * @return String - Streng av alle klassevariabler
	 */
	@Override
	public String toString() {
		return "fornavn: "+fornavn+", etternavn: "+etternavn+", foedselsaar: "+foedselsaar;
	}
	
	/**
	 * Sammenligner to person objekter.
	 * 
	 * @param denAndre Person objekt
	 * 
	 * @return int
	 */
	@Override
	public int compareTo(Person denAndre) {
		int result = -1;
		Person p2 = (Person) denAndre;
		if(this.foedselsaar == p2.foedselsaar) {
			result = this.etternavn.compareTo(p2.etternavn);
			if(result == 0) {
				result = this.fornavn.compareTo(p2.fornavn);
			}
		} else if (this.foedselsaar > p2.foedselsaar){
			result = 1;
		}
		return result;
	}
}
