package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa extends AbstractComando {


	@Override
	public void esegui(Partita partita) {
		Borsa borsa = partita.getGiocatore().getBorsa();
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		if (borsa.hasAttrezzo(super.datoParametro)) {
			Attrezzo attrezzo = borsa.getAttrezzo(super.datoParametro);
			if (stanzaCorrente.addAttrezzo(attrezzo)) {
				borsa.removeAttrezzo(super.datoParametro);
				System.out.println("Hai posato " + attrezzo.toString());
			} else {
				System.out.println("La stanza è piena!");
			}
		} else {
			System.out.println("Attrezzo non presente nella borsa");
		}
	}
}
