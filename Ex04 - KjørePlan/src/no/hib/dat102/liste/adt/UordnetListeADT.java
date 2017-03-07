package no.hib.dat102.liste.adt;

/**
 * Definerer grensenitt til en uordnet samling liste.
 *
 * @param <T> datatypen for elementene
 */
public interface UordnetListeADT<T> extends ListeADT<T> {

    /**
     * Legger det spesifiserte elementet foran i denne listen.
     *
     * @param element elementet som skal inn i listen
     */
    void leggTilForan(T element);

    /**
     * Legger det spesifiserte elementet bak i listen.
     *
     * @param element elementet som skal inn i listen
     */
    void leggTilBak(T element);

    /**
     * Legger til det spesifiserte elementet slik at det kommer rett etter elementet aktuell. Feilmelding hvis elementet
     * aktuell ikke fins i denne listen.
     *
     * @param element element elementet som skal inn i listen
     * @param aktuell elementet det skal ligge etter
     */
    void leggTilEtter(T element, T aktuell);

}
