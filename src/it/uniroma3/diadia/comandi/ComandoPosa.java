package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa implements Comando {

	private String nomeAttrezzo;

	@Override
	public void esegui(Partita partita) {
		Borsa borsa = partita.getGiocatore().getBorsa();
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		if (borsa.hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzo = borsa.getAttrezzo(nomeAttrezzo);
			if (stanzaCorrente.addAttrezzo(attrezzo)) {
				borsa.removeAttrezzo(nomeAttrezzo);
				System.out.println("Hai posato " + attrezzo.toString());
			} else {
				System.out.println("La stanza è piena!");
			}
		} else {
			System.out.println("Attrezzo non presente nella borsa");
		}
	}

	@Override
	public void setParametro(String parametro) {
		nomeAttrezzo = parametro;
	}

}
