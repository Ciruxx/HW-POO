package it.uniroma3.diadia.Personaggi;

import it.uniroma3.diadia.Partita;

/**
 * Created by cy on 18/05/15.
 */
public class Cane extends AbstractPersonaggio {

    public Cane(String nome, String presentaz) {
        super(nome, presentaz);
    }

    @Override
    public String agisci(Partita partita) {
        partita.getGiocatore().decrementaCfu();

        return "Ti ha morso! I CFU diminuiscono..." + partita.getGiocatore().getCfu();
    }
}
