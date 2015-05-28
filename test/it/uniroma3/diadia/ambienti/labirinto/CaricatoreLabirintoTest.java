package it.uniroma3.diadia.ambienti.labirinto;

import org.junit.Before;
import org.junit.Test;

import java.io.StringReader;

import static org.junit.Assert.assertEquals;

public class CaricatoreLabirintoTest {

    @Before
    public void setUp() throws Exception {
        StringReader stringReader = new StringReader("Stanze: biblioteca, N10, N11\n" +
                "Inizio: N10\n" +
                "Vincente: N11\n" +
                "Attrezzi: martello 10 biblioteca, pinza 2 N10\n" +
                "Uscite: biblioteca nord N10, biblioteca sud N11");
        CaricatoreLabirinto labirinto = new CaricatoreLabirinto(stringReader);
    }

    @Test
    public void testCarica_Monolocale() throws Exception {
        StringReader stringReader = new StringReader(
                "Stanze: biblioteca\n" +
                        "Inizio: biblioteca\n" +
                        "Vincente: biblioteca\n" +
                        "Attrezzi: martello 10 biblioteca\n" +
                        "Uscite: ");
        CaricatoreLabirinto monolocale = new CaricatoreLabirinto(stringReader);
        monolocale.carica();
        assertEquals("biblioteca", monolocale.getStanzaIniziale().getNome());
    }

    @Test
    public void testCarica_Bilocale() throws Exception {
        StringReader stringReader = new StringReader("Stanze: biblioteca, N10\n" +
                "Inizio: N10\n" +
                "Vincente: biblioteca\n" +
                "Attrezzi: martello 10 biblioteca, pinza 2 N10\n" +
                "Uscite: biblioteca nord N10, biblioteca sud N10");
        CaricatoreLabirinto monolocale = new CaricatoreLabirinto(stringReader);
        monolocale.carica();
        assertEquals("biblioteca", monolocale.getStanzaIniziale().getNome());
    }
}