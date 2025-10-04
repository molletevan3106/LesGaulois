package objets;

public class Chaudron {
	private int quantitePotion;
	private int forcePotion;
	
	public boolean resterPotion() {
		if (this.quantitePotion==0) {
			return false;
		} else {
			return true;
		}
	}

	public void remplirChaudron(int quantite, int forcePotion) {
		this.quantitePotion=quantite;
		this.forcePotion=forcePotion;
		
	}

	public int prendreLouche() {
		if (this.quantitePotion>1) {
			this.quantitePotion=-1;
		} else {
			this.quantitePotion=0;
		}
		return forcePotion;
	}
	
}
