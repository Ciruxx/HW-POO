package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendi extends AbstractComando {

	@Override
    public String esegui(Partita partita) {
        String s;
        Stanza stanzaCorrente = partita.getStanzaCorrente();
		Borsa borsa = partita.getGiocatore().getBorsa();
		if (stanzaCorrente.hasAttrezzo(super.datoParametro)) {
			Attrezzo attrezzo = stanzaCorrente.getAttrezzo(super.datoParametro);
			if (borsa.addAttrezzo(attrezzo)) {
				stanzaCorrente.removeAttrezzo(attrezzo);
                s = "Hai preso " + attrezzo.toString();
            } else {
                s = "La borsa è piena!";
            }
		} else {
            s = "Attrezzo non presente nella stanza";
        }
        return s;
    }
}
