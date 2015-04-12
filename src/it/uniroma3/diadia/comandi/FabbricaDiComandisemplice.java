package it.uniroma3.diadia.comandi;

import java.util.Scanner;

	public class FabbricaDiComandisemplice implements FabbricaDiComandi{  
		 public Comando costruisciComando(String istruzione) {   
			 Scanner scannerDiParole = new Scanner(istruzione);   
			 String nomeComando = null;   
			 String parametro = null;   
			 Comando comando = null;  
		  if (scannerDiParole.hasNext())    
			  nomeComando = scannerDiParole.next(); // prima parola: nome del comando   
		  if (scannerDiParole.hasNext())    
			  parametro = scannerDiParole.next();// seconda parola: eventuale parametro  
		  /*if (nomeComando == null)     
			  comando = new ComandoNonValido();   
		  else if (nomeComando.equals("vai"))    
			  comando = new ComandoVai();   
		  else if (nomeComando.equals("prendi"))    
			  comando = new ComandoPrendi();   
		  else if (nomeComando.equals("posa"))    
			  comando = new ComandoPosa();   
		  else if (nomeComando.equals("aiuto"))    
			  comando = new ComandoAiuto();   
		  else if (nomeComando.equals("fine"))    
			  comando = new ComandoFine();   
		  else if (nomeComando.equals("guarda"))    
			  comando = new ComandoGuarda();   
		  else comando = new ComandoNonValido();   
		  comando.setParametro(parametro);   
		  return comando;     
		  }*/             
		  if (nomeComando == null) {
				System.out.println("Comando sconosciuto");
			} else {
				switch (nomeComando) {
				case "fine":
					comando = new ComandoFine();
					//return true;
				case "vai":
					comando = new ComandoVai(parametro); 
					break;
				case "aiuto":
					comando = new ComandoAiuto();
					break;
				case "prendi":
					comando = new ComandoPrendi(parametro); 
					break;
				case "posa":
					 comando = new ComandoPosa(parametro);
					break;
				case "borsa":
					comando = new ComandoBorsa();
					break;
				case "guarda":
					comando = new ComandoGuarda();
					break;
				default:
					System.out.println("Comando sconosciuto");
				}
			}
		  return comando;
		 }
		 
}
