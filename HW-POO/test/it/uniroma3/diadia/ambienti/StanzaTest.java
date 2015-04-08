package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class StanzaTest {

	Stanza stanza1;
	Stanza stanza2;
	Attrezzo attrezzo1;
	Attrezzo attrezzo2;


	@Before
	public void setUp() throws Exception {
		stanza1 = new Stanza("Stanza 1");
		stanza2 = new Stanza("Stanza 2");
		attrezzo1 = new Attrezzo("Martello", 2);
		attrezzo2 = new Attrezzo("Cacciavite", 5);
		
		stanza2.addAttrezzo(attrezzo1);
		stanza2.addAttrezzo(attrezzo2);
		stanza2.removeAttrezzo(attrezzo1);

		stanza1.addAttrezzo(attrezzo1);
	}
	
	@Test
	public void testAddAttrezzo() {
		Stanza stanza = new Stanza("Stanza 3");
		for (int i = 0; i<10; i++) {
			assertTrue(stanza.addAttrezzo(attrezzo1));
		}
		assertFalse(stanza.addAttrezzo(attrezzo1));
	}
	
	@Test
	public void testGetStanzaAdiacenteSud() {
		testGetStanzaAdiacenteGenerico("sud");
	}

	@Test
	public void testGetStanzaAdiacenteNord() {
		testGetStanzaAdiacenteGenerico("nord");
	}

	@Test
	public void testGetStanzaAdiacenteEst() {
		testGetStanzaAdiacenteGenerico("est");
	}

	@Test
	public void testGetStanzaAdiacenteOvest() {
		testGetStanzaAdiacenteGenerico("ovest");
	}

	private void testGetStanzaAdiacenteGenerico(String direzione) {
		stanza1.impostaStanzaAdiacente(direzione, stanza2);
		assertSame(stanza2, stanza1.getStanzaAdiacente(direzione));
	}

	@Test
	public void testHasAttrezzoEsistente() {
		assertTrue(stanza1.hasAttrezzo(attrezzo1.getNome()));
	}
	
	@Test
	public void testHasAttrezzoInesistente() {
		assertFalse(stanza1.hasAttrezzo("AttrezzoCheNonEsiste"));
	}
	
	@Test
	public void testHasAttrezzoStanza2() {
		assertTrue(stanza2.hasAttrezzo(attrezzo2.getNome()));
	}

	@Test
	public void testGetAttrezzo() {
		assertSame(attrezzo1, stanza1.getAttrezzo(attrezzo1.getNome()));
		assertNull(stanza1.getAttrezzo("AttrezzoCheNonEsiste"));
	}

	@Test
	public void testRemoveAttrezzo() {
		stanza1.removeAttrezzo(attrezzo1);
		assertFalse(stanza1.hasAttrezzo(attrezzo1.getNome()));
	}
	
	@Test
	public void testRemoveAttrezzoInTesta() {
		assertFalse(stanza2.hasAttrezzo(attrezzo1.getNome()));
		assertTrue(stanza2.hasAttrezzo(attrezzo2.getNome()));
	}

}
