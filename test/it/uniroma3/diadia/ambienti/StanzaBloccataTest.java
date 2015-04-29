package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;

public class StanzaBloccataTest {
    private StanzaBloccata stanza1;
    private Stanza stanza2;
    private Attrezzo attrezzo;

    @Before
    public void setUp() {
        stanza1 = new StanzaBloccata("StanzaConDirezioneBloccata", "nord", "AttrezzoCheSblocca");
        stanza2 = new Stanza("StanzaBloccata");
        attrezzo = new Attrezzo("AttrezzoCheSblocca", 1);
        stanza1.impostaStanzaAdiacente("nord",stanza2);
    }

    @Test
    public void testGetStanzaAdiacente_SenzaAttrezzo() {
        assertSame(stanza1, stanza1.getStanzaAdiacente("nord"));
    }

    @Test
    public void testGetStanzaAdiacente_ConAttrezzo() {
        stanza1.addAttrezzo(attrezzo);
        assertSame(stanza2, stanza1.getStanzaAdiacente("nord"));
    }
}