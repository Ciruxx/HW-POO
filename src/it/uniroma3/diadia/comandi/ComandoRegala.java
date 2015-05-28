package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

/**
 * Created by Ciro on 26/05/2015.
 */
public class ComandoRegala extends AbstractComando {
    @Override
    public void esegui(Partita partita) {
        Borsa borsa = partita.getGiocatore().getBorsa();
        if (borsa.hasAttrezzo(super.datoParametro)) {
            Attrezzo attrezzo = borsa.getAttrezzo(super.datoParametro);
            riceviRegalo(attrezzo, partita);
        }
    }

    @Override
    public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
        return null;
    }
}
