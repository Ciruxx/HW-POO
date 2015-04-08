package it.uniroma3.diadia.giocatore;
import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

import org.junit.Before;
import org.junit.Test;


public class BorsaTest {
	private Attrezzo attrezzoPeso1;
	private Attrezzo attrezzoPeso3;
	private Borsa borsaPeso5;
	private Borsa borsaPeso2;


	@Before
	public void setUp() throws Exception {
		attrezzoPeso1 = new Attrezzo("Chiodo", 1);
		attrezzoPeso3 = new Attrezzo("Forbici", 3);
		borsaPeso5 = new Borsa(5);
		borsaPeso2 = new Borsa(2);

	}

	@Test
	public void testAddAttrezzo() {
		assertTrue(borsaPeso2.addAttrezzo(attrezzoPeso1));
		assertFalse(borsaPeso2.addAttrezzo(attrezzoPeso3));
	}

	@Test
	public void testGetAttrezzoBorsaVuota() {
		assertNull(borsaPeso5.getAttrezzo("AttrezzoNonEsistente"));
	}
	
	@Test
	public void testGetAttrezzoBorsaPienaAttrezzoGiusto() {
		borsaPeso5.addAttrezzo(attrezzoPeso1);
		assertSame(attrezzoPeso1, borsaPeso5.getAttrezzo(attrezzoPeso1.getNome()));
	}
	
	@Test
	public void testGetAttrezzoBorsaPienaAttrezzoSbagliato() {
		borsaPeso5.addAttrezzo(attrezzoPeso1);
		assertNull(borsaPeso5.getAttrezzo("AttrezzoNonEsistente"));
	}

	@Test
	public void testGetPeso() {
		borsaPeso5.addAttrezzo(attrezzoPeso1);
		borsaPeso5.addAttrezzo(attrezzoPeso3);
		assertEquals(4, borsaPeso5.getPeso());
	}

	@Test
	public void testHasAttrezzoBorsaVuota() {
		assertFalse(borsaPeso2.hasAttrezzo("AttrezzoNonEsistente"));
	}
	
	@Test
	public void testHasAttrezzoBorsaPienaAttrezzoGiusto() {
		borsaPeso2.addAttrezzo(attrezzoPeso1);
		
		assertTrue(borsaPeso2.hasAttrezzo(attrezzoPeso1.getNome()));
	}

	
	@Test
	public void testHasAttrezzoBorsaPienaAttrezzoSbagliato() {
		borsaPeso2.addAttrezzo(attrezzoPeso1);
		
		assertFalse(borsaPeso2.hasAttrezzo("AttrezzoNonEsistente"));
	}


	@Test
	public void testRemoveAttrezzo() {
		Borsa b = new Borsa(10);
		Attrezzo libro = new Attrezzo("Libro", 2);
		Attrezzo penna = new Attrezzo("Penna", 1);
		b.addAttrezzo(libro);
		b.addAttrezzo(penna);
		b.removeAttrezzo("Libro");
		assertFalse(b.hasAttrezzo("Libro"));
		assertTrue(b.hasAttrezzo("Penna"));
	}
	
	@Test
	public void testRemoveAttrezzoBorsaVuota(){
		assertNull(borsaPeso2.removeAttrezzo("AttrezzoCheNonEsiste"));
	}

}
