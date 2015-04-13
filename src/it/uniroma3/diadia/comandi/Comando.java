package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public interface Comando {

	/**
	 * esecuzione del comando
	 */
	public void esegui(Partita partita);

	public void setParametro(String parametro);

}