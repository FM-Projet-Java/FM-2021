import java.util.ArrayList;
/** Classe de correspondant à une équipe de football, constitué d'un tableau de 11 Joueur, d'un coach, et d'un entraineur.
   *Le reste des variable d'instance correspondent aux statistiques de l'équipe
    */
public class Equipe{
  private Joueur[] listJoueurs = new Joueur[11];
  private Coach coach;
  private EntraineurPhysique entraineur;
  protected String nomEquipe;
  private int nbPoints = 0;
  private int nbVictoires = 0;
  private int nbDefaites = 0;
  private int nbMatchNul = 0;
  private int nbButsMarques = 0;
  private int generalEquipe = 0;
  private ArrayList<String> listeEquipesRencontres = new ArrayList<String>();
  private int matchsJoues = 0;
  private int nbTitres = 0;

  public Equipe(String nomEquipe){ //Constructeur qui necessite le nom de l'equipe
    int i;
    this.nomEquipe = nomEquipe;
    listeEquipesRencontres.add(nomEquipe);
    for(i = 0; i < 11; i++){
      listJoueurs[i] = new Joueur();
      listJoueurs[i].changerEquipeActuelle(this);
      generalEquipe += listJoueurs[i].getGeneralJoueur();
    }
    coach=new Coach();
    entraineur=new EntraineurPhysique();
    System.out.println(listJoueurs[1].getEquipe());
  }
  /** Renvoie true si un joueur de l'equipe est blessé*/
  	public boolean estComplete(){
  		for(int i=0;i<listJoueurs.length;i++){
			     if (listJoueurs[i].getBlessure()){
				         return false;
			     }
  		}
  		return true;
  	}
    /** Renvoie le joueur blessé de l'équipe (dont l'attribut "blessure" vaut true) */
    public Joueur getBlesse(){
      for(int i=0;i<listJoueurs.length;i++){
        if(listJoueurs[i].getBlessure()){
          return listJoueurs[i];
        }
      }
      return new Joueur();
    }
    /** Remplace un joueur de l'équipe passé en paramètre (seulement si il s'y trouve) par un nouveau joueur*/
    public void remplacerJoueur(Joueur joueur){
      for(int i=0;i<listJoueurs.length;i++){
        if(joueur==listJoueurs[i]){
          listJoueurs[i]=new Joueur();
          listJoueurs[i].changerEquipeActuelle(this);
        }
      }
    }
    /** Utilisé pour attribué l'etat blessé a un joueur de l'équipe avec son index dans le tableau*/
    public void blessureJoueur(int i){
      listJoueurs[i].blessure();
    }

    /** Si une envie vous prends de changer le nom du club !*/
  public void changerNomEquipe(String nouveauNom){ //Change le nom de l'equipe
    System.out.println("L'equipe : "+nomEquipe+" s'appelle maintenant : "+nouveauNom);
    nomEquipe = nouveauNom;

  }

  public Joueur[] getJoueur(){ //Renvoie la liste des joueurs de l'équipe
    return listJoueurs;
  }
  public Joueur getJoueur(int i){ //Renvoie le joueur se trouvant a la position i dans la liste des joueurs de l'equipe
    return listJoueurs[i];
  }

  public String getNomEquipe(){ //Renvoie le nom de l'equipe
    return nomEquipe;
  }
  public Coach getCoach(){ //Renvoie le coach de l'équipe
    return coach;
  }

  public EntraineurPhysique getEntraineurPhysique(){ //Renvoie l'entraineur physique de l'équipe
    return entraineur;
  }

/** Applique les effets d'une victoire a l'equipe : +3pt, gain de moral des joueurs */
  public void victoire(){
    nbPoints += 3;
    nbVictoires += 1;
    for(int i=0;i<listJoueurs.length;i++){
		listJoueurs[i].gainMoral();
	}
  }
/** Applique les effets d'un match nul a l'equipe : +1 pt */
  public void matchNul(){
    nbPoints += 1;
    nbMatchNul += 1;
  }
/** Applique les effets d'une defaite a l'equipe */
  public void defaite(){
    nbDefaites += 1;
    for(int i=0;i<listJoueurs.length;i++){
		listJoueurs[i].perteMoral();
	}
  }

/** Ajoute le nombre de buts passé en argument au nombre de buts marques par l'equipe */
  public void nombreButsMarques(int buts){
    nbButsMarques += buts;
  }

  public int getGeneralEquipe(){ //Renvoie le general de l'equipe
    return generalEquipe;
  }

/** Ajoute une equipe a la liste des equipes rencontrees par cette equipe */
  public void ajouterListeEquipesRencontres(Equipe equipe1){ //Ajoute une equipe a la liste des equipes rencontrees par cette equipe
    listeEquipesRencontres.add(equipe1.getNomEquipe());
  }

/** Renvoie true si l'equipe passee en argument a deja joue contre cette equipe. Renvoie false sinon */
  public boolean equipeDejaRencontre(String nomEquipe){
    int i;
    for(i = 0; i < listeEquipesRencontres.size(); i++){
      if(listeEquipesRencontres.get(i) == nomEquipe){
        return true;
      }
    }
    return false;
  }

  public void incrementeMatchJoues(){ //Ajoute 1 aux matchs joues
    matchsJoues += 1;
  }

  public int getNbMatchJoues(){ //Renvoie le nombre de matchs joues de l'equipe
    return matchsJoues;
  }

  public void setNbMatchJoues(int nbMatchsJoues){ //Definit un nouveau nombre de match joues de l'equipe
    matchsJoues = nbMatchsJoues;
  }

  public int getNbPointsEquipe(){ //Renvoie le nombre de points de l'equipe
    return nbPoints;
  }

  public void setMatchsJoues(int matchsJoues){ //Definit un nouveau nombre de match joues de l'equipe
    this.matchsJoues = matchsJoues;
  }

  public int getNbTitres(){
    return nbTitres;
  }

  public void incrementeNbTitres(){
    nbTitres += 1;
  }
  public void resetListesDejaRencontres(){
    listeEquipesRencontres.clear();
    listeEquipesRencontres.add(nomEquipe);
  }

  public void resetNbPoints(){
    nbPoints = 0;
  }

  public int getNbButsMarques(){
    return nbButsMarques;
  }
  public String toString(){
    String res="";
    res+="----------------------------"+nomEquipe+"-------------------------\n";
    res+="------------------------------Effectif---------------------------";
    for(int i=0;i<listJoueurs.length;i++){
      res+=listJoueurs[i];
    }
    res+=coach;
    res+=entraineur;
    return res;
  }


}
