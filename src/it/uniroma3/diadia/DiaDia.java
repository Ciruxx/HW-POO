package it.uniroma3.diadia;

//import it.uniroma3.diadia.ambienti.Stanza;
//import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandisemplice;
//import it.uniroma3.diadia.giocatore.Borsa;

import java.util.Scanner;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 * 
 * Questa e' la classe principale crea e istanzia tutte le altre
 * 
 * @author Paolo Merialdo (da un'idea di Michael Kolling and David J. Barnes) *
 * @version 0.1
 */

public class DiaDia {
	private Partita partita;
	private static final String MESSAGGIO_BENVENUTO = "Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n"
			+ "Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"
			+ "I locali sono popolati da strani personaggi, "
			+ "alcuni amici, altri... chissa!\n"
			+ "Ci sono attrezzi che potrebbero servirti nell'impresa:\n"
			+ "puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n"
			+ "o regalarli se pensi che possano ingraziarti qualcuno.\n\n"
			+ "Per conoscere le istruzioni usa il comando 'aiuto'.";
	//private static String[] elencoComandi = { "vai", "posa", "prendi", "borsa", "aiuto",
		//	"fine" };

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione;
		Scanner scannerDiLinee;

		System.out.println(MESSAGGIO_BENVENUTO);
		scannerDiLinee = new Scanner(System.in);
		do
			istruzione = scannerDiLinee.nextLine();
		while (!processaIstruzione(istruzione));

		scannerDiLinee.close();
	}

	/**
	 * Processa una istruzione
	 * 
	 * @return true se l'istruzione e' eseguita e il gioco continua, false
	 *         altrimenti
	 */
	/*private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		if (comandoDaEseguire.getNome() == null) {
			System.out.println("Comando sconosciuto");
		} else {
			switch (comandoDaEseguire.getNome()) {
			case "fine":
				this.fine();
				return true;
			case "vai":
				this.vai(comandoDaEseguire.getParametro());
				break;
			case "aiuto":
				this.aiuto();
				break;
			case "prendi":
				this.prendi(comandoDaEseguire.getParametro());
				break;
			case "posa":
				this.posa(comandoDaEseguire.getParametro());
				break;
			case "borsa":
				System.out.println(this.borsa());
				break;
			default:
				System.out.println("Comando sconosciuto");
			}
		}
		if (this.partita.isVinta()) {
			System.out.println("Hai vinto!");
			return true;
		} else if (this.partita.isFinita()) {
			this.fine();
			return true;
		} else
			return false;
			*/
	private boolean processaIstruzione(String istruzione) {  
	Comando comandoDaEseguire;   
	FabbricaDiComandisemplice factory = new FabbricaDiComandisemplice();  
	 comandoDaEseguire = factory.costruisciComando(istruzione);  
	 if(comandoDaEseguire!=null)
	 comandoDaEseguire.esegui(this.partita);   
	 if (this.partita.isVinta()) {
			System.out.println("Hai vinto!");
			return true;
		} else if (this.partita.isFinita()) {
			this.fine();
			return true;
		} else
			return false;

	}


	// implementazioni dei comandi dell'utente:

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra e ne stampa
	 * il nome, altrimenti stampa un messaggio di errore
	 */
	/*private void vai(String direzione) {
		if (direzione == null)
			System.out.println("Dove vuoi andare?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(
				direzione);
		if (prossimaStanza == null)
			System.out.println("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			this.partita.getGiocatore().decrementaCfu();
		}
		System.out.println(partita.getStanzaCorrente().getDescrizione());
	}

	public void prendi(String nomeAttrezzo) {
		Stanza stanzaCorrente = this.partita.getStanzaCorrente();
		Borsa borsa = partita.getGiocatore().getBorsa();
		if (stanzaCorrente.hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzo = stanzaCorrente.getAttrezzo(nomeAttrezzo);
			if (borsa.addAttrezzo(attrezzo)) {
				stanzaCorrente.removeAttrezzo(attrezzo);
				System.out.println("Hai preso " + attrezzo.toString());
			} else {
				System.out.println("La borsa è piena!");
			}
		} else {
			System.out.println("Attrezzo non presente nella stanza");
		}
	}

	public void posa(String nomeAttrezzo) {
		Borsa borsa = partita.getGiocatore().getBorsa();
		Stanza stanzaCorrente = this.partita.getStanzaCorrente();
		if (borsa.hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzo = borsa.getAttrezzo(nomeAttrezzo);
			if (stanzaCorrente.addAttrezzo(attrezzo)) {
				borsa.removeAttrezzo(nomeAttrezzo);
				System.out.println("Hai posato " + attrezzo.toString());
			} else {
				System.out.println("La stanza è piena!");
			}
		} else {
			System.out.println("Attrezzo non presente nella borsa");
		}
	}
*/
	public void fine(){
		System.out.println("Game Over!\nGrazie di aver giocato!");
		}
	
	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}

}