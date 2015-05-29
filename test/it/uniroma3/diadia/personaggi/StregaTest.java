package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;

public class StregaTest {

    private Strega strega;
    private Partita partita;

    @Before
    public void setUp() throws Exception {
        strega = new Strega("", "");
        partita = new Partita(1);
    }

    @Test
    public void testAgisci_NonSalutata() throws Exception {
        Stanza stanzaTeletrasporto = partita.getStanzaCorrente().getStanzaConMenoAttrezzi();
        strega.agisci(partita);
        assertSame(stanzaTeletrasporto, partita.getStanzaCorrente());
    }

    @Test
    public void testAgisci_Salutata() throws Exception {
        Stanza stanzaTeletrasporto = partita.getStanzaCorrente().getStanzaConPiùAttrezzi();
        strega.saluta();
        strega.agisci(partita);
        assertSame(stanzaTeletrasporto, partita.getStanzaCorrente());
    }
}