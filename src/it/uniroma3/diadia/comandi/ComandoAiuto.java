package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando {

    private static String[] elencoComandi = {"vai", "posa", "prendi",
            "aiuto", "fine", "guarda", "interagisci"};

    @Override
    public String esegui(Partita partita) {
        StringBuilder s = new StringBuilder();
        for (String anElencoComandi : elencoComandi)
            s.append(anElencoComandi).append(" ");
        return s.toString();
    }
}