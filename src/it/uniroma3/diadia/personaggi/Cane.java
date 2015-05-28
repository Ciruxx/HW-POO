package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Created by cy on 18/05/15.
 */
public class Cane extends AbstractPersonaggio {

    public Cane(String nome, String presentaz) {
        super(nome, presentaz);
    }

    @Override
    public String agisci(Partita partita) {
        partita.getGiocatore().decrementaCfu();

        return "Ti ha morso! I CFU diminuiscono..." + partita.getGiocatore().getCfu();
    }

    @Override
    public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
        String msg;
        if (attrezzo.getNome().equals("osso")) {
            Attrezzo attrezzoInRegalo = new Attrezzo("Chiave", 2);
            partita.getStanzaCorrente().addAttrezzo(attrezzoInRegalo);
            msg = "Ehi! Il cane ha lasciato cadere qualcosa!";
        } else {
            msg = "L'ha gettato a terra..";
        }
        return msg;
    }
}
