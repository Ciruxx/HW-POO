package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

    public static final String DESCRIZIONE_BUIO = "Qui c'è buio pesto!";
    private String nomeAttrezzoLuminoso;

    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     *
     * @param nome il nome della stanza
     * @param nomeAttrezzoLuminoso nome attrezzo presente nella stanza per poter vedere
     */
    public StanzaBuia(String nome, String nomeAttrezzoLuminoso) {
        super(nome);
        this.nomeAttrezzoLuminoso = nomeAttrezzoLuminoso;
    }

    @Override
    public String getDescrizione() {
        if (!hasAttrezzo(nomeAttrezzoLuminoso)) return DESCRIZIONE_BUIO;
        return super.getDescrizione();
    }
}
