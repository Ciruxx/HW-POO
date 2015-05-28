package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public interface Comando {

	/**
	 * esecuzione del comando
	 */
    String esegui(Partita partita);

	void setParametro(String parametro);

}
