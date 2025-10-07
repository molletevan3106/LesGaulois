package personnages;

import java.security.PublicKey;

public class Village {
	private String nom;
	private int nbVillageois=0;
	private Gaulois[] villageois;
	private Gaulois chef;
	
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
			nbVillageois++;
		}
	}
	
	public Gaulois trouverVillageois(int numVillageois) {
		Gaulois habitant=villageois[0];
		if((numVillageois-1)>villageois.length) {
			System.out.println("Il n'y a pas autant d'habitants dans notre village!");
			return null;
		} else {
			for (int i = 0; (i < villageois.length&&(numVillageois-1)==i); i++) {
					habitant= villageois[i];
					System.out.println(habitant);
			}
			return habitant;
		}
	}
	
	Gaulois abraracourcix= new Gaulois("Abraracourcix", 6);
	
	public static void main(String[] args) {
		
		
	}

}