package no.hib.dat102.utsyn;

import java.util.Iterator;

import no.hib.dat102.mengde.kjedet.KjedetMengde;
import no.hib.dat102.modell.Datakontakt;

public class Teksgrensesnitt {
	/**
	 * Skriver ut på skjermen en oversikt over medlemmer som er koblet til
	 * hverandre i medlemstabellen til enhver tid. Et slikt par skal kun vises
	 * en gang på utskriftlisten. Metoden skriver også ut antall par som er
	 * funnet.
	 * 
	 * @param arkiv
	 *            Datakontakt arkiv som skal skrives ut
	 */
	public void skrivParListe(Datakontakt arkiv) {
		KjedetMengde<Integer> par = new KjedetMengde<Integer>();
		int partnerIndex = -1;
		int antallPar = 0;
		for (int i = 0; i < arkiv.getAntall(); i++) {
			partnerIndex = arkiv.getMedlemstabell()[i].getStatusIndeks();
			if (partnerIndex > -1 && !par.inneholder(i) && arkiv.getMedlemstabell()[i] != null) {
				par.leggTil(i);
				par.leggTil(partnerIndex);
				antallPar++;
			}
		}

		System.out.printf("%15s%15s%n", "Par: (Antall: " + antallPar + ")", "Interesser:");

		Iterator<Integer> teller = par.oppramser();
		Integer id1;
		Integer id2;
		for (int i = 0; i < antallPar; i++) {
			id1 = teller.next().intValue();
			id2 = teller.next().intValue();
			System.out.printf("%-20s",
					arkiv.getMedlemstabell()[id1].getNavn() + " og " + arkiv.getMedlemstabell()[id2].getNavn());

			// Hobbyer for id1 og id2 vil være like
			System.out.printf("%15s%n", arkiv.getMedlemstabell()[id1].getHobbyer());
		}
	}
}
