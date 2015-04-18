package it.uniroma3.diadia.ambienti;

/**
 * Created by Ciro on 18/04/2015.
 */
public class StanzaBloccata extends Stanza {
    private String direzioneBloccata;
    private String attrezzo;

    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     *
     * @param nome              il nome della stanza
     * @param direzioneBloccata
     * @param attrezzo
     */
    public StanzaBloccata(String nome, String direzioneBloccata, String attrezzo) {
        super(nome);
        this.direzioneBloccata = direzioneBloccata;
        this.attrezzo = attrezzo;
    }

    @Override
    public Stanza getStanzaAdiacente(String direzione) {
        if (direzione.equals(direzioneBloccata)&&!hasAttrezzo(attrezzo)){
                System.out.println("Non hai " + attrezzo + ", non puoi andare in questa direzione!");
            return this;
            }
        return super.getStanzaAdiacente(direzione);
    }

}

