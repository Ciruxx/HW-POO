package it.uniroma3.diadia;

import static org.junit.Assert.*;
import it.uniroma3.diadia.ambienti.Stanza;

import org.junit.Before;
import org.junit.Test;

public class PartitaTest {

	Partita partitaAppenaIniziata;
	Partita partitaVinta;
	Partita partitaZeroCfu;
	Stanza stanzaVincente;

	@Before
	public void setUp() throws Exception {
		partitaAppenaIniziata = new Partita();
		partitaVinta = new Partita();
		partitaZeroCfu = new Partita();

		partitaZeroCfu.getGiocatore().setCfu(0);

		stanzaVincente = partitaVinta.getLabirinto().getStanzaVincente();
		partitaVinta.setStanzaCorrente(stanzaVincente);
	}

	@Test
	public void testIsVinta_AppenaIniziata() {
		assertFalse(partitaAppenaIniziata.isVinta());
	}

	@Test
	public void testIsVinta_Giusto() {
		assertTrue(partitaVinta.isVinta());
	}

	@Test
	public void testIsVinta_Persa() {
		assertFalse(partitaZeroCfu.isVinta());
	}

	@Test
	public void testIsFinita_NonFinita() {
		assertFalse(partitaAppenaIniziata.isFinita());
	}

	@Test
	public void testIsFinita_Cfu() {
		assertTrue(partitaZeroCfu.isFinita());
	}

	@Test
	public void testIsFinita_PartitaVinta() {
		assertTrue(partitaVinta.isFinita());
	}

}
