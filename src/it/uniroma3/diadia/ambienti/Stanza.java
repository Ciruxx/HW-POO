package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.Personaggi.AbstractPersonaggio;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import java.util.*;

/**
 * Classe Stanza - una stanza in un gioco di ruolo. Una stanza e' un luogo
 * fisico nel gioco. E' collegata ad altre stanze attraverso delle uscite. Ogni
 * uscita e' associata ad una direzione.
 *
 * @author Paolo Merialdo (a partire da un'idea di Michael Kolling e David J.
 *         Barnes)
 * @version 0.1
 * @see Attrezzo
 */
public class Stanza {
    private Map<String, Attrezzo> attrezzi;
    private String nome;
    private Map<String, Stanza> stanzeAdiacenti;
    private AbstractPersonaggio personaggio = null;

    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     *
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.stanzeAdiacenti = new HashMap<>();
        this.attrezzi = new HashMap<>();
    }

    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza    stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
        this.stanzeAdiacenti.put(direzione, stanza);
    }

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     *
     * @param direzione
     */
    public Stanza getStanzaAdiacente(String direzione) {
        return this.stanzeAdiacenti.get(direzione);
    }

    /**
     * Restituisce la nome della stanza.
     *
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     *
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     *
     * @return la collezione di attrezzi nella stanza.
     */
    public Map<String, Attrezzo> getAttrezzi() {
        return this.attrezzi;
    }

    /**
     * Mette un attrezzo nella stanza.
     *
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (attrezzi.size() == 10) return false;
        this.attrezzi.put(attrezzo.getNome(), attrezzo);
        return true;
    }

    /**
     * Restituisce una rappresentazione stringa di questa stanza, stampadone la
     * descrizione, le uscite e gli eventuali attrezzi contenuti
     *
     * @return la rappresentazione stringa
     */
    public String toString() {
        String s = "";
        s += this.nome;
        s += "\nUscite:";
        Set<String> direzioni = this.getDirezioni();
        for (String direzione : direzioni) {
            s += " " + direzione;
        }
        s += "\nAttrezzi nella stanza: ";
        for (Attrezzo a : this.attrezzi.values())
            s += a.toString() + " ";
//        s += "\nPersonaggio nella stanza: ";
//        if (personaggio == null)
//            s += "Non c'è nessuno qui!" + " ";
//        else
//            s += personaggio.toString() + " ";
        return s;
    }

    /**
     * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
     *
     * @return true se l'attrezzo esiste nella stanza, false altrimenti.
     */
    public boolean hasAttrezzo(String nomeAttrezzo) {
        return getAttrezzo(nomeAttrezzo) != null;
    }

    /**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
     *
     * @param nomeAttrezzo
     * @return l'attrezzo presente nella stanza. null se l'attrezzo non e'
     * presente.
     */
    public Attrezzo getAttrezzo(String nomeAttrezzo) {
        return attrezzi.get(nomeAttrezzo);
    }

    /**
     * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
     *
     * @param attrezzo
     * @return true se l'attrezzo e' stato rimosso, false altrimenti
     */
    public boolean removeAttrezzo(Attrezzo attrezzo) {
        if (hasAttrezzo(attrezzo.getNome())) {
            this.attrezzi.remove(attrezzo.getNome());
            return true;
        }
        return false;
    }

    public Set<String> getDirezioni() {
        return this.stanzeAdiacenti.keySet();
    }

    public AbstractPersonaggio getPersonaggio() {
        return this.personaggio;
    }

    public void setPersonaggio(AbstractPersonaggio personaggio) {
        this.personaggio = personaggio;
    }

    public Stanza getStanzaConPiùAttrezzi() {
        return Collections.max(stanzeAdiacenti.values(), new ComparatoreDiStanzePerNumeroAttrezzi());
    }

    public Stanza getStanzaConMenoAttrezzi() {
        return Collections.min(stanzeAdiacenti.values(), new ComparatoreDiStanzePerNumeroAttrezzi());
    }


    private class ComparatoreDiStanzePerNumeroAttrezzi implements Comparator<Stanza> {
        @Override
        public int compare(Stanza o1, Stanza o2) {
            return o1.getAttrezzi().size() - o2.getAttrezzi().size();
        }
    }
}