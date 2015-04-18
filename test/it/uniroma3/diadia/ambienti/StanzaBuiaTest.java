package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StanzaBuiaTest {

    public static final String NOME_ATTREZZO_LUMINOSO = "lampadina";
    private StanzaBuia stanzaBuia;

    @Before
    public void setUp() throws Exception {
        stanzaBuia = new StanzaBuia("stanza", NOME_ATTREZZO_LUMINOSO);
    }

    @Test
    public void testGetDescrizione_Buia() throws Exception {
        assertEquals(StanzaBuia.DESCRIZIONE_BUIO, stanzaBuia.getDescrizione());
    }

    @Test
    public void testGetDescrizione_Luminosa() throws Exception {
        stanzaBuia.addAttrezzo(new Attrezzo(NOME_ATTREZZO_LUMINOSO, 1));
        assertNotEquals(StanzaBuia.DESCRIZIONE_BUIO, stanzaBuia.getDescrizione());
    }
}