package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	//private Attrezzo[] attrezzi;
	private Map<String, Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		//this.attrezzi = new Attrezzo[10]; // speriamo che bastino...
		this.attrezzi = new HashMap<String, Attrezzo>();
		this.numeroAttrezzi = 0;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		//this.attrezzi.size(); <-- Forse si può usare al posto di numeroAttrezzi?
		//this.attrezzi[this.numeroAttrezzi] = attrezzo;
		return true;
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
//		Attrezzo b = null;
//		for (Attrezzo a : this.attrezzi)
//			if (a.getNome().equals(nomeAttrezzo))
//				b = a;
		return this.attrezzi.get(nomeAttrezzo);
	}

	public int getPeso() {
		int peso = 0;
		Collection<Attrezzo> listaAttrezzi = new LinkedList<>();
		for (Attrezzo attrezzo : listaAttrezzi = this.attrezzi.values()) {
			peso += attrezzo.getPeso();
		}

//		for (Attrezzo a : this.attrezzi) {
//			peso += a.getPeso();
//		}
		return peso;
	}

	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		if (isEmpty()) return null;
		//Attrezzo attrezzo = null;
//		int k = 0;
//		for (Attrezzo a : this.attrezzi) {
//			if (this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
//				attrezzo = attrezzi[i];
//				k=i;
//			}
//		}
		//for (Attrezzo a : this.attrezzi) {
		//if (a.getNome().equals((nomeAttrezzo))) {
		//	attrezzo = a;
		//}
		//}
		//this.attrezzi.remove(attrezzo);
//		attrezzi[k] = attrezzi[this.numeroAttrezzi-1];
		//this.numeroAttrezzi--;
		return this.attrezzi.remove(nomeAttrezzo);
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa (" + this.getPeso() + "kg/"
					+ this.getPesoMax() + "kg): ");
			//for (Attrezzo a : this.attrezzi)
			Collection<Attrezzo> listaAttrezzi = new LinkedList<>();
			for (Attrezzo attrezzo : listaAttrezzi = this.attrezzi.values()) {
				s.append(attrezzo.toString() + " ");
			}
		} else {
			s.append("Borsa vuota");
		}
		return s.toString();
	}
}
