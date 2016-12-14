package batailleNavale;

//import batailleNavale.Coordonnee.java;
public class Navire {

	private Coordonnee debut;
	private Coordonnee fin;
	private Coordonnee[] partiesTouchees;
	private int nbTouchees;

	public Navire(Coordonnee debut, int longueur, boolean estVertical) {
		this.debut = debut;

		// if(fin.getColonne()==debut.getColonne()){
		// estVertical=true;
		// longueur=fin.getLigne()+debut.getLigne();
		// }else if(fin.getLigne()==debut.getLigne()){
		// estVertical=false;
		// horizontal=true;
		// longueur=fin.getColonne()+debut.getColonne();
		// }
		nbTouchees = 0;
		partiesTouchees = new Coordonnee[longueur];

		if (estVertical) {
			this.fin = new Coordonnee(debut.getLigne() + longueur, debut.getColonne());

		} else {

			this.fin = new Coordonnee(debut.getLigne(), debut.getColonne() + longueur);
		}

	}

	public Coordonnee getDebut() {
		return debut;
	}

	public Coordonnee getFin() {
		return fin;
	}

	public String toString() {

		int l = 0;
		if (this.debut.getLigne() == this.fin.getLigne()) {
			l = this.fin.getColonne() - this.debut.getColonne();
			return "Navire(" + this.debut + "," + (l) + ", Horizontal)";

		}

		else {
			l = this.fin.getLigne() - this.debut.getLigne();
			return "Navire(" + this.debut + "," + l + ", Vertical)";

		}
	}

	// return s+s1;
	// }
	//////////////////////// contient
	public boolean contient(Coordonnee c) {

		int lig = c.getLigne();
		int col = c.getColonne();
		return lig >= debut.getLigne() && lig <= fin.getLigne() && col >= debut.getColonne() && col <= fin.getColonne();
//		
//		if ((c.getLigne() < debut.getLigne()) || (c.getLigne() > fin.getLigne()) || (c.getColonne() > fin.getColonne())
//				|| (c.getColonne() < debut.getColonne())) {
//			return false;
//
//		} else {
//
//			return true;
//
//		}
//
	}

	//////////////////////////////////////////////
	public void ajouternbtouche(Coordonnee c) {
		if (this.contient(c)) {
			this.nbTouchees++;
		}

	}

	public boolean touche(Navire n) {

		if ((n.fin.getLigne() == this.debut.getLigne() - 1) || (n.debut.getLigne() == this.fin.getLigne() + 1)
				|| (n.fin.getColonne() == this.debut.getColonne() - 1)
				|| (n.debut.getColonne() == this.fin.getColonne() + 1)) {
			return true;
		} else {
			return false;
		}
	}

	////////////////////////////////
	public boolean chevauche(Navire n) {

		if (((fin.getLigne() - n.debut.getLigne()) >= 0) || ((fin.getColonne() - n.debut.getColonne()) >= 0)) {
			return true;
		}

		else {
			return false;

		}

	}
	////////////////// recoitTir//////////////////////

	public boolean recoitTir(Coordonnee c) {

		if (this.contient(c)) {
// ajouter le tir dans partiesTouchee
		
			partiesTouchees[nbTouchees]=c;
			nbTouchees++;
			return true;
		} else {

			return false;
		}

	}

	public boolean estTouche(Coordonnee c) {
		for (int i = 0; i < nbTouchees; i++)
			if ((this.partiesTouchees[i].equals(c)))
				return true;
		return false;
	}

	public boolean estTouche() {

		return (this.nbTouchees >= 1);
	}

	public boolean estCoule() {

		return (estTouche() && (this.nbTouchees == partiesTouchees.length));
	}

	/////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Navire n = new Navire(new Coordonnee("B1"), 5, false);
		// Navire n1 = new Navire(new Coordonnee("B6"), 4, false);
		// Coordonnee C5=new Coordonnee("A9");

		System.out.println(n);
		// n.contient(new Coordonnee("B5"));
		System.out.println("test de contient : " + n.contient(new Coordonnee("B1")));
		Coordonnee c = new Coordonnee("A2");
		System.out.println(c.getLigne() + ":" + c.getColonne());
		
		System.out.println(n.touche(new Navire(new Coordonnee("C2"), 4, false)));
		 System.out.println("test de recoitTir : " + n.recoitTir(new Coordonnee("E1")));
		 System.out.println("hello");
		 System.out.println(n.nbTouchees);

		 System.out.println("test de estTouche : " + n.estTouche(new Coordonnee("F1")));

//		System.out.println(n.chevauche(n1));

	}

}
