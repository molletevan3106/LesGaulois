package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbequipement=0;
	private String texte;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
	}

	public String getNom() {
		return nom;
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
		Equipement[] equipementEjecte = null;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
		switch (force) {
		case 0:
		parler("Aïe");
		break;
		default:
		equipementEjecte = ejecterEquipement();
		parler("J'abandonne...");
		break;
		}
		return equipementEjecte;
		}
	
	private int CalculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de
		" + forceCoup;
		int resistanceEquipement = 0;
		if (!(nbEquipement == 0)) {
		texte += "\nMais heureusement, grace à mon équipement sa force est
		diminué de ";
		for (int i = 0; i < nbEquipement;) {
		if ((equipements[i] != null &&
		equipements[i].equals(Equipement.BOUCLIER)) == true) {
		resistanceEquipement += 8;
		} else {
		System.out.println("Equipement casque");
		resistanceEquipement += 5;
		}
		i++;
		}
		texte =+ resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
		}
	
		private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom.toString() + " s'envole sous
		la force du coup.");
		//TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
		if (equipements[i] == null) {
		continue;
		} else {
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
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		case 1:
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
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
		System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
		
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
