package it.uniroma3.diadia.ambienti.labirinto;

import org.junit.Test;

import java.io.StringReader;

import static org.junit.Assert.assertEquals;

public class CaricatoreLabirintoTest {

    @Test
    public void testCarica_Monolocale() throws Exception {
        StringReader stringReader = new StringReader(
                "Stanze: biblioteca\n" +
                        "Bloccate:\n" +
                        "Buie:\n" +
                        "Inizio: biblioteca\n" +
                        "Vincente: biblioteca\n" +
                        "Attrezzi: martello 10 biblioteca\n" +
                        "Uscite: \n" +
                        "UltimoLivello: false");
        CaricatoreLabirinto monolocale = new CaricatoreLabirinto(stringReader);
        monolocale.carica();
        assertEquals("biblioteca", monolocale.getStanzaIniziale().getNome());
    }

    @Test
    public void testCarica_Bilocale() throws Exception {
        StringReader stringReader = new StringReader("Stanze: biblioteca, N10\n" +
                "Bloccate:\n" +
                "Buie:\n" +
                "Inizio: N10\n" +
                "Vincente: biblioteca\n" +
                "Attrezzi: martello 10 biblioteca, pinza 2 N10\n" +
                "Uscite: biblioteca sud N10\n" +
                "UltimoLivello: false");
        CaricatoreLabirinto bilocale = new CaricatoreLabirinto(stringReader);
        bilocale.carica();
        assertEquals("N10", bilocale.getStanzaIniziale().getNome());
        assertEquals("biblioteca", bilocale.getStanzaIniziale().getStanzaAdiacente("nord").getNome());
    }
}