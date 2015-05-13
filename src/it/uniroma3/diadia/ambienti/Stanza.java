package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import java.util.*;


/**
 * Classe Stanza - una stanza in un gioco di ruolo. Una stanza e' un luogo
 * fisico nel gioco. E' collegata ad altre stanze attraverso delle uscite. Ogni
 * uscita e' associata ad una direzione.
 * 
 * @author Paolo Merialdo (a partire da un'idea di Michael Kolling e David J.
 *         Barnes)
 * @see Attrezzo
 * @version 0.1
 */

public class Stanza {
	private static final int NUMERO_MASSIMO_DIREZIONI = 4;
	private static final int NUMERO_MASSIMO_ATTREZZI = 10;
    protected int numeroAttrezzi;
    private String nome;
    //private Attrezzo[] attrezzi;
    private List<Attrezzo> attrezzi;
    //private Stanza[] stanzeAdiacenti;
    private Map<String, Stanza> stanzeAdiacenti;
    private int numeroStanzeAdiacenti;
    //private String[] direzioni;
    private List<String> direzioni;

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * 
	 * @param nome
	 *            il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		this.numeroStanzeAdiacenti = 0;
		this.numeroAttrezzi = 0;
        this.direzioni = new ArrayList<String>();
        this.stanzeAdiacenti = new HashMap<String, Stanza>();
        this.attrezzi = new LinkedList<Attrezzo>();
    }

	/**
	 * Imposta una stanza adiacente.
	 * 
	 * @param direzione
	 *            direzione in cui sara' posta la stanza adiacente.
	 * @param stanza
	 *            stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
		boolean aggiornato = false;
//        for (String a : this.direzioni)
//            if (direzione.equals(a)) {
//                //this.stanzeAdiacenti[i] = stanza;
//                this.stanzeAdiacenti.add(stanza);
//                aggiornato = true;
//            }
//		if (!aggiornato)
//			if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
//                //this.direzioni[numeroStanzeAdiacenti] = direzione;
//                //this.stanzeAdiacenti[numeroStanzeAdiacenti] = stanza;
//                this.numeroStanzeAdiacenti++;
//            }
        for (String a : this.direzioni)
            if (direzione.equals(a)) {
                this.stanzeAdiacenti.put(direzione, stanza);
                aggiornato = true;
            }
        if (!aggiornato) {
            if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
                this.numeroStanzeAdiacenti++;
            }
        }

	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * 
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		Stanza stanza = null;
//        //for (int i = 0; i < this.numeroStanzeAdiacenti; i++)
//        for (Stanza a : this.stanzeAdiacenti)
//            for (String b : this.direzioni)
//                if (b.equals(direzione))
//                    stanza = a;
        if (this.stanzeAdiacenti.containsKey(direzione))
            stanza = this.stanzeAdiacenti.get(direzione);
        return stanza;
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
    public List<Attrezzo> getAttrezzi() {
        return this.attrezzi;
    }

	/**
	 * Mette un attrezzo nella stanza.
	 * 
	 * @param attrezzo
	 *            l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
            this.attrezzi.add(attrezzo);
//			this.attrezzi[numeroAttrezzi] = attrezzo;
            this.numeroAttrezzi++;
            return true;
		} else {
			return false;
		}
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
        for (String direzione : this.direzioni) {
            if (direzione != null) {
                System.out.println("Fuck");
                s += " " + direzione;
            }
        }
        s += "\nAttrezzi nella stanza: ";
//		for (int i = 0; i < numeroAttrezzi; i++) {
//			s += attrezzi[i].toString() + " ";
//		}
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
//		for (int i = 0; i < numeroAttrezzi; i++) {
//			Attrezzo attrezzo = attrezzi[i];
//			if (attrezzo.getNome().equals(nomeAttrezzo))
//				trovato = true;
//		}
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
	 *         presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
//		for (int i = 0; i < numeroAttrezzi; i++) {
//			Attrezzo attrezzo = attrezzi[i];
//			if (attrezzo.getNome().equals(nomeAttrezzo))
//				attrezzoCercato = attrezzo;
//		}
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
        //Attrezzo[] attrezzi = this.attrezzi;
        int numeroAttrezzi = this.numeroAttrezzi;
        this.numeroAttrezzi = 0;
        //this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];

//		for (int i = 0; i < numeroAttrezzi; i++) {
//			if (attrezzi[i] == attrezzo) {
//                trovato = true;
//            }
//			else
//				addAttrezzo(attrezzi[i]);
//		}
        for (Attrezzo a : this.attrezzi) {
            if (a == attrezzo) {

                attrezzoDaRimuovere = a;
            }
        }

        return this.attrezzi.remove(attrezzoDaRimuovere);
    }

	public String[] getDirezioni() {
		String[] direzioni = new String[this.numeroStanzeAdiacenti];
        int i = 0;
//		for (int i = 0; i < this.numeroStanzeAdiacenti; i++)
//			direzioni[i] = this.direzioni[i];
        for (String a : this.direzioni) {
            direzioni[i] = a;
            i++;
        }
        return direzioni;
    }

}