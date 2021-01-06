public class Joueur extends Personne{
	private String nomJoueur;
	private int general;		//Note du joueur : minimum 0 , maximum 99
	private int moral;
	private Equipe equipe;

	public Joueur(){
  		super();
    	this.general = 50 + (int)(Math.random() * 35);
    	moral=100;
    	equipe=null;
    }

	public Joueur(String nom){
    	super(nom);
		this.general = 50 + (int)(Math.random() * 50);
		moral=100;
		equipe=null;
    }

	public Joueur(String nom, String nationalite){
    	super(nom,nationalite);
    	this.general = 50 + (int)(Math.random() * 50);
		moral=100;
		equipe=null;
    }

	public void changerEquipeActuelle(Equipe nouvelleEquipe){
    	equipe = nouvelleEquipe;
	}

	public void perteMoral(){
		if(moral>0){
			moral--;
		}
	}
	public void gainMoral(){
		if (moral<100){
			moral++;
		}
	}

	public void afficherEquipeJoueur(){
    	System.out.println(nomJoueur+" est actuellement en contrat avec "+equipe.getNomEquipe());
  	}

	public int getGeneralJoueur(){
    	return general;
  	}
	public String getRole(){
		return "Joueur";
	}
	public String toString(){
	String res=super.toString();
	res+=" --- General : "+general+"--- Moral : "+moral+" --- Equipe : ";
	if(equipe!=null)res+=equipe.getNomEquipe();
	else res+="Agent Libre";
	return res;
	}
}
