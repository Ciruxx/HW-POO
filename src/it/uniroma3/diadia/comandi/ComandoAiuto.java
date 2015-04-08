package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando { // TODO Controllare
	
	private static String[] elencoComandi = { "vai", "posa", "prendi", "borsa",
		"aiuto", "fine", "guarda" }; // TODO è orribile: ridondanza del codice

	@Override
	public void esegui(Partita partita) {
		for (int i = 0; i < elencoComandi.length; i++)
			System.out.print(elencoComandi[i] + " ");
		System.out.println();
	}

	@Override
	public void setParametro(String parametro) {}

}
