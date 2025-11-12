package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbequipement=0;
	private String texte;
	private boolean vainqueur = true;


	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
	}

	public String getNom() {
		return nom;
	}
	

	public int getForce() {
		return force;
	}

	
	public boolean isVainqueur() {
		return vainqueur;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

//	public void recevoirCoup(int forceCoup) {
//		assert force>0;
//		int ancienneForce=this.force;
//		this.force = this.force - forceCoup;
//		assert this.force < ancienneForce;
//		if (this.force < 1) {
//			parler("J'abandonne !");
//		} else {
//			parler("Aie");
//		}
//		assert isInvariantVerified();
//	}
	public Equipement[] recevoirCoup(int forceCoup) {
	    int oldForce = force;
	    forceCoup = calculResistanceEquipement(forceCoup);
	    Equipement[] equipementEjecte = null;

	    if (forceCoup > 0) {
	        force -= forceCoup;

	        if (force > 0) {
	            parler("Aïe !");
	            vainqueur = true;
	        } else {
	            force = 0;
	            parler("J'abandonne...");
	            equipementEjecte = ejecterEquipement();
	            vainqueur = false;
	        }
	    } else {
	        // Le coup n’a aucun effet, mais on arrête le combat pour éviter l'infini
	        parler("Même pas mal !");
	        vainqueur = false; // important pour sortir de la boucle
	    }

	    assert force <= oldForce;
	    return equipementEjecte;
	}



	private int calculResistanceEquipement(int forceCoup) {
	    String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
	    int resistanceEquipement = 0;

	    for (int i = 0; i < nbequipement; i++) {
	        if (equipements[i] == Equipement.BOUCLIER) {
	            resistanceEquipement += 8;
	        } else if (equipements[i] == Equipement.CASQUE) {
	            resistanceEquipement += 5;
	        }
	    }

	    if (resistanceEquipement > 0) {
	        texte += "\nMais heureusement, grâce à mon équipement sa force est diminuée de " + resistanceEquipement + " !";
	    }

	    forceCoup -= resistanceEquipement;
	    if (forceCoup < 0) {
	        forceCoup = 0; // évite que la force augmente
	    }

	    parler(texte);
	    return forceCoup;
	}

	
		private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbequipement];
		String message ="L'équipement de " + nom.toString() + " s'envole sous la force du coup.";
		System.out.println(message);
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbequipement; i++) {
		if (equipements[i] != null) {
		equipementEjecte[nbEquipementEjecte] = equipements[i];
		nbEquipementEjecte++;
		equipements[i] = null;
		}
		}
		return equipementEjecte;
		}

	private boolean isInvariantVerified() {
		return force>=0;
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbequipement) {
		case 2:
			System.out.println("Le soldat " + nom + " est d�j� bien prot�g� !");
			break;
		case 1:
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " poss�de d�j� un " + equipement + " !");
			} else {
				ajouterEquipement(equipement);
			}
			break;
		
		case 0:
			ajouterEquipement(equipement);
			break;
			
		}
	}
		
	private void ajouterEquipement(Equipement equipement) {
		equipements[nbequipement]=equipement;
		nbequipement++;
		System.out.println("Le soldat " + nom + " s'�quipe avec un " + equipement + ".");
		
	}

	public static void main(String[] args) {
		Romain minus= new Romain("Minus",6);
		System.out.println(minus.isInvariantVerified());
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
