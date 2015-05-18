package it.uniroma3.diadia.Personaggi;

import it.uniroma3.diadia.Partita;

/**
 * Created by cy on 18/05/15.
 */
public class Strega extends AbstractPersonaggio {
    public Strega(String nome, String presentaz) {
        super(nome, presentaz);
    }

    @Override
    public String agisci(Partita partita) {
        return null;
    }
}
