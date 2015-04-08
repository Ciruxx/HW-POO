package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando { // TODO Controllare

	@Override
	public void esegui(Partita partita) {
		System.out.println("Game Over!\nGrazie di aver giocato!");
		partita.setFinita();
	}

	@Override
	public void setParametro(String parametro) {
	}

}
