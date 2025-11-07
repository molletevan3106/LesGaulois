package personnages;

import java.security.PublicKey;

public class Village {
	private String nom;
	private int nbVillageois=0;
	private Gaulois[] villageois;
	private Gaulois chef;
	private Village village;
	
	public Village(int NB_VILLAGEOIS_MAX) {
		villageois=new Gaulois[NB_VILLAGEOIS_MAX];
	}
	
	
	public String getNom() {
		return nom;
	}
	
	public Gaulois getChef() {
		return chef;
	}
	
	

	public void ajouterVillageois(Gaulois gaulois) {
		if (nbVillageois<villageois.length) {
			villageois[nbVillageois]=gaulois;
			gaulois.setVillage(this); // on relie le gaulois à son village
			nbVillageois++;
		}
	}
	
	public Gaulois trouverVillageois(int numVillageois) {
	    if (numVillageois < 1 || numVillageois > nbVillageois) {
	        System.out.println("Il n'y a pas autant d'habitants dans notre village !");
	        return null;
	    }
	    return villageois[numVillageois - 1];
	}
	public void affichervillageois() {
		System.out.println("Dans le "+nom+" du chef "+chef+" vivent les légendaires gaulois :");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("- "+villageois[i].getNom());
		}
	}
	
	
	public static void main(String[] args) {
		Gaulois abraracourcix=new Gaulois("Abraracourcix", 6);
		Village village=new Village(30);
		village.nom="Village des Irréductibles";
		village.chef=abraracourcix;
		abraracourcix.setVillage(village);
		/*Gaulois gaulois=village.trouverVillageois(30);*/
		Gaulois asterix= new Gaulois("Astérix", 8);
		village.ajouterVillageois(asterix);
		/*Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);
		*/
		Gaulois obelix=new Gaulois("Obélix", 25);
		village.ajouterVillageois(obelix);
		village.affichervillageois();
		Gaulois doublePolemix=new Gaulois("DoublePolémix", 4);
		abraracourcix.sePresenter();
		asterix.sePresenter();
		doublePolemix.sePresenter();
		
	}

}