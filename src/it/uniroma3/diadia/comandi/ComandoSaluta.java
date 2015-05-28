package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.Personaggi.AbstractPersonaggio;

/**
 * Created by Ciro on 26/05/2015.
 */
public class ComandoSaluta extends AbstractComando {
    @Override
    public String esegui(Partita partita) {
        AbstractPersonaggio personaggio = partita.getStanzaCorrente().getPersonaggio();
        if (personaggio != null)
            return personaggio.saluta();
        else return "Non c'è nessun personaggio qui da salutare!";

    }
}
