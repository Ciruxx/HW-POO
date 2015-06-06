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
    public void testIsVintoLivello_AppenaIniziata() {
        assertFalse(partitaAppenaIniziata.isVintoLivello());
    }

	@Test
    public void testIsVintoLivello_Giusto() {
        assertTrue(partitaVinta.isVintoLivello());
    }

	@Test
    public void testIsVintoLivello_Persa() {
        assertFalse(partitaZeroCfu.isVintoLivello());
    }

	@Test
	public void testIsFinita_NonFinita() {
        assertFalse(partitaAppenaIniziata.isFinitaPartita());
    }

	@Test
	public void testIsFinita_PartitaVinta() {
        assertTrue(partitaVinta.isFinitaPartita());
    }

}
