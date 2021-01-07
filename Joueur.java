/** Classe Joueur qui gere une instance pour un Joueur de Football*/

public class Joueur extends Personne{
	private int general;		//Note du joueur : minimum 0 , maximum 99
	private int moral;
	private Equipe equipe;
	private boolean blessure;

/** Constructeur sans argument pour un joueur, l'initatilise sans club, general entre 50 et 85, moral à 100 et non blessé*/

	public Joueur(){
  	super();
    this.general = 50 + (int)(Math.random() * 35);
    moral=100;
    equipe=null;
		blessure=false;
  }

/** Constructeur à un paramètre permettant d'entre le nom du joueur*/

	public Joueur(String nom){
    super(nom);
		this.general = 50 + (int)(Math.random() * 50);
		moral=100;
		equipe=null;
		blessure=false;
    }

/** Constructeur à deux paramètre permettant d'entre le nom du joueur et sa nationalite*/

	public Joueur(String nom, String nationalite){
    super(nom,nationalite);
  	this.general = 50 + (int)(Math.random() * 50);
		moral=100;
		equipe=null;
		blessure=false;
  }

/** Change l'equipe actuelle du joueur avec celle passé en paramètre */

	public void changerEquipeActuelle(Equipe nouvelleEquipe){
    	equipe = nouvelleEquipe;
	}

/** Cela n'est pas toujours amusant de perdre :( */

	public void perteMoral(){
		if(moral>0){
			moral--;
		}
	}

/** Quel bohneur de gagner ! :)*/

	public void gainMoral(){
		if (moral<100){
			moral++;
		}
	}
	/** Blessure d'un joueur pendant un match */
	public void blessure(){
		blessure=true;
	}
	/** Incremente le general du joueur en fonction de son moral et des competences de l'entraineur de son club*/
	public void ameliorerGeneral(){
		int comp=equipe.getEntraineurPhysique().getCompetence();
		double alea=Math.random();
		if(general<99){
			if(alea<((moral/2000000)+comp/50)){
				general++;
			}
		}
	}

	public int getGeneralJoueur(){ // Retourne le general du joueur
    	return general;
  	}
	public String getRole(){ // Retourne le role de la personne, ici "joueur"
		return "Joueur";
	}
	public boolean getBlessure(){ // Retourne si oui ou non, le joueur est blessé
		return blessure;
	}
	public Equipe getEquipe(){return equipe;} // Retourne l'equipe dans lequel le joueur est

	public String toString(){
	String res=super.toString();
	res+=" --- General : "+general+"--- Moral : "+moral+" --- Equipe : ";
	if(equipe!=null)res+=equipe.getNomEquipe();
	else res+="Agent Libre";
	return res;
	}
}
