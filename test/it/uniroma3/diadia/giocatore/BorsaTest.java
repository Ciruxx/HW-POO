package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class BorsaTest {
	private Attrezzo attrezzoPeso1;
	private Attrezzo attrezzoPeso3;
    private Borsa borsaVuotaPeso5;
    private Borsa borsaVuotaPeso2;
    private Borsa borsaConOggetti;
    private Attrezzo piombo;
    private Attrezzo ps;
    private Attrezzo piuma;
    private Attrezzo libro;

    @Before
    public void setUp() {
        attrezzoPeso1 = new Attrezzo("Chiodo", 1);
		attrezzoPeso3 = new Attrezzo("Forbici", 3);
        borsaVuotaPeso5 = new Borsa(5);
        borsaVuotaPeso2 = new Borsa(2);

        piombo = new Attrezzo("piombo", 10);
        ps = new Attrezzo("ps", 5);
        piuma = new Attrezzo("piuma", 1);
        libro = new Attrezzo("libro", 5);

        borsaConOggetti = new Borsa(30);
        borsaConOggetti.addAttrezzo(piombo);
        borsaConOggetti.addAttrezzo(ps);
        borsaConOggetti.addAttrezzo(piuma);
        borsaConOggetti.addAttrezzo(libro);

	}

	@Test
	public void testAddAttrezzo_Possibile() {
        assertTrue(borsaVuotaPeso2.addAttrezzo(attrezzoPeso1));
    }

	@Test
	public void testAddAttrezzo_Piena() {
        assertFalse(borsaVuotaPeso2.addAttrezzo(attrezzoPeso3));
    }

	@Test
	public void testGetAttrezzo_BorsaVuota() {
        assertNull(borsaVuotaPeso5.getAttrezzo("AttrezzoNonEsistente"));
    }

	@Test
	public void testGetAttrezzo_BorsaPienaAttrezzoGiusto() {
        borsaVuotaPeso5.addAttrezzo(attrezzoPeso1);
        assertSame(attrezzoPeso1,
                borsaVuotaPeso5.getAttrezzo(attrezzoPeso1.getNome()));
    }

	@Test
	public void testGetAttrezzo_BorsaPienaAttrezzoSbagliato() {
        borsaVuotaPeso5.addAttrezzo(attrezzoPeso1);
        assertNull(borsaVuotaPeso5.getAttrezzo("AttrezzoNonEsistente"));
    }

	@Test
    public void testGetPeso_Vuota() {
        assertEquals(0, borsaVuotaPeso2.getPeso());
    }

	@Test
	public void testGetPeso_Piena() {
        borsaVuotaPeso5.addAttrezzo(attrezzoPeso1);
        borsaVuotaPeso5.addAttrezzo(attrezzoPeso3);
        assertEquals(4, borsaVuotaPeso5.getPeso());
    }

	@Test
	public void testHasAttrezzo_BorsaVuota() {
        assertFalse(borsaVuotaPeso2.hasAttrezzo("AttrezzoNonEsistente"));
    }

	@Test
	public void testHasAttrezzo_BorsaPienaAttrezzoGiusto() {
        borsaVuotaPeso2.addAttrezzo(attrezzoPeso1);
        assertTrue(borsaVuotaPeso2.hasAttrezzo(attrezzoPeso1.getNome()));
    }

	@Test
	public void testHasAttrezzo_BorsaPienaAttrezzoSbagliato() {
        borsaVuotaPeso2.addAttrezzo(attrezzoPeso1);
        assertFalse(borsaVuotaPeso2.hasAttrezzo("AttrezzoNonEsistente"));
    }

	@Test
	public void testRemoveAttrezzo_Vuota() {
        assertNull(borsaVuotaPeso2.removeAttrezzo("Attrezzo"));
    }

	@Test
	public void testRemoveAttrezzo_Singleton() {
        borsaVuotaPeso5.addAttrezzo(attrezzoPeso1);
        assertSame(attrezzoPeso1,
                borsaVuotaPeso5.removeAttrezzo(attrezzoPeso1.getNome()));
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

    @Test
    public void testGetContenutoOrdinatoPerPeso_Vuota() throws Exception {
        List<Attrezzo> contenutoOrdinatoPerPeso = borsaVuotaPeso2.getContenutoOrdinatoPerPeso();
        assertNotNull(contenutoOrdinatoPerPeso);
        assertEquals(0, contenutoOrdinatoPerPeso.size());
    }

    @Test
    public void testGetContenutoOrdinatoPerNome_Vuota() throws Exception {
        List<Attrezzo> contenutoOrdinatoPerNome = borsaVuotaPeso2.getContenutoOrdinatoPerNome();
        assertNotNull(contenutoOrdinatoPerNome);
        assertEquals(0, contenutoOrdinatoPerNome.size());
    }

    @Test
    public void testGetContenutoRaggruppatoPerPeso_Vuota() throws Exception {
        Map<Integer, Set<Attrezzo>> contenutoRaggruppatoPerPeso = borsaVuotaPeso2.getContenutoRaggruppatoPerPeso();
        assertNotNull(contenutoRaggruppatoPerPeso);
        assertEquals(0, contenutoRaggruppatoPerPeso.size());
    }

    @Test
    public void testGetContenutoOrdinatoPerPeso() throws Exception {
        List<Attrezzo> contenuto = borsaConOggetti.getContenutoOrdinatoPerPeso();
        assertSame(piuma, contenuto.get(0));
        assertSame(piombo, contenuto.get(3));
    }

    @Test
    public void testGetContenutoOrdinatoPerNome() throws Exception {
        List<Attrezzo> contenuto = borsaConOggetti.getContenutoOrdinatoPerNome();
        assertSame(libro, contenuto.get(0));
        assertSame(piombo, contenuto.get(1));
        assertSame(piuma, contenuto.get(2));
        assertSame(ps, contenuto.get(3));
    }

    @Test
    public void testGetContenutoRaggruppatoPerPeso() throws Exception {
        Map<Integer, Set<Attrezzo>> contenuto = borsaConOggetti.getContenutoRaggruppatoPerPeso();
        assertNotNull(contenuto.get(1));
        assertNotNull(contenuto.get(5));
        assertNotNull(contenuto.get(10));
        assertEquals(1, contenuto.get(1).size());
        assertEquals(2, contenuto.get(5).size());
        assertEquals(1, contenuto.get(10).size());
        assertTrue(contenuto.get(1).contains(piuma));
        assertTrue(contenuto.get(5).contains(libro));
        assertTrue(contenuto.get(5).contains(ps));
        assertTrue(contenuto.get(10).contains(piombo));
    }
}
