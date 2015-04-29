package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;


public class StanzaMagicaTest {
    private StanzaMagica stanzamagica;
    private Attrezzo attrezzo;

    @Before
    public void setUp() {
        stanzamagica = new StanzaMagica("StanzaDiTest", 1);
        attrezzo = new Attrezzo("abcd", 3);
        stanzamagica.addAttrezzo(attrezzo);
    }

    @Test
    public void testModificaAttrezzo() {
        stanzamagica.removeAttrezzo(attrezzo);
        stanzamagica.addAttrezzo(attrezzo);
        assertTrue(stanzamagica.hasAttrezzo("dcba"));
        assertSame(6, stanzamagica.getAttrezzo("dcba").getPeso());
    }
}