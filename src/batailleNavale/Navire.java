package batailleNavale;
//import batailleNavale.Coordonnee.java;
public class Navire {

	
	private Coordonnee debut;
	private Coordonnee fin;
	private Coordonnee[] partiesTouchees;
	private int nbTouchees;
	
	
	public Navire(Coordonnee debut, int longueur, boolean estVertical) {
		this.debut=debut;
		estVertical=false;
		boolean horizontal=false;
		if(fin.getColonne()==debut.getColonne()){
			estVertical=true;
			longueur=fin.getLigne()+debut.getLigne();
		}else if(fin.getLigne()==debut.getLigne()){
			estVertical=false;
			horizontal=true;
			longueur=fin.getColonne()+debut.getColonne();
		}
		nbTouchees=0;
		partiesTouchees=new Coordonnee[0]; 
	}
	
	
	public Coordonnee getDebut() {
		return debut;
	}


	public Coordonnee getFin() {
		return fin;
	}

	public String toString(){
		
		String s="";
		
		return s+"Navire("+this+")";
	}
	

























	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Navire n=new Navire("B1", 4, horizontal);

	}

}
