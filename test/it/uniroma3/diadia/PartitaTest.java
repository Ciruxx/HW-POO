package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PartitaTest {

	Partita partitaAppenaIniziata;
	Partita partitaVinta;
	Partita partitaZeroCfu;
	Stanza stanzaVincente;

	@Before
    public void setUp() {
		partitaAppenaIniziata = new Partita(1);
		partitaVinta = new Partita(2);
		partitaZeroCfu = new Partita(1);

		partitaZeroCfu.getGiocatore().setCfu(0);

		stanzaVincente = partitaVinta.getLabirinto().getStanzaVincente();
		partitaVinta.setStanzaCorrente(stanzaVincente);
	}

	@Test
	public void testIsVinta_AppenaIniziata() {
		assertFalse(partitaAppenaIniziata.isVintaPartita());
	}

	@Test
	public void testIsVinta_Giusto() {
		assertTrue(partitaVinta.isVintaPartita());
	}

	@Test
	public void testIsVinta_Persa() {
		assertFalse(partitaZeroCfu.isVintaPartita());
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
