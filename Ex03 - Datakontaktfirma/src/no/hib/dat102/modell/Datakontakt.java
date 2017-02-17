package no.hib.dat102.modell;

/**
 * Klasse for å holde styr på medlemstabell
 * 
 * @author Arne E Flatekval
 *
 */

public class Datakontakt {
	private static int STDK = 100;
	private Medlem[] medlemstabell;
	private int antall;

	public Datakontakt() {
		this(STDK);
	}

	public Datakontakt(int storrelse) {
		this.antall = 0;
		this.medlemstabell = new Medlem[storrelse];
	}

	/**
	 * @return the sTDK
	 */
	public static int getSTDK() {
		return STDK;
	}

	/**
	 * @param sTDK
	 *            the sTDK to set
	 */
	public static void setSTDK(int sTDK) {
		STDK = sTDK;
	}

	/**
	 * @return the medlemstabell
	 */
	public Medlem[] getMedlemstabell() {
		return medlemstabell;
	}

	/**
	 * @param medlemstabell
	 *            the medlemstabell to set
	 */
	public void setMedlemstabell(Medlem[] medlemstabell) {
		this.medlemstabell = medlemstabell;
	}

	/**
	 * @return the antall
	 */
	public int getAntall() {
		return antall;
	}

	/**
	 * @param antall
	 *            the antall to set
	 */
	public void setAntall(int antall) {
		this.antall = antall;
	}

	/**
	 * Legger til et nytt medlem i medlemstabellen
	 * 
	 * @param person
	 *            Medlem som skal legges til
	 */
	public void leggTilMedlem(Medlem medlem) {
		if (antall == medlemstabell.length) {
			utvid();
		}
		medlemstabell[antall] = medlem;
		antall++;
	}

	private void utvid() {
		Medlem[] hjelpetabell = new Medlem[(int) Math.ceil(2 * medlemstabell.length)];
		for (int i = 0; i < medlemstabell.length; i++) {
			hjelpetabell[i] = medlemstabell[i];
		}
		medlemstabell = hjelpetabell;
	}

	public int finnMedlemIndex(String medlemsnavn) {
		int result = 0;
		for (int i = 0; i < medlemstabell.length && result == 0; i++) {
			if (medlemsnavn.equals(medlemstabell[i].getNavn())) {
				result = i;
			}
		}
		return result;
	}

	public int finnPartnerFor(String medlemsnavn) {
		int medlemsIndex = finnMedlemIndex(medlemsnavn);
		int matchIndex = -1;
		for (int i = 0; i < medlemstabell.length && matchIndex < 0; i++) {
			if (medlemstabell[medlemsIndex].passerTil(medlemstabell[i])) {
				matchIndex = i;
				medlemstabell[medlemsIndex].setStatusIndeks(matchIndex);
				medlemstabell[matchIndex].setStatusIndeks(medlemsIndex);
			}
		}
		return matchIndex;
	}

	public void tilbakestillStatusIndex(String medlemsnavn) {
		int medlemsIndex = finnMedlemIndex(medlemsnavn);
		int matchIndex = finnPartnerFor(medlemsnavn);

		if (matchIndex > -1 && medlemsIndex > -1) {
			medlemstabell[medlemsIndex].setStatusIndeks(-1);
			medlemstabell[matchIndex].setStatusIndeks(-1);
		}
	}

}
