package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class ComandoVaiTest {

    public static final int ITERAZIONI = 10;
    private Partita partita;

    @Before
    public void setUp() {
        partita = new Partita();
    }

    @Test
    public void testEsegui() {
        Random random = new Random();
        for (int i = 0; i < ITERAZIONI; i++) {
            int k = random.nextInt(4);
            String[] direzioni = new String[] {"nord", "est", "sud", "ovest"};
            testEseguiGenerico(direzioni[k]);
        }
    }

    private void testEseguiGenerico(String direzione) {
        Stanza stanzaCorrente = partita.getStanzaCorrente();
        Stanza stanzaAdiacente = stanzaCorrente.getStanzaAdiacente(direzione);
        if (stanzaAdiacente == null) {
            stanzaAdiacente = stanzaCorrente;
        }
        ComandoVai comandoVai = new ComandoVai();
        comandoVai.setParametro(direzione);
        comandoVai.esegui(partita);
        assertSame(stanzaAdiacente, partita.getStanzaCorrente());
    }
}