package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class StanzaTest {

	private Stanza stanza1;
	private Stanza stanza2;
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	private Stanza stanzaVuota;


	@Before
	public void setUp() throws Exception {
		stanza1 = new Stanza("Stanza 1");
		stanza2 = new Stanza("Stanza 2");
		stanzaVuota = new Stanza("Stanza vuota");

		attrezzo1 = new Attrezzo("Martello", 2);
		attrezzo2 = new Attrezzo("Cacciavite", 5);

		stanza1.addAttrezzo(attrezzo1);
		
		stanza2.addAttrezzo(attrezzo1);
		stanza2.addAttrezzo(attrezzo2);
		stanza2.removeAttrezzo(attrezzo1);
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
	public void testGetStanzaAdiacente_Sud() {
		testGetStanzaAdiacente_Generico("sud");
	}

	@Test
	public void testGetStanzaAdiacente_Nord() {
		testGetStanzaAdiacente_Generico("nord");
	}

	@Test
	public void testGetStanzaAdiacente_Est() {
		testGetStanzaAdiacente_Generico("est");
	}

	@Test
	public void testGetStanzaAdiacente_Ovest() {
		testGetStanzaAdiacente_Generico("ovest");
	}

	private void testGetStanzaAdiacente_Generico(String direzione) {
		stanza1.impostaStanzaAdiacente(direzione, stanza2);
		assertSame(stanza2, stanza1.getStanzaAdiacente(direzione));
	}

	@Test
	public void testHasAttrezzo_Esistente() {
		assertTrue(stanza1.hasAttrezzo(attrezzo1.getNome()));
	}
	
	@Test
	public void testHasAttrezzo_Inesistente() {
		assertFalse(stanza1.hasAttrezzo("AttrezzoCheNonEsiste"));
	}
	
	@Test
	public void testGetAttrezzo_StanzaVuota() {
		assertNull(stanza1.getAttrezzo("AttrezzoCheNonEsiste"));
	}
	
	@Test
	public void testGetAttrezzo_Esistente() {
		assertSame(attrezzo1, stanza1.getAttrezzo(attrezzo1.getNome()));
	}	

	@Test
	public void testGetAttrezzo_Inesistente() {
		assertNull(stanza1.getAttrezzo("AttrezzoCheNonEsiste"));
	}
	
	@Test
	public void testRemoveAttrezzo_StanzaVuota() {
		assertFalse(stanzaVuota.removeAttrezzo(attrezzo1));
	}

	@Test
	public void testRemoveAttrezzo_Esistente() {
		stanza1.removeAttrezzo(attrezzo1);
		assertFalse(stanza1.hasAttrezzo(attrezzo1.getNome()));
	}
	
	@Test
	public void testRemoveAttrezzo_InTesta() {
		assertFalse(stanza2.hasAttrezzo(attrezzo1.getNome()));
		assertTrue(stanza2.hasAttrezzo(attrezzo2.getNome()));
	}

}