package personnages;

public class Romain {
	private String nom;
	private int force;

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

	public void recevoirCoup(int forceCoup) {
		assert force>0;
		int ancienneForce=this.force;
		this.force = this.force - forceCoup;
		assert this.force < ancienneForce;
		if (this.force < 1) {
			parler("J'abandonne !");
		} else {
			parler("Aie");
		}
		assert isInvariantVerified();
	}

	private boolean isInvariantVerified() {
		return force>=0;
	}
	public static void main(String[] args) {
		Romain minus= new Romain("Minus",6);
		System.out.println(minus.isInvariantVerified());
	}
}
