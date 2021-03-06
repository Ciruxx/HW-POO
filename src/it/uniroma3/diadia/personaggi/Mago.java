package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio { // TODO controllare se era da salutare
    private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, " +
            "con una mia magica azione, troverai un nuovo oggetto " +
            "per il tuo bel borsone!";
    private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho piu' nulla...";
    private Attrezzo attrezzo;

    public Mago() {
        this("Mago Merlino", "Sono il mago più buono di tutti i tempi, o forse no?", new Attrezzo("bacchetta", 1));
    }

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

    @Override
    public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
        Attrezzo attrezzoDimezzato = new Attrezzo(attrezzo.getNome(), attrezzo.getPeso() / 2);
        partita.getStanzaCorrente().addAttrezzo(attrezzoDimezzato);
        return "La tua bontà verrà premiata!";
    }
}
