package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ComandoPrendiTest {

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

    private void eseguiPrendi() {
        ComandoPrendi comando = new ComandoPrendi();
        comando.setParametro(NOME_ATTREZZO);
        comando.esegui(partita);
    }

    @Test
    public void testEsegui_NonEsistente() {
        eseguiPrendi();
        assertFalse(stanza.hasAttrezzo(NOME_ATTREZZO));
        assertFalse(borsa.hasAttrezzo(NOME_ATTREZZO));
    }

    @Test
    public void testEsegui_Esistente() {
        stanza.addAttrezzo(new Attrezzo(NOME_ATTREZZO, 1));
        eseguiPrendi();
        assertFalse(stanza.hasAttrezzo(NOME_ATTREZZO));
        assertTrue(borsa.hasAttrezzo(NOME_ATTREZZO));
    }

    @Test
    public void testEsegui_BorsaPiena() {
        stanza.addAttrezzo(new Attrezzo(NOME_ATTREZZO, 99999999));
        eseguiPrendi();
        assertTrue(stanza.hasAttrezzo(NOME_ATTREZZO));
        assertFalse(borsa.hasAttrezzo(NOME_ATTREZZO));
    }
}