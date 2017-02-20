package no.hib.dat102.adt;

public interface KoeADT<T> {
	/** 
	 * Legge til et element bak i køen. 
	 * 
	 * @param element
	 * */
	public void innKoe(T element);

	/** 
	 * Fjerner og returnerer elementet foran i køen. 
	 * */
	public T utKoe();

	/** 
	 * Returnerer elementet foran i køen uten å fjerne det fra køen. 
	 * */
	public T foerste();

	/**
	 * Returns sann hvis denne køene ikke inneholder noen elementer..
	 */
	public boolean erTom();

	/** 
	 * Returnerer antall elementer i køen. 
	 * */
	public int antall();

}//
