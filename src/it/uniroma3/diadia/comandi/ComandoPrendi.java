package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendi implements Comando { // TODO Controllare

	private String nomeAttrezzo;

	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Borsa borsa = partita.getGiocatore().getBorsa();
		if (stanzaCorrente.hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzo = stanzaCorrente.getAttrezzo(nomeAttrezzo);
			if (borsa.addAttrezzo(attrezzo)) {
				stanzaCorrente.removeAttrezzo(attrezzo);
				System.out.println("Hai preso " + attrezzo.toString());
			} else {
				System.out.println("La borsa è piena!");
			}
		} else {
			System.out.println("Attrezzo non presente nella stanza");
		}
	}

	@Override
	public void setParametro(String parametro) {
		nomeAttrezzo = parametro;
	}

}
