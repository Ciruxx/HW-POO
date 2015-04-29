package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;


/**
 * Created by cy on 29/04/15.
 */
public class StanzaMagicaTest {
    private StanzaMagica stanzamagica;
    private Attrezzo attrezzo;

    @Before
    public void setUp() throws Exception {
        stanzamagica = new StanzaMagica("StanzaDiTest", 1);
        attrezzo = new Attrezzo("abcd", 3);
        stanzamagica.addAttrezzo(attrezzo);
    }

    @Test
    public void testModificaAttrezzo() throws Exception {
        stanzamagica.removeAttrezzo(attrezzo);
        stanzamagica.addAttrezzo(attrezzo);
        assertTrue(stanzamagica.hasAttrezzo("dcba"));
        assertSame(6, stanzamagica.getAttrezzo("dcba").getPeso());
    }
}