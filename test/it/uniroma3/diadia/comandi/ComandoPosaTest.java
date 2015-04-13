package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class ComandoPosaTest {

	private static final String NOME_ATTREZZO = "unQualsiasiAttrezzo";
	private Partita partita;

	@Before
	public void setUp() throws Exception {
		partita = new Partita();
	}
	
	private void eseguiPosa(Partita partita, Attrezzo attrezzo) {
		ComandoPosa posa = new ComandoPosa();
		posa.setParametro(attrezzo.getNome());
		posa.esegui(partita);
	}

	@Test
	public void testEsegui_AttrezzoEsistente() {
		Attrezzo attrezzo = new Attrezzo(NOME_ATTREZZO, 1);
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		eseguiPosa(partita, attrezzo);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo(NOME_ATTREZZO));
		assertTrue(partita.getStanzaCorrente().hasAttrezzo(NOME_ATTREZZO));
	}
	
	@Test
	public void testEsegui_AttrezzoNonEsistente() {
		Attrezzo attrezzo = new Attrezzo(NOME_ATTREZZO, 1);
		eseguiPosa(partita, attrezzo);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo(NOME_ATTREZZO));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo(NOME_ATTREZZO));
	}


}
