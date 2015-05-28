package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {
	
	@Override
    public String esegui(Partita partita) {
        System.out.println(partita.getStanzaCorrente().getDescrizione());
        System.out.println(partita.getGiocatore().getBorsa().toString());
    }
}
