package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AbstractComandoTest {

    @Test
    public void testSetParametro() throws Exception {
        AbstractComando abstractComando = new AbstractComando() {
            @Override
            public String esegui(Partita partita) {
                return null;
            }
        };

        abstractComando.setParametro("parametro");
        assertEquals("parametro", abstractComando.getParametro());
    }
}