package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoRegala extends AbstractComando { // TODO da finire
    @Override
    public String esegui(Partita partita) {
        Borsa borsa = partita.getGiocatore().getBorsa();
        if (borsa.hasAttrezzo(getParametro())) {
            Attrezzo attrezzo = borsa.getAttrezzo(getParametro());
            partita.getStanzaCorrente().getPersonaggio().riceviRegalo(attrezzo, partita);
        }
        return null;
    }
}
