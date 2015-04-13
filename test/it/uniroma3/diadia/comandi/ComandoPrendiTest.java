package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class ComandoPrendiTest {

	private static final String NOME_ATTREZZO = "unQualsiasiAttrezzo";
	private Partita partita;

	@Before
	public void setUp() throws Exception {
		partita = new Partita();
	}
	
	private void eseguiPrendi(Partita partita, Attrezzo attrezzo) {
		ComandoPrendi prendi = new ComandoPrendi();
		prendi.setParametro(attrezzo.getNome());
		prendi.esegui(partita);
	}

	@Test
	public void testEsegui_AttrezzoEsistente() {
		Attrezzo attrezzo = new Attrezzo(NOME_ATTREZZO, 1);
		partita.getStanzaCorrente().addAttrezzo(attrezzo);
		eseguiPrendi(partita, attrezzo);
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo(NOME_ATTREZZO));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo(NOME_ATTREZZO));
	}
	
	@Test
	public void testEsegui_AttrezzoPesante() {
		Attrezzo attrezzo = new Attrezzo(NOME_ATTREZZO, 99999999);
		partita.getStanzaCorrente().addAttrezzo(attrezzo);
		eseguiPrendi(partita, attrezzo);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo(NOME_ATTREZZO));
		assertTrue(partita.getStanzaCorrente().hasAttrezzo(NOME_ATTREZZO));
	}
	
	@Test
	public void testEsegui_AttrezzoNonEsistente() {
		Attrezzo attrezzo = new Attrezzo(NOME_ATTREZZO, 1);
		eseguiPrendi(partita, attrezzo);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo(NOME_ATTREZZO));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo(NOME_ATTREZZO));
	}

}
