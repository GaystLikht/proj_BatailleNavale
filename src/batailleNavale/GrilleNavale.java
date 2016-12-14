package batailleNavale;

public class GrilleNavale {

	
	
	private Navire[] navires;
	private int nbNavires;
	private int taille;
	private Coordonnee[] tirsRecus;
	private int nbTirsRecus;
	
	
	
	public GrilleNavale(int taille, int[] taillesNavires) {
		
		this.taille=taille;
		taillesNavires=new int[taille];
		
		navires=new Navire[nbNavires];
		 nbNavires=taillesNavires.length;
		Coordonnee[] tirsRecu=new Coordonnee[nbTirsRecus];
		 nbTirsRecus=0;;
		
	}
	
	
	
	
	public GrilleNavale(int taille,int nbNavires) {
		
		this.taille=taille;
		this.nbNavires= nbNavires;
		
	}
	
	
	public String toString() {
		Coordonnee[] tirsRecus=new Coordonnee[676]; 
		
		String s="";
		for (int i = 0; i < nbNavires; i++) {
			
			for (int j = 0; j < tirsRecus.length; j++) {

			if(!(this.navires[i].recoitTir(tirsRecus[j]))){
				s=s+'.';
			}

			
		}
	}
		return s;
	}	
//	public String toString() {...}
//	public boolean ajouteNavire(Navire n) {...}
//	public void placementAuto(int[] taillesNavires) {...}
//	private boolean estDansGrille(Coordonnee c) {...}
//	private boolean estDansTirsRecus(Coordonnee c) {...}
//	private boolean ajouteDansTirsRecus(Coordonnee c) {...}
//	public boolean recoitTir(Coordonnee c) {...}
//	public boolean estTouche(Coordonnee c) {...}
//	public boolean estALEau(Coordonnee c) {...}
//	public boolean estCoule(Coordonnee c) {...}
//	public boolean perdu() {...}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrilleNavale g1=new GrilleNavale(676,new int[10]);
		
	}

}
