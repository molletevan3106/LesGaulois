package personnages;

import objets.Chaudron;
import objets.Equipement;

public class Gaulois {
	private String nom;
//	private int force;
	private int force;
	private int nbtrophees=0;
	private Equipement[] trophees = new Equipement[100];
	private int effetPotion=1;
	private Village village;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	public void setVillage(Village village) {
		this.village = village;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

//	private String prendreParole() {
//		
//		return "Le gaulois " + nom + " : ";
//	
//	}
	private String prendreParole() {
	return  "Le gaulois " + nom + " : ";
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	
	
//	public void frapper(Romain romain) {
//		String nomRomain=romain.getNom();
//		System.out.println(nom+" envoie un grand coup dans la machoire de "+nomRomain);
//		romain.recevoirCoup((force*effetPotion)/3);
//		if (this.effetPotion>1) {
//			this.effetPotion-=1;
//		} else {
//			this.effetPotion=1;
//		}
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la machoire de " +romain.getNom());
		this.trophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++,nbtrophees ++) {
		this.trophees[nbtrophees] = trophees[i];
		}
		}

	public void boirePotion(int forcePotion) {
		this.effetPotion=forcePotion;
	}
	
	 public void sePresenter() {
	        if (village == null) {
	            parler("Bonjour, je m'appelle " + nom + ". Je voyage de villages en villages.");
	        } else if (village.getChef() == this) {
	            parler("Bonjour, je m'appelle " + nom + ". Je suis le chef du village " + village.getNom() + ".");
	        } else {
	            parler("Bonjour, je m'appelle " + nom + ". J'habite le village " + village.getNom() + ".");
	        }
	    }
	public void faireUneDonnation(Musee musee) {
		if (nbtrophees>0) {
			System.out.println("Le gaulois "+nom+" : « Je donne au musee tous mes trophees :");
			for (int i = 0; i <nbtrophees; i++) {
				System.out.println("- "+trophees[i]);
				musee.donnerTrophees(this, trophees[i]);
			}
			System.out.println("»");
		}
		nbtrophees=0;
	}
	
	public static void main(String[] args) {
		Gaulois asterix= new Gaulois("Asterix",8);
		System.out.println(asterix);
		
	}
	
	
}

