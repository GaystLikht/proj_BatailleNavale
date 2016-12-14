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

	int l=0;
		if (this.debut.getLigne() == this.fin.getLigne()) {
			l=this.fin.getColonne()-this.debut.getColonne();
			return "Navire(" + this.debut + "," + (l) + "Horizontal)";
			
		}
		
		else{
			 l=this.fin.getLigne()-this.debut.getLigne();
			return  "Navire(" + this.debut + "," +l+ "," + "Vertical)";
			
		}}
 // return s+s1;
	//}
//////////////////////// contient 
	public boolean contient(Coordonnee c) {
		
		if ((c.getLigne()<debut.getLigne())||(c.getLigne()>fin.getLigne())||(c.getColonne()>fin.getColonne())||(c.getColonne()<debut.getColonne()) ) {
			return false ;

		} else {

			return true;

		}

		
	}
	//////////////////////////////////////////////
	
	public boolean touche(Navire n){
		
		if((n.fin.getLigne()==this.debut.getLigne()-1)||(n.debut.getLigne()==this.fin.getLigne()+1)||(n.fin.getColonne()==this.debut.getColonne()-1)||(n.debut.getColonne()==this.fin.getColonne()+1))
		{return true;
		}else {return false ;}
	}
////////////////////////////////
public boolean chevauche(Navire n){
		
		
		if (((fin.getLigne() - n.debut.getLigne())>=0)||((fin.getColonne() - n.debut.getColonne())>=0)) {
			return true;
		}
		
		else{
			return false;
			
		}
		
	}
	//////////////////recoitTir//////////////////////
	
public boolean recoitTir(Coordonnee c){
	
	
	if(!this.contient(c)&&(!estTouche( c))){
		
		
		return true;
	}else {
		partiesTouchees[nbTouchees]=c;
		nbTouchees++;
		return false;}
	
}	

	public boolean estTouche(Coordonnee c) {
		boolean res = false;
		for (int i = 0; i <=nbTouchees ; i++) {
			if (this.contient(c)&&(partiesTouchees[i].equals(c))) {
				res=true ;break;
			}

		}
		return res;
	 }
public boolean estTouche() {
	
	return (this.nbTouchees>=1);
}
	
public boolean estCoule() {
	
	return(estTouche()&&(this.nbTouchees==partiesTouchees.length));
}


	/////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Navire n = new Navire(new Coordonnee("A6"), 4, false);
		Navire n1 = new Navire(new Coordonnee("B6"), 4, false);
		//Coordonnee C5=new Coordonnee("A9");

		System.out.println(n);
		//n.contient(new Coordonnee("B5"));
		System.out.println(n.contient(new Coordonnee("B3")));
      //System.out.println(n.touche(new Navire (new Coordonnee("D6"),4,true)));
		System.out.println(n.recoitTir(new Coordonnee("M6")));
		System.out.println(n.estTouche(new Coordonnee("A6")));

		//System.out.println(n.chevauche(n1));
		
		
      
      
      
	}

}
