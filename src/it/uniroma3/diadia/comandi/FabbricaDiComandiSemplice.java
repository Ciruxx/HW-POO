package it.uniroma3.diadia.comandi;

import java.util.Scanner;

public class FabbricaDiComandiSemplice implements FabbricaDiComandi {

	@Override
	public Comando costruisciComando(String istruzione) {
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
        Comando comando;

		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next(); // prima parola: nome del
													// comando

		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next(); // seconda parola: eventuale
												// parametro
		scannerDiParole.close();

		if (nomeComando == null)
			comando = new ComandoNonValido();

		else
			switch (nomeComando) {
			case "vai":
				comando = new ComandoVai();
				break;
			case "prendi":
				comando = new ComandoPrendi();
				break;
			case "posa":
				comando = new ComandoPosa();
				break;
			case "aiuto":
				comando = new ComandoAiuto();
				break;
			case "fine":
				comando = new ComandoFine();
				break;
			case "guarda":
				comando = new ComandoGuarda();
				break;
			default:
				comando = new ComandoNonValido();
				break;
			}

		comando.setParametro(parametro);
		return comando;
	}

}