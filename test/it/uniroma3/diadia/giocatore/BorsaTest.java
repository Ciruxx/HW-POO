package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BorsaTest {
	private Attrezzo attrezzoPeso1;
	private Attrezzo attrezzoPeso3;
	private Borsa borsaPeso5;
	private Borsa borsaPeso2;

	@Before
    public void setUp() {
        attrezzoPeso1 = new Attrezzo("Chiodo", 1);
		attrezzoPeso3 = new Attrezzo("Forbici", 3);
		borsaPeso5 = new Borsa(5);
		borsaPeso2 = new Borsa(2);

	}

	@Test
	public void testAddAttrezzo_Possibile() {
		assertTrue(borsaPeso2.addAttrezzo(attrezzoPeso1));
	}

	@Test
	public void testAddAttrezzo_Piena() {
		assertFalse(borsaPeso2.addAttrezzo(attrezzoPeso3));
	}

	@Test
	public void testGetAttrezzo_BorsaVuota() {
		assertNull(borsaPeso5.getAttrezzo("AttrezzoNonEsistente"));
	}

	@Test
	public void testGetAttrezzo_BorsaPienaAttrezzoGiusto() {
		borsaPeso5.addAttrezzo(attrezzoPeso1);
		assertSame(attrezzoPeso1,
				borsaPeso5.getAttrezzo(attrezzoPeso1.getNome()));
	}

	@Test
	public void testGetAttrezzo_BorsaPienaAttrezzoSbagliato() {
		borsaPeso5.addAttrezzo(attrezzoPeso1);
		assertNull(borsaPeso5.getAttrezzo("AttrezzoNonEsistente"));
	}

	@Test
    public void testGetPeso_Vuota() {
        assertEquals(0, borsaPeso2.getPeso());
	}

	@Test
	public void testGetPeso_Piena() {
		borsaPeso5.addAttrezzo(attrezzoPeso1);
		borsaPeso5.addAttrezzo(attrezzoPeso3);
		assertEquals(4, borsaPeso5.getPeso());
	}

	@Test
	public void testHasAttrezzo_BorsaVuota() {
		assertFalse(borsaPeso2.hasAttrezzo("AttrezzoNonEsistente"));
	}

	@Test
	public void testHasAttrezzo_BorsaPienaAttrezzoGiusto() {
		borsaPeso2.addAttrezzo(attrezzoPeso1);
		assertTrue(borsaPeso2.hasAttrezzo(attrezzoPeso1.getNome()));
	}

	@Test
	public void testHasAttrezzo_BorsaPienaAttrezzoSbagliato() {
		borsaPeso2.addAttrezzo(attrezzoPeso1);
		assertFalse(borsaPeso2.hasAttrezzo("AttrezzoNonEsistente"));
	}

	@Test
	public void testRemoveAttrezzo_Vuota() {
		assertNull(borsaPeso2.removeAttrezzo("Attrezzo"));
	}

	@Test
	public void testRemoveAttrezzo_Singleton() {
		borsaPeso5.addAttrezzo(attrezzoPeso1);
		assertSame(attrezzoPeso1,
				borsaPeso5.removeAttrezzo(attrezzoPeso1.getNome()));
	}

	@Test
	public void testRemoveAttrezzo_ConPossibileBuco() {
		Borsa b = new Borsa(10);
		Attrezzo libro = new Attrezzo("Libro", 2);
		Attrezzo penna = new Attrezzo("Penna", 1);
		b.addAttrezzo(libro);
		b.addAttrezzo(penna);
		b.removeAttrezzo("Libro");
		assertFalse(b.hasAttrezzo("Libro"));
		assertTrue(b.hasAttrezzo("Penna"));
	}

}
