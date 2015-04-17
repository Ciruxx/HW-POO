package it.uniroma3.diadia.ambienti;


import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza {

    private int contatoreAttrezziPosati;
    private int sogliaMagica;
    private final static int SOGLIA_MAGICA_DEFAULT = 2;

    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     *
     * @param nome il nome della stanza
     * @param sogliaMagica
     */
    public StanzaMagica(String nome, int sogliaMagica) {
        super(nome);
        this.sogliaMagica = sogliaMagica;
        this.contatoreAttrezziPosati = 0;
    }

    public StanzaMagica(String nome) {
        this(nome, SOGLIA_MAGICA_DEFAULT);
    }

    @Override
    public boolean addAttrezzo(Attrezzo attrezzo) {
        contatoreAttrezziPosati++;
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
        return contatoreAttrezziPosati >= sogliaMagica;
    }
}
