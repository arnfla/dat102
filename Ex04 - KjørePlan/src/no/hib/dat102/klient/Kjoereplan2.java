package no.hib.dat102.klient;

import java.util.Scanner;

import no.hib.dat102.liste.adt.OrdnetListeADT;
import no.hib.dat102.liste.tabell.TabellOrdnetListe;
import no.hib.dat102.modell.Jobb;
import no.hib.dat102.modell.JobbSamling;

public class Kjoereplan2 {
	public static void main(String[] args) {
		Scanner tast = new Scanner(System.in);
		JobbSamling js = new JobbSamling();
		OrdnetListeADT<Jobb> klarKoe = new TabellOrdnetListe<Jobb>();
		
		Jobb jobb = null;
		int klokke  = 0;
		int tidskrav = 0;
		int antall = 0;
		
		// Leser fra fil¨
		System.out.print("Oppgi datafil: ");
		String filnavn = tast.nextLine();
		System.out.println("Datafil: " + filnavn);
		
		js.lesFraFil(filnavn);
		antall = js.hentAntall();
		
		System.out.println("Antall " + antall);
		JobbSamling ferdige = new JobbSamling(antall);
		
		while (ferdige.hentAntall() < antall) {
			do {
				jobb = js.hentAnkommenJobb(klokke);
				if (jobb != null) {
					klarKoe.leggTil(jobb);
				}
			} while (jobb != null);
			if (klarKoe.antall() > 0) {
				jobb = (Jobb) klarKoe.fjernFoerste();
				tidskrav = jobb.getKjoeretid();
				klokke = klokke + tidskrav;
				jobb.setFerdigTid(klokke);
				ferdige.leggTil(jobb);
			} else {
				klokke = klokke + 1;
			}
		} // while
		ferdige.visJobber();
		tast.close();
		
		
		
	}
}
