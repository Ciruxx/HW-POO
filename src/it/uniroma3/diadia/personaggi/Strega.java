package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class Strega extends AbstractPersonaggio {
    public static final String MESSAGGIO_MALEDIZIONE = "Ti maledico! Che tu sia trasportato nella stanza " +
            "con meno attrezzi";
    private static final String MESSAGGIO_SALVO = "Mmh, ti sei salvato, per questo ti teletrasporterò " +
            "nella stanza con più attrezzi";

    public Strega() {
        this("Malefica", "Presto sarò sovrana di tutti i mondi");
    }

    public Strega(String nome, String presentaz) {
        super(nome, presentaz);
    }

    @Override
    public String agisci(Partita partita) {
        String msg;
        if (super.haSalutato()) {
            msg = MESSAGGIO_SALVO;
            Stanza stanzaTeletrasporto = partita.getStanzaCorrente().getStanzaConPiùAttrezzi();
            partita.setStanzaCorrente(stanzaTeletrasporto);
        } else {
            msg = MESSAGGIO_MALEDIZIONE;
            Stanza stanzaTeletrasporto = partita.getStanzaCorrente().getStanzaConMenoAttrezzi();
            partita.setStanzaCorrente(stanzaTeletrasporto);
        }
        return msg;
    }

    @Override
    public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
        return "Hahahahahaha non lo rivedrai più!!!";
    }
}
