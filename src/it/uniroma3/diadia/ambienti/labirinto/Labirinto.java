package it.uniroma3.diadia.ambienti.labirinto;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;

import java.io.FileNotFoundException;


public class Labirinto {
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;

	public Labirinto() {
		try {
			CaricatoreLabirinto caricatore = new CaricatoreLabirinto("Livello1");
			caricatore.carica();
			stanzaIniziale = caricatore.getStanzaIniziale();
			stanzaVincente = caricatore.getStanzaVincente();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (FormatoFileNonValidoException e) {
			e.printStackTrace();
		}
	}
	
	/**
     * Crea tutte le stanze e le porte di collegamento
     */
    private void creaStanze() {

		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo chiave = new Attrezzo("chiave",2);
        Attrezzo bacchetta = new Attrezzo("bacchetta", 4);

//        Crea i personaggi
        Strega magò = new Strega("Magò", "Sono la cattiva e terribile MAGA MAGO'!");
        Cane cane = new Cane("Fuffy", "Grrr");
        Mago merlino = new Mago("Merlino", "Sono un mago!", bacchetta);

		/* crea stanze del labirinto */
		StanzaBloccata atrio = new StanzaBloccata("Atrio","nord","chiave");
		StanzaBuia aulaN11 = new StanzaBuia("Aula N11", "est", "lanterna");
		StanzaMagica aulaN10 = new StanzaMagica("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");

		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		laboratorio.addAttrezzo(chiave);

//        Inserisce i personaggi nelle stanze
        aulaN11.setPersonaggio(magò);
        laboratorio.setPersonaggio(cane);
        atrio.setPersonaggio(merlino);

		// il gioco comincia nell'atrio
        stanzaIniziale = atrio;  
		stanzaVincente = biblioteca;
    }
    
    
    public Stanza getStanzaIniziale() {
		return stanzaIniziale;
	}


	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

    
    
    
    
}