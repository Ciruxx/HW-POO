package it.uniroma3.diadia.giocatore;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class GiocatoreTest {

	@Test
	public void testDecrementaCfu() {
		Giocatore giocatore = new Giocatore();
		giocatore.decrementaCfu();
		assertEquals(9, giocatore.getCfu());
	}

}
