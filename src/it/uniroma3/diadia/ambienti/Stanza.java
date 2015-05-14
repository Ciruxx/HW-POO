package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
    protected Set<Attrezzo> attrezzi;
    private String nome;
    private Map<String, Stanza> stanzeAdiacenti;

    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     *
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.stanzeAdiacenti = new HashMap<>();
        this.attrezzi = new HashSet<>();
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
    public Set<Attrezzo> getAttrezzi() {
        return this.attrezzi;
    }

    /**
     * Mette un attrezzo nella stanza.
     *
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
        return this.attrezzi.add(attrezzo);
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
        s += "\nUscite: ";
        Set<String> direzioni = this.getDirezioni();
        for (String direzione : direzioni) {
            s += " " + direzione;
        }
        s += "\nAttrezzi nella stanza: ";
        for (Attrezzo a : this.attrezzi)
            s += a.toString() + " ";
        return s;
    }

    /**
     * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
     *
     * @return true se l'attrezzo esiste nella stanza, false altrimenti.
     */
    public boolean hasAttrezzo(String nomeAttrezzo) {
        boolean trovato;
        trovato = false;
        for (Attrezzo a : this.attrezzi)
            if (a.getNome().equals(nomeAttrezzo))
                trovato = true;
        return trovato;
    }

    /**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
     *
     * @param nomeAttrezzo
     * @return l'attrezzo presente nella stanza. null se l'attrezzo non e'
     * presente.
     */
    public Attrezzo getAttrezzo(String nomeAttrezzo) {
        Attrezzo attrezzoCercato;
        attrezzoCercato = null;
        for (Attrezzo a : this.attrezzi)
            if (a.getNome().equals(nomeAttrezzo))
                attrezzoCercato = a;
        return attrezzoCercato;
    }

    /**
     * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
     *
     * @param attrezzo
     * @return true se l'attrezzo e' stato rimosso, false altrimenti
     */
    public boolean removeAttrezzo(Attrezzo attrezzo) {
        Attrezzo attrezzoDaRimuovere = null;
        for (Attrezzo a : this.attrezzi) {
            if (a == attrezzo) {
                attrezzoDaRimuovere = a;
            }
        }
        return this.attrezzi.remove(attrezzoDaRimuovere);
    }

    public Set<String> getDirezioni() {
        return this.stanzeAdiacenti.keySet();
    }
}