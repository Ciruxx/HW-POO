package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends AbstractComando {

	@Override
    public String esegui(Partita partita) {
        Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza;
        if (getParametro() == null) {
            return "Dove vuoi andare? Devi specificare una direzione";
		}
        prossimaStanza = stanzaCorrente.getStanzaAdiacente(getParametro());
        if (prossimaStanza == null) {
			return "Direzione inesistente";
		}
		partita.setStanzaCorrente(prossimaStanza);
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
		return partita.getStanzaCorrente().getDescrizione() + "\n" + "CFU rimanenti: " + partita.getGiocatore().getCfu();

	}
}
