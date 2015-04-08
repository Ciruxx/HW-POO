package it.uniroma3.diadia.giocatore;
import static org.junit.Assert.*;
import it.uniroma3.diadia.giocatore.Giocatore;

import org.junit.Test;


public class GiocatoreTest {

	@Test
	public void testDecrementaCfu() {
		Giocatore giocatore = new Giocatore();
		giocatore.decrementaCfu();
		assertEquals(19, giocatore.getCfu());
	}

}
