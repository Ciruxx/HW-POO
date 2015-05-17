package it.uniroma3.diadia.attrezzi;

import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Una semplice classe che modella un attrezzo. Gli attrezzi possono trovarsi
 * all'interno delle stanze del labirinto. Ogni attrezzo ha un nome ed un peso.
 * 
 * @author Paolo Merialdo
 * @see Stanza
 * @version 0.1
 * 
 */
public class Attrezzo {
	private String nome;
	private int peso;

	/**
	 * Crea un attrezzo
	 * 
	 * @param nome
	 *            il nome che identifica l'attrezzo
	 * @param peso
	 *            il peso dell'attrezzo
	 */
	public Attrezzo(String nome, int peso) {
		this.peso = peso;
		this.nome = nome;
	}

	/**
	 * Restituisce il nome identificatore dell'attrezzo
	 * 
	 * @return il nome identificatore dell'attrezzo
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce il peso dell'attrezzo
	 * 
	 * @return il peso dell'attrezzo
	 */
	public int getPeso() {
		return this.peso;
	}

	/**
	 * Restituisce una rappresentazione stringa di questo attrezzo
	 * 
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		return this.getNome() + " (" + this.getPeso() + "kg)";
	}

    @Override
    public boolean equals(Object o) { // TODO Autogenerato, controllare
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attrezzo attrezzo = (Attrezzo) o;

        if (peso != attrezzo.peso) return false;
        if (nome != null ? !nome.equals(attrezzo.nome) : attrezzo.nome != null) return false;

        return true;
    }

    @Override
    public int hashCode() { // Autogenerato, sembra buono
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + peso;
        return result;
    }
}