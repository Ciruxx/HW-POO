package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import java.util.Random;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

import org.junit.Before;
import org.junit.Test;

public class ComandoVaiTest {
	
	private static final int ITERAZIONI = 10;
	private Partita partita;

	@Before
	public void setUp() throws Exception {
		partita = new Partita();
	}

	@Test
	public void testEsegui() {
		String[] direzioni = new String[] {"nord", "sud", "est", "ovest"};
		Random r = new Random();
		for (int i=0; i<ITERAZIONI; i++) {
			testEseguiGenerico(direzioni[r.nextInt(4)]);
		}
	}
	
	private void testEseguiGenerico(String direzione) {
		Stanza stanzaSeguente = partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (stanzaSeguente == null) stanzaSeguente = partita.getStanzaCorrente();
		ComandoVai vai = new ComandoVai();
		vai.setParametro(direzione);
		vai.esegui(partita);
		assertSame(stanzaSeguente, partita.getStanzaCorrente());
	}

}
