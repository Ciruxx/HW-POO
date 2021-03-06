package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.ambienti.labirinto.Labirinto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class LabirintoTest {

	Labirinto labirinto;

	@Before
    public void setUp() {
		labirinto = new Labirinto(1);
	}

	@Test
    public void testGetStanzaIniziale() {
        assertNotNull(labirinto.getStanzaIniziale());
	}

	@Test
    public void testGetStanzaVincente() {
        assertNotNull(labirinto.getStanzaVincente());
	}

}
