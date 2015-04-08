package it.uniroma3.diadia.attrezzi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AttrezzoTest {
	
	Attrezzo attrezzo;
	
	@Before
	public void setUp() throws Exception {
		this.attrezzo = new Attrezzo("Martello", 3);
	}

	@Test
	public void testGetNome() {
		assertEquals("Martello", this.attrezzo.getNome());
	}

	@Test
	public void testGetPeso() {
		assertEquals(3, this.attrezzo.getPeso());
	}

	@Test
	public void testToString() {
		assertEquals("Martello (3kg)", this.attrezzo.toString());
	}

}
