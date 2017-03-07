package no.hib.dat102.liste.adt;

/**
 * Definerer interface til en generell liste. Spesielle typer av lister vil bli
 * avledet av dette grensesnittet. 
 *
 * @param <T> elementtypen
 */
public interface ListeADT<T> {

    /**
     * Fjerner og returnerer det første elmentet fra listen.
     *
     * @return elementet som er fjernet
     */
    T fjernFoerste();

    /**
     * Fjerner og returnerer det siste elementet fra denne listen.
     *
     * @return elementet som er fjernet
     */
    T fjernSiste();

    /**
     * Fjerner og returnerer det spesifiserte elementet fra denne listen.
     *
     * @return elementet som er fjernet
     */
    T fjern(T element);

    /**
     * Returnerer en refreanse til det første elementet i denne listen.
     *
     * @return første element i listen
     */
    T foerste();

    /**
     * Returnerer det siste elmentet i denne listen.
     *
     * @return siste element i listen
     */
    T siste();

    /**
     * Returner sann hvis denne listen inneholder det spesifiserte elmentet.
     *
     * @return sann hvis elementet finnes
     */
    boolean inneholder(T element);

    /**
     * Returnerer sann hvis listen er tom.
     *
     * @return sann hvis tom liste
     */
    boolean erTom();

    /**
     * Returnnerer antall elemnter i listen.
     *
     * @return antall elementer
     */
    int antall();

    /** Returnerer en iterator for elementene i denne listen. */
    // public Iterator<T> iterator();

}
