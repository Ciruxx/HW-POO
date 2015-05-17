package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

import java.util.*;

public class Borsa {
    public final static int DEFAULT_PESO_MAX_BORSA = 10;
    private Map<String, Attrezzo> attrezzi; // nome, Attrezzo
    private int pesoMax;

    public Borsa() {
        this(DEFAULT_PESO_MAX_BORSA);
    }

    public Borsa(int pesoMax) {
        this.pesoMax = pesoMax;
        this.attrezzi = new HashMap<>();
    }

    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
            return false;
        this.attrezzi.put(attrezzo.getNome(), attrezzo);
        return true;
    }

    public int getPesoMax() {
        return pesoMax;
    }

    public Attrezzo getAttrezzo(String nomeAttrezzo) {
        return this.attrezzi.get(nomeAttrezzo);
    }

    public int getPeso() {
        int peso = 0;
        for (Attrezzo attrezzo : this.attrezzi.values()) {
            peso += attrezzo.getPeso();
        }
        return peso;
    }

    public boolean isEmpty() {
        return this.attrezzi.isEmpty();
    }

    public boolean hasAttrezzo(String nomeAttrezzo) {
        return this.getAttrezzo(nomeAttrezzo) != null;
    }

    public Attrezzo removeAttrezzo(String nomeAttrezzo) {
        return this.attrezzi.remove(nomeAttrezzo);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        if (!this.isEmpty()) {
            s.append(String.format("Contenuto borsa (%dkg/%dkg): ", this.getPeso(), this.getPesoMax()));
            for (Attrezzo attrezzo : attrezzi.values())
                s.append(attrezzo.toString()).append(" ");
        } else s.append("Borsa vuota");
        return s.toString();
    }

    public List<Attrezzo> getContenutoOrdinatoPerPeso() {
        List<Attrezzo> listaAttrezzi = new LinkedList<>(this.attrezzi.values());
        Collections.sort(listaAttrezzi, new Comparator<Attrezzo>() {
            @Override
            public int compare(Attrezzo o1, Attrezzo o2) {
                return o1.getPeso() - o2.getPeso();
            }
        });
        return listaAttrezzi;
    }

    public List<Attrezzo> getContenutoOrdinatoPerNome() {
        List<Attrezzo> listaAttrezzi = new LinkedList<>(this.attrezzi.values());
        Collections.sort(listaAttrezzi, new Comparator<Attrezzo>() {
            @Override
            public int compare(Attrezzo o1, Attrezzo o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });
        return listaAttrezzi;
    }

    public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
        Map<Integer, Set<Attrezzo>> map = new HashMap<>();
        for (Attrezzo attrezzo : attrezzi.values()) {
            int peso = attrezzo.getPeso();
            if (!map.containsKey(peso)) map.put(peso, new HashSet<Attrezzo>());
            map.get(peso).add(attrezzo);
        }
        return map;
    }

}
