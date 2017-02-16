package no.hib.dat102;

import no.hib.dat102.mengde.adt.MengdeADT;
import no.hib.dat102.mengde.tabell.TabellMengde;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestTabellMengde {
	
	//Referanse til tabell
	private MengdeADT<Integer> tabell;
	private MengdeADT<Integer> union;
	private MengdeADT<Integer> tabell2;
	
	// Testdata
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	
	@Before
	public final void setup() {
		tabell = new TabellMengde<Integer>();
		
		//Brukes på å teste med 2 mengder
		union = new TabellMengde<Integer>();
		tabell2 = new TabellMengde<Integer>();
		tabell2.leggTil(e0);
	}
	
	@Test
	public final void tabellErTom() {
		assertTrue(tabell.erTom());
	}
	
	@Test
	public final void antall() {
		tabell.leggTil(e1);
		tabell.leggTil(e2);
		assertEquals(2, tabell.antall());
	}
	
	@Test
	public final void leggTil() {
		tabell.leggTil(e1);
		assertEquals(1, tabell.antall());
	}
	
	@Test
	public final void fjernTomTabell() {
		assertEquals(null, tabell.fjern(e0));
	}
	
	@Test
	public final void leggTilFjern() {
		tabell.leggTil(e1);
		assertEquals(e1, tabell.fjern(e1));
	}
	
	public final void leggTilFjernErTom() {
		tabell.leggTil(e1);
		assertEquals(e1, tabell.fjern(e1));
		assertTrue(tabell.erTom());
	}
	
	@Test
	public final void leggTilleggTilFjern() {
		tabell.leggTil(e0);
		tabell.leggTil(e1);
		assertEquals(e1, tabell.fjern(e1));
		assertTrue(tabell.inneholder(e0));
		assertFalse(tabell.inneholder(e1));
	}
	
	@Test
	public final void union() {
		tabell.leggTil(e1);
		tabell.leggTil(e2);
		union = tabell.union(tabell2);
		assertTrue(union.inneholder(e0));
		assertTrue(union.inneholder(e1));
		assertTrue(union.inneholder(e2));
	}
	
	@Test
	public final void likeTabeller() {
		tabell.leggTil(e0);
		tabell.leggTil(e1);
		tabell2.leggTil(e1);
		assertTrue(tabell.erLik(tabell2));
	}
	
	@Test
	public final void ulikeTabeller() {
		tabell.leggTil(e1);
		assertFalse(tabell.erLik(tabell2));
	}
	
	@Test
	public final void ulikeTabellerLiktAntall() {
		tabell.leggTil(e0);
		tabell.leggTil(e1);
		assertFalse(tabell.erLik(tabell2));
	}
	
	@Test
	public final void fjernTilfeldig() {
		tabell.leggTil(e0);
		tabell.leggTil(e1);
		tabell.leggTil(e2);
		tabell.leggTil(e3);
		assertFalse(tabell.inneholder(tabell.fjernTilfeldig()));
	}
}
