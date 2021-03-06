package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoInteragisci extends AbstractComando {
    private static final String MESSAGGIO_NO_PERSONAGGIO = "Non ci sono personaggi in questa stanza";

    @Override
    public String esegui(Partita partita) {
        AbstractPersonaggio personaggio = partita.getStanzaCorrente().getPersonaggio();
        if (personaggio != null) {
            return personaggio.agisci(partita);
        } else
            return MESSAGGIO_NO_PERSONAGGIO;
    }

}
