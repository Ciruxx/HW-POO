package it.uniroma3.diadia.io;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class InterfacciaUtenteConsoleTest {

    @Test
    public void testPrendiIstruzione() throws Exception {
        InterfacciaUtenteConsole console = new InterfacciaUtenteConsole();
        assertNotNull(console.prendiIstruzione());
    }
}