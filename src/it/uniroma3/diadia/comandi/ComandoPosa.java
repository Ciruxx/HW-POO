package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa extends AbstractComando {


	@Override
    public String esegui(Partita partita) {
        String s;
        Borsa borsa = partita.getGiocatore().getBorsa();
        Stanza stanzaCorrente = partita.getStanzaCorrente();
        if (borsa.hasAttrezzo(super.datoParametro)) {
            Attrezzo attrezzo = borsa.getAttrezzo(super.datoParametro);
            if (stanzaCorrente.addAttrezzo(attrezzo)) {
                borsa.removeAttrezzo(super.datoParametro);
                s = "Hai posato " + attrezzo.toString();
            } else {
                s = "La stanza è piena!";
            }
        } else {
            s = "Attrezzo non presente nella borsa";
        }
        return s;
    }
}
