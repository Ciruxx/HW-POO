package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando {

	@Override
    public String esegui(Partita partita) {
        System.out.println("Game Over!\nGrazie di aver giocato!");
		partita.setFinita();
	}

}
