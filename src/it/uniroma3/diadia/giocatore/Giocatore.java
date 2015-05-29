package it.uniroma3.diadia.giocatore;

public class Giocatore {
	private static int CFU_INIZIALI = 8;
	private int cfu;
	private Borsa borsa = new Borsa();

	public Giocatore() {
		this.cfu = CFU_INIZIALI;
	}

	public int getCfu() {
		return cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	public void decrementaCfu() {
		this.cfu -= 1;
	}
	
	public Borsa getBorsa() {
		return borsa;
	}
	
	public boolean isVivo() {
		 return getCfu() == 0;
	}
}