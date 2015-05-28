package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CaneTest {

    private Cane cane;
    private Partita partita;

    @Before
    public void setUp() throws Exception {
        cane = new Cane();
        partita = new Partita(1);
    }

    @Test
    public void testAgisci() throws Exception {
        int cfu = partita.getGiocatore().getCfu();
        cane.agisci(partita);
        assertEquals(cfu - 1, partita.getGiocatore().getCfu());
    }

    @Test
    public void testRiceviRegalo_Osso() throws Exception {
        Stanza stanzaCorrente = partita.getStanzaCorrente();
        int nAttrezziInStanza = stanzaCorrente.getAttrezzi().size();
        cane.riceviRegalo(new Attrezzo("osso", 1), partita);
        assertEquals(nAttrezziInStanza + 1, stanzaCorrente.getAttrezzi().size());
    }

    @Test
    public void testRiceviRegalo_Cioccolata() throws Exception {
        Stanza stanzaCorrente = partita.getStanzaCorrente();
        int nAttrezziInStanza = stanzaCorrente.getAttrezzi().size();
        cane.riceviRegalo(new Attrezzo("cioccolata", 1), partita);
        assertEquals(nAttrezziInStanza, stanzaCorrente.getAttrezzi().size());
    }
}