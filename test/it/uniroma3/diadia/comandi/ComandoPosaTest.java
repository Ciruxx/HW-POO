package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ComandoPosaTest {

    public static final String NOME_ATTREZZO = "qualcosa";
    private Partita partita;
    private Borsa borsa;
    private Stanza stanza;

    @Before
    public void setUp() {
        partita = new Partita(1);
        borsa = partita.getGiocatore().getBorsa();
        stanza = partita.getStanzaCorrente();
    }

    private void eseguiPosa() {
        ComandoPosa comandoPosa = new ComandoPosa();
        comandoPosa.setParametro(NOME_ATTREZZO);
        comandoPosa.esegui(partita);
    }

    @Test
    public void testEsegui_NonEsistente() {
        eseguiPosa();
        assertFalse(stanza.hasAttrezzo(NOME_ATTREZZO));
        assertFalse(borsa.hasAttrezzo(NOME_ATTREZZO));
    }

    @Test
    public void testEsegui_Esistente() {
        borsa.addAttrezzo(new Attrezzo(NOME_ATTREZZO, 1));
        eseguiPosa();
        assertTrue(stanza.hasAttrezzo(NOME_ATTREZZO));
        assertFalse(borsa.hasAttrezzo(NOME_ATTREZZO));
    }
}