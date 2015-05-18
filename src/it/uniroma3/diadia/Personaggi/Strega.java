package it.uniroma3.diadia.Personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;


/**
 * Created by cy on 18/05/15.
 */
public class Strega extends AbstractPersonaggio {
    private static final String MESSAGGIO_SALVO = "Mmh, ti sei salvato, per questo ti teletrasporterò" +
            "nella stanza con più attrezzi";

    public Strega(String nome, String presentaz) {
        super(nome, presentaz);
    }

    @Override
    public String agisci(Partita partita) {
        String msg = null;
        if (super.haSalutato()) {
            msg = MESSAGGIO_SALVO;
            Stanza stanzaTeletrasporto = partita.getStanzaCorrente().comparatoreStanze();
            partita.setStanzaCorrente(stanzaTeletrasporto);

        }
        return msg;
    }
}
