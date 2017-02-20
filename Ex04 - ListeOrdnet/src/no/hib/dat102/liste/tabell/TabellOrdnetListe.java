package no.hib.dat102.liste.tabell;

import no.hib.dat102.liste.adt.*;

//********************************************************************
//  TabellOrdnetListe.java
//
//  Representerer en tabell av en ordnet liste.
//********************************************************************

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	/******************************************************************
	 * Opprette en tom liste med standard kapasitet..
	 ******************************************************************/
	private final static int STDK = 100;
	private final static int IKKE_FUNNET = -1;
	private int bak;
	private T[] liste;
	
	/******************************************************************
	 * Konstrukt�rer
	 ******************************************************************/

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapsitet) {
		bak = 0;
		liste = (T[]) (new Comparable[startKapsitet]);
	}

	/******************************************************************
	 * Legger til et spesifisert element til denne listen slik at listen
	 * fortsatt er sortert.
	 ******************************************************************/
	
	public void leggTil(T element) {
		//Hvis tabellen er full -> utvid
		if(bak == liste.length - 1) {
			utvid();
		}
		//Finner index der vi skal sette inn elementet
		int i = 0;
		while(element.compareTo(liste[i]) > 0) {
			i++;
		}
		//I peker paa plassen vi skal ha inn element, setter j = bak og flytter alle elementene som er stoerre til i+1;
		int j = bak;
		while (j > i) {
			liste[j] = liste[j+1];
			j--;
		}
		
		//Setter liste[i] til elementet vi vil sette inn
		liste[i] = element;
		bak++;
		
		
	}

	
	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	@Override
	//
	public T fjern(T element) {
		T resultat = null;

		int indeks = finn(element);

		if (indeks != IKKE_FUNNET) {
			resultat = liste[indeks];
			bak--;
			/** skifter elementene etter det vi fjernet en plass opp */
			for (int i = indeks; i < bak; i++){
				liste[i] = liste[i + 1];
			}
			 // if
		}
		return resultat;
	}

	
	private int finn(T el) {
		int i = 0, resultat = -1;
		if (!erTom()) {
			while (i < bak && el.compareTo(liste[i]) > 0) {
				i++;
			}
			if (i < bak && el.compareTo(liste[i]) == 0) {
				resultat = i;
			}
		}

		return resultat;
	}
		
		@Override
		public T fjernSiste() {
			T resultat = null;
			if(!erTom()) {
				resultat = liste[bak-1];
				bak--;
			}
			return resultat;
		}

		@Override
		public T fjernFoerste() {
			T resultat = null;
			if(!erTom()) {
				resultat = liste[0];
				for(int i = 0; i < bak - 1; i++) {
					liste[i] = liste[i+1];
				}
			}
			
			return resultat;
		}//

		@Override
		public T foerste() {
			T resultat = null;
			if (!erTom()){
				resultat = liste[0];
			}
			return resultat;
		}

		@Override
		public T siste() {
			T resultat = null;
			if (!erTom()) {
				resultat = liste[bak - 1];
			}

			return resultat;
		}

		@Override
		public boolean erTom() {
			return (bak == 0);
		}

		@Override
		public int antall() {
			return bak;
		}
		
		public String toString() {
			String resultat = "";

			for (int i = 0; i < bak; i++) {
				resultat = resultat + liste[i].toString() + "\n";
			}
			return resultat;
		}

		private void utvid() {
			T[] hjelpeTabell = (T[]) (new Object[liste.length * 2]);

			for (int i = 0; i < liste.length; i++){
				hjelpeTabell[i] = liste[i];
			}
			liste = hjelpeTabell;
		}

	
}// class
