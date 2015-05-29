package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MagoTest {

    private Mago mago;
    private Partita partita;

    @Before
    public void setUp() throws Exception {
        mago = new Mago();
        partita = new Partita(1);
    }

    @Test
    public void testAgisci() throws Exception {

    }

    @Test
    public void testRiceviRegalo() throws Exception {
        Attrezzo incudine = new Attrezzo("incudine", 20);
        mago.riceviRegalo(incudine, partita);
        Attrezzo incudineDimezzata = partita.getStanzaCorrente().getAttrezzo("incudine");
        assertNotNull(incudineDimezzata);
        assertEquals(10, incudineDimezzata.getPeso());
    }
}