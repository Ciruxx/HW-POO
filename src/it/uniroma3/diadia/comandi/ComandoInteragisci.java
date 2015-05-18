package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.Personaggi.AbstractPersonaggio;

public class ComandoInteragisci implements Comando {
    private static final String MESSAGGIO_CON_CHI = "Con chi dovrei interagire?";
    private String messaggio;

    @Override
    public void esegui(Partita partita) {
        AbstractPersonaggio personaggio;
        personaggio = partita.getStanzaCorrente().getPersonaggi();
        if (personaggio != null) {
            this.messaggio = personaggio.agisci(partita);
        } else
            System.out.println(MESSAGGIO_CON_CHI);
    }

    public String getMessaggio() {
        return this.messaggio;
    }

    @Override
    public void setParametro(String parametro) {

    }


}
