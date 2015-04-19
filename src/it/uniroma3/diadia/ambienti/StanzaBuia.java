package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

    public static final String DESCRIZIONE_BUIO = "Qui c'è buio pesto!";
    private String nomeAttrezzoLuminoso;
    private String direzioneBloccata;

    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     *
     * @param nome il nome della stanza
     * @param direzioneBloccata direzione nella quale si trova la stanza buia
     * @param nomeAttrezzoLuminoso nome attrezzo presente nella stanza per poter vedere
     */
    public StanzaBuia(String nome,String direzioneBloccata, String nomeAttrezzoLuminoso) {
        super(nome);
        this.direzioneBloccata = direzioneBloccata;
        this.nomeAttrezzoLuminoso = nomeAttrezzoLuminoso;
    }

    @Override
    public String getDescrizione() {
        if (!hasAttrezzo(nomeAttrezzoLuminoso)) return DESCRIZIONE_BUIO;
        return super.getDescrizione();
    }

    @Override
    public Stanza getStanzaAdiacente(String direzione) {
        if (direzione.equals(direzioneBloccata) && !hasAttrezzo(nomeAttrezzoLuminoso))
        {
            System.out.println(getDescrizione());
            return this;
        }
        return super.getStanzaAdiacente(direzione);
    }
}
