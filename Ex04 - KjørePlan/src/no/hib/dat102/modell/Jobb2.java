package no.hib.dat102.modell;

public class Jobb2 implements Comparable<Jobb2> {

	// Egenskaper
	private int jobbnr;
	private int ankomsttid;
	private int kjoeretid;
	private int ferdigtid;
	private int resttid;

	// Konstrukt�rer
	public Jobb2(int jnr, int kjtid, int anktid, int resttid) {
		jobbnr = jnr;
		ankomsttid = anktid;
		kjoeretid = kjtid;
		ferdigtid = -1;
		resttid = kjtid;

	}

	public int getKjoeretid() {
		return kjoeretid;
	}//

	public int getAnkomstTid() {
		return ankomsttid;
	}//

	public void setFerdigTid(int ferdig) {
		ferdigtid = ferdig;
	}//

	public int getFerdigTid() {
		return ferdigtid;
	}//
	
	public void setRestTid(int resttid) {
		this.resttid = resttid;
	}
	
	public int getRestTid() {
		return resttid;
	}

	public int finnVenteTid() {
		if (ferdigtid != -1)
			return ((ferdigtid - ankomsttid) - kjoeretid);
		else
			return 0;
	}//

	public int compareTo(Jobb2 denAndre) {
		int svar = 0;

		if (kjoeretid < denAndre.getKjoeretid()) {
			svar = -1;
		} else if (kjoeretid > denAndre.getKjoeretid()) {
			svar = 1;
		} else {// sammenligner ankomsttidene
			if (ankomsttid < denAndre.getAnkomstTid()) {
				svar = -1;
			} else if (ankomsttid > denAndre.getAnkomstTid()) {
				svar = 1;

			} else {
				svar = 0;
			}
		}
		return svar;
	}//

	public String toString() {
		return (jobbnr + "\t\t" + ankomsttid + "\t\t" + kjoeretid + "\t\t" + ferdigtid + "\t\t" + finnVenteTid()
				+ "\t\t");
	}//

}// class
