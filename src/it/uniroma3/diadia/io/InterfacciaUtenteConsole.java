package it.uniroma3.diadia.io;

import java.util.Scanner;

public class InterfacciaUtenteConsole implements InterfacciaUtente {
    @Override
    public void mostraMessaggio(String messaggio) {
        System.out.println(messaggio);
    }

    @Override
    public String prendiIstruzione() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
