package it.uniroma3.diadia.Personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {
    private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, " +
            "con una mia magica azione, troverai un nuovo oggetto " +
            "per il tuo bel borsone!";
    private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho piu' nulla...";
    private Attrezzo attrezzo;

    public Mago(String nome, String presentazione, Attrezzo attrezzo) {
        super(nome, presentazione);
        this.attrezzo = attrezzo;
    }

    @Override
    public String agisci(Partita partita) {
        String msg;
        if (attrezzo != null) {
            partita.getStanzaCorrente().addAttrezzo(attrezzo);
            this.attrezzo = null;
            msg = MESSAGGIO_DONO;
        } else {
            msg = MESSAGGIO_SCUSE;
        }
        return msg;
    }
}
