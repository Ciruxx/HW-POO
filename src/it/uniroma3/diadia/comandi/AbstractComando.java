package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Created by Ciro on 26/05/2015.
 */
public abstract class AbstractComando implements Comando {
    public String datoParametro;

    public abstract void esegui(Partita partita);

    public void setParametro(String parametro) {
        this.datoParametro = parametro;
    }

    public abstract String riceviRegalo(Attrezzo attrezzo, Partita partita);

}
