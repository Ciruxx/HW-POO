package it.uniroma3.diadia.ambienti.labirinto;

import it.uniroma3.diadia.ambienti.Stanza;

import java.io.FileNotFoundException;


public class Labirinto {
	public boolean ultimastanza;
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;

	public Labirinto(int i) {
		try {
			CaricatoreLabirinto caricatore = new CaricatoreLabirinto(i);
			caricatore.carica();
			stanzaIniziale = caricatore.getStanzaIniziale();
			stanzaVincente = caricatore.getStanzaVincente();
			ultimastanza = caricatore.getUltimoLivello();
        } catch (FileNotFoundException | FormatoFileNonValidoException e) {
            e.printStackTrace();
		}
    }


    public Stanza getStanzaIniziale() {
		return stanzaIniziale;
	}


	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

    
    
    
    
}