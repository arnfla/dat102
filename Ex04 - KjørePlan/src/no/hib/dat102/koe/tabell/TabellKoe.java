package no.hib.dat102.koe.tabell;

import no.hib.dat102.koe.adt.KoeADT;

//********************************************************************
//
//  Representerer en tabell implementasjon av samling kø.
// front til køen er i posisjon 0.
//********************************************************************

public class TabellKoe<T> implements KoeADT<T> {
	private final int STDK = 100;
	private int bak;
	private T[] koe;

	/******************************************************************
	 * Oppretter en tom kø med standard størrelse.
	 ******************************************************************/
	public TabellKoe() {
		bak = 0;
		koe = (T[]) (new Object[STDK]);

	}

	/******************************************************************
	 * Oppretter en tom kø med spesifisert kapasitet..
	 ******************************************************************/
	public TabellKoe(int startKapasitet) {
		bak = 0;
		koe = (T[]) (new Object[startKapasitet]);
	}

	/******************************************************************
	 * Legger til et spesifisert element bak i køen, utvider hvis nødvendig
	 * 
	 ******************************************************************/
	public void innKoe(T element) {
		if (antall() == koe.length) {
			utvid();
		}

		koe[bak] = element;
		bak++;
	}

	/******************************************************************
	 * Fjerner elementet foran i køen.
	 ******************************************************************/
	public T utKoe() {

		T resultat = null;
		if (!erTom()) {
			resultat = koe[0];
			bak--;
		}

		/** flytter elementene en plass frem */
		for (int soek = 0; soek < bak; soek++) {
			koe[soek] = koe[soek + 1];
		}
		koe[bak] = null; // kan sløyfes
		return resultat;
	}

	/******************************************************************
	 * Returnerer elementet foran.
	 ******************************************************************/
	public T foerste() {

		T resultat = null;

		if (!erTom()) {
			resultat = koe[0];
		}
		return resultat;
	}

	/******************************************************************
	 * Returnerer sann hvis køen er tom, usann ellers..
	 ******************************************************************/
	public boolean erTom() {
		return (bak == 0);
	}

	/******************************************************************
	 * Returnerer antall elementer i køen.
	 ******************************************************************/
	public int antall() {
		return bak;
	}

	/******************************************************************
	 * Returnerer en strengrepresentasjon av elementene i køen.
	 ******************************************************************/
	public String toString() {
		String resultat = "";

		for (int soek = 0; soek < bak; soek++) {
			resultat = resultat + koe[soek].toString() + "\n";
		}
		return resultat;
	}

	/******************************************************************
	 * Oppretter en ny tabell større for å lagre elmentene.
	 ******************************************************************/
	private void utvid() {
		T[] hjelpetabell = (T[]) (new Object[koe.length * 2]);

		for (int soek = 0; soek < koe.length; soek++) {
			hjelpetabell[soek] = koe[soek];
		}
		koe = hjelpetabell;
	}

}// class
