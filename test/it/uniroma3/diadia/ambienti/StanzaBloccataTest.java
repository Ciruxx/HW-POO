package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import org.junit.Before;
import org.junit.Test;

import java.lang.String;

import static org.junit.Assert.*;

/**
 * Created by Ciro on 19/04/2015.
 */
public class StanzaBloccataTest {
    public static final String NO_ATTREZZO= "Non hai AttrezzoCheSblocca, non puoi andare in questa direzione!"
    private StanzaBloccata stanza1;
    private Stanza stanza2;
    private Attrezzo attrezzo;

    @Before
    public void setUp() throws Exception {
        stanza1 = new StanzaBloccata("StanzaConDirezioneBloccata", "nord", "AttrezzoCheSblocca");
        stanza2 = new Stanza("StanzaBloccata");
        attrezzo = new Attrezzo("AttrezzoCheSblocca", 1);
        stanza1.impostaStanzaAdiacente("nord",stanza2);
    }

    @Test
    public void testGetStanzaAdiacente()_SenzaAttrezzo throws Exception {
      assertSame(NO_ATTREZZO, stanza1.getStanzaAdiacente("nord"));
    }

    @Test
    public void testGetStanzaAdiacente()_ConAttrezzo throws Exception {
        stanza1.addAttrezzo(attrezzo);
        assertSame(stanza2.getNome(), stanza1.getStanzaAdiacente("nord").getNome());
    }
}