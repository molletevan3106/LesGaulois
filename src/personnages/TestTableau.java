package personnages;

public class TestTableau {

	public static void main(String[] args) {
		int [] tableauEntier = {1,2,3,4,5};
		String [] tableauChaines = new String[5];
		int nbChaines=0;
		tableauChaines[nbChaines]="Hello";
		nbChaines++;
		tableauChaines[nbChaines]="World";
		nbChaines++;
		tableauChaines[3]=" !";
		for (int entier : tableauEntier) {
			System.out.println(entier+" ");
		} 

		for (int i = 0; i < tableauEntier.length; i++) {
			int entier=tableauEntier[i];
			System.out.println(entier);
			if (i<tableauEntier.length-1) {
				System.out.println(", ");
			}
		}
		for (String chaine : tableauChaines) {
			System.out.println(chaine+" ");
		}
		for (int i = 0; i < tableauChaines.length; i++) {
			System.out.println(tableauChaines[i]+" ");
		}
		for (String string : tableauChaines) {
			if (string != null) {
				System.out.println(string+" ");
			}
		}
		System.out.println(tableauEntier);
		System.out.println(tableauChaines);
	}


}


