package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.io.InterfacciaUtenteConsole;

public class StanzaBloccata extends Stanza {
    private String direzioneBloccata;
    private String attrezzo;

    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     *
     * @param nome              il nome della stanza
     * @param direzioneBloccata la direzione bloccata se non è presente l'attrezzo
     * @param attrezzo          l'attrezzo che deve essere nella stanza per sbloccare la direzione
     */
    public StanzaBloccata(String nome, String direzioneBloccata, String attrezzo) {
        super(nome);
        this.direzioneBloccata = direzioneBloccata;
        this.attrezzo = attrezzo;
    }

    @Override
    public Stanza getStanzaAdiacente(String direzione) {
        if (direzione.equals(direzioneBloccata) && !hasAttrezzo(attrezzo)) {
            InterfacciaUtenteConsole.getInstance().mostraMessaggio("Non hai " + attrezzo + ", non puoi andare in questa direzione!");
            return this;
        }
        return super.getStanzaAdiacente(direzione);
    }

}

