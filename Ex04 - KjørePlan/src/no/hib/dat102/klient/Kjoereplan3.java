package no.hib.dat102.klient;

import java.util.Scanner;

import no.hib.dat102.koe.tabell.TabellKoe;
import no.hib.dat102.liste.adt.OrdnetListeADT;
import no.hib.dat102.liste.tabell.TabellOrdnetListe;
import no.hib.dat102.modell.Jobb;
import no.hib.dat102.modell.JobbSamling;

public class Kjoereplan3 {
	public static void main(String[] args) {
		Scanner tastatur = new Scanner(System.in);
		JobbSamling js = new JobbSamling();
		OrdnetListeADT<Jobb> klarKoeA = new TabellOrdnetListe<Jobb>();
		TabellKoe<Jobb> klarKoeB = new TabellKoe<Jobb>();

		Jobb jobb = null;
		int klokke = 0;
		int tidskrav = 0;
		int antall = 0;
		int tidssegmentA = 10;
		int tidssegmentB = 20;

		// Leser fra fil
		System.out.print("Oppgi datafil:");
		String filnavn = tastatur.nextLine();
		System.out.println("Datafil: " + filnavn);

		js.lesFraFil(filnavn);
		antall = js.hentAntall();

		System.out.println("antall " + antall);
		JobbSamling ferdige = new JobbSamling(antall);
		
		while (ferdige.hentAntall() < antall) {
			do {
				jobb = js.hentAnkommenJobb(klokke);
				if (jobb != null) {
					klarKoeA.leggTil(jobb);
				}
			} while (jobb != null);
			if (klarKoeA.antall() > 0) {
				jobb = (Jobb) klarKoeA.fjernFoerste();
				//System.out.println(j.toString());
				jobb.setRestTid(jobb.getRestTid() - tidssegmentA);
				if (jobb.getRestTid() <= 0) {
					ferdige.leggTil(jobb);
					tidskrav = jobb.getKjoeretid();
					klokke = klokke + tidskrav;
					jobb.setFerdigTid(klokke);
				} else {
					klarKoeB.innKoe(jobb);
				}
			} else {
				klokke++;
			}
		}
		while (!klarKoeB.erTom()) {
			
			Jobb j = klarKoeB.utKoe();
			j.setRestTid(j.getRestTid() - tidssegmentB);
			if (j.getRestTid() <= 0) {
				ferdige.leggTil(j);
				tidskrav = j.getRestTid();
				klokke = klokke + tidskrav;
				j.setFerdigTid(klokke);
			} else {
				klarKoeB.innKoe(j);
			}
		}
		ferdige.visJobber();
		tastatur.close();

	}
}
