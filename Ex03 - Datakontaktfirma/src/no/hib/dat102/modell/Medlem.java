package no.hib.dat102.modell;

import java.util.Iterator;

import no.hib.dat102.mengde.adt.MengdeADT;
import no.hib.dat102.mengde.kjedet.KjedetMengde;

/**
 * Representasjona av ett medlem
 * 
 * @author Arne E Flatekval
 *
 */
public class Medlem {
	private String navn;
	private MengdeADT<Hobby> hobbyer;
	private int statusIndeks;
	
	public Medlem() {
		this("", -1);
	}

	public Medlem(String navn, int statusIndeks) {
		this.navn = navn;
		this.hobbyer = new KjedetMengde<Hobby>();
		this.statusIndeks = statusIndeks;
	}

	/**
	 * @return the navn
	 */
	public String getNavn() {
		return navn;
	}

	/**
	 * @param navn
	 *            the navn to set
	 */
	public void setNavn(String navn) {
		this.navn = navn;
	}

	/**
	 * @return the hobbyer
	 */
	public MengdeADT<Hobby> getHobbyer() {
		return hobbyer;
	}

	/**
	 * @param hobbyer
	 *            the hobbyer to set
	 */
	public void setHobbyer(MengdeADT<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
	}

	/**
	 * @return the statusIndeks
	 */
	public int getStatusIndeks() {
		return statusIndeks;
	}

	/**
	 * @param statusIndeks
	 *            the statusIndeks to set
	 */
	public void setStatusIndeks(int statusIndeks) {
		this.statusIndeks = statusIndeks;
	}
	
	/**
	 * Skriver ut data om ett medlem
	 */
	public void skrivUt() {
		Iterator<Hobby> teller = hobbyer.oppramser();

		System.out.println("Navn: " + navn);
		while (teller.hasNext()) {
			System.out.println(teller.next().toString());
		}
		System.out.println("Status: " + statusIndeks);
	}

	/**
	 * Avgjør om to medlemmer passer til hverandre, altså kan danne et par. To
	 * medlemmer passer til hverandre dersom de har nøyaktig samme hobbyer.
	 * 
	 * @param medlem2
	 *            Medlem som skal sammenlignes med
	 * @return true visst medlemmene passer hverandre
	 */
	public boolean passerTil(Medlem medlem2) {
		return hobbyer.erLik(medlem2.getHobbyer());
	}
}
