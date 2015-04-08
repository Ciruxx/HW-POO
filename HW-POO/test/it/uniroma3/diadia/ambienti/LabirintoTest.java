package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {

	Labirinto labirinto;

	@Before
	public void setUp() throws Exception {
		labirinto = new Labirinto();
	}

	@Test
	public void testGetStanzaIniziale() throws Exception {
		assertNotNull(labirinto.getStanzaIniziale());
	}

	@Test
	public void testGetStanzaVincente() throws Exception {
		assertNotNull(labirinto.getStanzaVincente());
	}

}
