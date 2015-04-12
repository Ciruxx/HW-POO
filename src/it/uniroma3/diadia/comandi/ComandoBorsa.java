package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoBorsa implements Comando {

	@Override
	public void esegui(Partita partita) {
		System.out.println(partita.getGiocatore().getBorsa().toString());

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

}
