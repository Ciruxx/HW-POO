package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando {

    private static String[] elencoComandi = {"vai", "posa", "prendi",
            "aiuto", "fine", "guarda", "interagisci"}; // TODO è orribile: ridondanza del codice

    @Override
    public void esegui(Partita partita) {
        for (String anElencoComandi : elencoComandi)
            System.out.print(anElencoComandi + " ");
        System.out.println();
    }
}