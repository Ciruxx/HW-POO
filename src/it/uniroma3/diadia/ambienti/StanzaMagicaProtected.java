package it.uniroma3.diadia.ambienti;


import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends Stanza {

    private final static int SOGLIA_MAGICA_DEFAULT = 2;
    private int sogliaMagica;

    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     *
     * @param nome il nome della stanza
     * @param sogliaMagica
     */
    public StanzaMagicaProtected(String nome, int sogliaMagica) {
        super(nome);
        this.sogliaMagica = sogliaMagica;
    }

    public StanzaMagicaProtected(String nome) {
        this(nome, SOGLIA_MAGICA_DEFAULT);
    }

    @Override
    public boolean addAttrezzo(Attrezzo attrezzo) {
        Attrezzo attrezzoDaPosare;
        if (isMagica()) {
            attrezzoDaPosare = modificaAttrezzo(attrezzo);
        } else {
            attrezzoDaPosare = attrezzo;
        }
        return super.addAttrezzo(attrezzoDaPosare);
    }

    private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
        Attrezzo attrezzoDaPosare;
        String nomeInvertito = new StringBuilder(attrezzo.getNome()).reverse().toString();
        attrezzoDaPosare = new Attrezzo(nomeInvertito, attrezzo.getPeso()*2);
        return attrezzoDaPosare;
    }

    private boolean isMagica() {
        return super.attrezzi.size() >= sogliaMagica;
    }
}
