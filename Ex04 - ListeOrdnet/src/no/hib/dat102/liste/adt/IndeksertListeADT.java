package no.hib.dat102.liste.adt;


 /**
 * @param <T>
 *            datatypen for elementene
 */
public interface IndeksertListeADT<T> extends ListeADT<T> {
		
	/**
	 * Fjerner et element
	 * 
	 * @param element
	 *            elementet som skal fjernes i listen
	 */
	boolean inneholder(T element);

	/**
	 * Legger det spesifiserte elementet foran i denne listen.
	 *
	 * @param element
	 *            elementet som skal inn i listen
	 */
	void leggTilForan(T element);

	/**
	 * Legger det spesifiserte elementet bak i listen.
	 *
	 * @param element
	 *            elementet som skal inn i listen
	 */
	void leggTilBak(T element);

	/**
	 * Legger til det spesifiserte elementet slik at det kommer rett etter
	 * elementet aktuell. Feilmelding hvis elementet aktuell ikke fins i denne
	 * listen.
	 *
	 * @param element
	 *            element elementet som skal inn i listen
	 * @param aktuell
	 *            elementet det skal ligge etter
	 */
	void leggTilEtter(T element, T aktuell);
	
	/**
	 * 
	 * @param element
	 * @return
	 */

	T fjern(T element);
	
	/**
	 * Fjerner n p�f�lgende elementer (en delliste) fra listen fra og med indeksen
	 * indeks. Hvis n er antall, s� slettes alle elementene fra og med start.
	 * 
	 * @param start er startindeksen
	 * @param n er antall elementer i listen
	 * 
	 */
	void fjernDelListe(int indeks, int n);
	
	/**
	 *  Setter denAndreListen inn i denne listen ved indeksen
	 *  
	 *  @param denAndreListen er den andre listen
	 *  @param indeks er indeksen der listen skal inn
	 * 
	 */
	void settInnListe(IndeksertListeADT<T> denAndreListen, int indeks);
	
	/**
	 * Avgj�r om listen er tom
	 * @return true hvis listen er tom , false ellers
	 */		
	boolean erTom();
	
	/**
	 * 
	 * @return
	 */
	
}
