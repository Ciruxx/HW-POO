package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends AbstractComando {

	@Override
    public String esegui(Partita partita) {
        Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza;
		if (super.datoParametro == null) {
			System.out.println("Dove vuoi andare? Devi specificare una direzione");
			return;
		}
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(super.datoParametro);
		if (prossimaStanza == null) {
			System.out.println("Direzione inesistente");
			return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
		System.out.println(partita.getStanzaCorrente().getDescrizione());
		System.out.println("CFU rimanenti: " + partita.getGiocatore().getCfu());
	}
}
