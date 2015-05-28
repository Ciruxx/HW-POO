package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Created by Ciro on 26/05/2015.
 */
public abstract class AbstractComando implements Comando {
    public String datoParametro;

    public abstract String esegui(Partita partita);

    public void setParametro(String parametro) {
        this.datoParametro = parametro;
    }


}
