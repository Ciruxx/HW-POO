package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.labirinto.Labirinto;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 * 
 * @author Paolo Merialdo, Valter Crescenzi (da un'idea di Michael Kolling and
 *         David J. Barnes)
 * @see Stanza
 * @version 0.1
 */

public class Partita {
    private Labirinto labirinto;
    private Stanza stanzaCorrente;
    private boolean finitaPartita;
    private Giocatore giocatore;

    public Partita(int indicatoreDiLivello) {
        this.finitaPartita = false;
        labirinto = new Labirinto(indicatoreDiLivello);
        giocatore = new Giocatore();
        stanzaCorrente = labirinto.getStanzaIniziale();
    }

    public Stanza getStanzaCorrente() {
        return this.stanzaCorrente;
    }

    public void setStanzaCorrente(Stanza stanzaCorrente) {
        this.stanzaCorrente = stanzaCorrente;
    }

    /**
     * Restituisce vero se e solo se la partita e' stata vinta
     *
     * @return vero se partita vinta
     */
    public boolean isVintoLivello() {
        return this.getStanzaCorrente() == labirinto.getStanzaVincente();
    }

    /**
     * Restituisce vero se e solo se la partita e' finita
     *
     * @return vero se partita finita
     */
    public boolean isFinitaPartita() {
        return finitaPartita || (!giocatoreIsVivo()) || isVintaPartita();
    }

    public boolean isVintaPartita() {
        return getLabirinto().ultimastanza && isVintoLivello() && giocatoreIsVivo();
    }

    /**
     * Imposta la partita come finita
     */
    public void setFinitaPartita() {
        this.finitaPartita = true;
    }

    public Giocatore getGiocatore() {
        return giocatore;
    }

    public Labirinto getLabirinto() {
        return labirinto;
    }

    public boolean giocatoreIsVivo() {
        return giocatore.isVivo();
    }

}
