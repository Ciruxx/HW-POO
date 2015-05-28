package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {

    @Override
    public String esegui(Partita partita) {
        return partita.getStanzaCorrente().getDescrizione() + "\n" + partita.getGiocatore().getBorsa().toString();
    }
}
