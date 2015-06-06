package it.uniroma3.diadia;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;
import it.uniroma3.diadia.io.InterfacciaUtente;
import it.uniroma3.diadia.io.InterfacciaUtenteConsole;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 * <p/>
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author Paolo Merialdo (da un'idea di Michael Kolling and David J. Barnes) *
 * @version 0.1
 */

public class DiaDia {
    private static final String MESSAGGIO_BENVENUTO = "Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n"
            + "Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"
            + "I locali sono popolati da strani personaggi, "
            + "alcuni amici, altri... chissa!\n"
            + "Ci sono attrezzi che potrebbero servirti nell'impresa:\n"
            + "puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n"
            + "o regalarli se pensi che possano ingraziarti qualcuno.\n\n"
            + "Per conoscere le istruzioni usa il comando 'aiuto'.";
    private Partita partita;
    private InterfacciaUtente interfacciaUtente = new InterfacciaUtenteConsole();
    private int indicatoreDiLivello = 1;

    public DiaDia() {
        this.partita = new Partita(indicatoreDiLivello);
    }

    public static void main(String[] argc) {
        DiaDia gioco = new DiaDia();
        gioco.gioca();
    }

    public void gioca() {
        String istruzione;
        interfacciaUtente.mostraMessaggio(MESSAGGIO_BENVENUTO);
        do
            istruzione = interfacciaUtente.prendiIstruzione();
        while (processaIstruzione(istruzione));
    }

    /**
     * Processa una istruzione
     *
     * @return true se l'istruzione e' eseguita e il gioco continua, false
     * altrimenti
     */
    private boolean processaIstruzione(String istruzione) {
        Comando comandoDaEseguire;
        FabbricaDiComandi factory = new FabbricaDiComandiRiflessiva();
        comandoDaEseguire = factory.costruisciComando(istruzione);
        String messaggio = comandoDaEseguire.esegui(this.partita);
        interfacciaUtente.mostraMessaggio(messaggio);
        if (!this.partita.giocatoreIsVivo()) {
            interfacciaUtente.mostraMessaggio("Hai esaurito i CFU...");
        } else if (this.partita.isVintaPartita()) {
            interfacciaUtente.mostraMessaggio("HAI VINTO IL GIOCO!!!");
        } else if (this.partita.isVintoLivello()) {
            this.indicatoreDiLivello += 1;
            interfacciaUtente.mostraMessaggio("Hai vinto!\n");
            interfacciaUtente.mostraMessaggio("Livello " + indicatoreDiLivello);
            this.partita = new Partita(indicatoreDiLivello);
        }
        return !partita.isFinitaPartita();
    }

}
