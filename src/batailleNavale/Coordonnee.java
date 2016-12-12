package batailleNavale;

public class Coordonnee {

	private int ligne;
	private int colonne;
	
	
	
	
	public Coordonnee(int ligne, int colonne) {
		this.ligne=ligne-1;
		this.colonne=colonne-1;
		if((this.ligne<0)|| (this.ligne>25)|| (this.colonne<0)|| (this.colonne>25)){
			throw new RuntimeException( "Indice  hors limite" );
		}
//		for(int i=0;i<26;i++){
//			colonne='A'+i;
//		}
			
		
	}
	public Coordonnee(String s) {
		
		this.ligne=Integer.parseInt(s.substring(1, 2))-1;
		this.colonne=(int)(s.charAt(0))-65;
		if((this.ligne<0)|| (this.ligne>25)|| (this.colonne<0)|| (this.colonne>25)){
			throw new RuntimeException( "Indice  hors limite" );}
		
	}
	public String toString() {
		
		String s="";
		return s+(char)(this.colonne+'A')+(this.ligne+1)+"";
	}
	public int getLigne() {
		
		return ligne;
	}
	public int getColonne() {
		
		return colonne;
	}
	
	public int compareTo(Coordonnee c){
		
		int res=0;
		if(this.ligne!=c.ligne){
			res=this.ligne-c.ligne;
			
		}
		else {
				res=this.colonne-c.colonne;
		}
		
		return res;
	}
	
	
	public boolean equals(Object obj) {
		
	    return (this.compareTo((Coordonnee)obj)==0);
	}
	
	
public boolean voisine(Coordonnee c) {
	
	return ((Math.abs(this.ligne-c.ligne)==1)||(Math.abs(colonne-c.colonne)==1));
}

	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Coordonnee c=new Coordonnee("A7");
		Coordonnee c1=new Coordonnee(4,15);
		Coordonnee c2=new Coordonnee(5,15);
		System.out.println(c.compareTo(c1));
		System.out.println(c.toString());
		System.out.println(c1.voisine(c));
		
	}

}
