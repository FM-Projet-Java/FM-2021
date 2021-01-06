import java.util.ArrayList;

public class Equipe{
  private Joueur[] listJoueurs = new Joueur[11];
  protected String nomEquipe;
  private int nbPoints = 0;
  private int nbVictoires = 0;
  private int nbDefaites = 0;
  private int nbMatchNul = 0;
  private int nbButsMarques = 0;
  private int generalEquipe = 0;
  private ArrayList<String> listeEquipesRencontres = new ArrayList<String>();
  private int matchsJoues = 0;

  public Equipe(String nomEquipe){ //Constructeur qui necessite le nom de l'equipe
    int i;
    this.nomEquipe = nomEquipe;
    listeEquipesRencontres.add(nomEquipe);
    for(i = 0; i < 11; i++){
      listJoueurs[i] = new Joueur();
      listJoueurs[i].changerEquipeActuelle(this);
      generalEquipe += listJoueurs[i].getGeneralJoueur();

    }

  }
  	public boolean estComplete(){
  		for(int i=0;i<listJoueurs.length;i++){
			if (listJoueurs[i]=null){
				return false;
			}
  		}
  		return true;
  	}
	public void RetirerJoueur(Joueur joueur){
		for(int i=0;i<listJoueurs.length;i++){
			if (joueur==listJoueurs[i]){
				listJoueurs[i]=null;
			}
		}
	}

  public void changerNomEquipe(String nouveauNom){ //Change le nom de l'equipe
    System.out.println("L'equipe : "+nomEquipe+" s'appelle maintenant : "+nouveauNom);
    nomEquipe = nouveauNom;

  }


  public void afficherJoueurs(){ //Affiche la liste des joueurs de l'equipe
    int i;
    for(i = 0; i < 11; i++){
      System.out.println(listJoueurs[i].getNom());
    }
  }

  public Joueur getJoueur(int i){ //Renvoie le joueur se trouvant a la position i dans la liste des joueurs de l'equipe
    return listJoueurs[i];
  }

  public String getNomEquipe(){ //Renvoie le nom de l'equipe
    return nomEquipe;
  }


  public void victoire(){ //Applique les effets d'une victoire a l'equipe
    nbPoints += 3;
    nbVictoires += 1;
    
  }

  public void matchNul(){ //Applique les effets d'un match nul a l'equipe
    nbPoints += 1;
    nbMatchNul += 1;
  }

  public void defaite(){ //Applique les effets d'une defaite a l'equipe
    nbDefaites += 1;
  }

  public void appliqueResultatMatch(String resultat){  //Prend en argument V pour victoire, D pour defaite et N pour match nul. Cette fonction applique le résultat d'un match aux stats de l'equipe
    if(resultat == "V"){
      this.victoire();
    }
    if(resultat == "D"){
      this.defaite();
    }
    if(resultat == "N"){
      this.matchNul();
    }
    else
      System.out.println("La saisie ne correspond a aucun resultat connu. Veuillez entrer V, D ou N pour respectivement victoire, defaite, match nul");

  }

  public void nombreButsMarques(int buts){ //Ajoute le nombre de buts passé en argument au nombre de buts marques par l'equipe
    nbButsMarques += buts;
  }

  public int getGeneralEquipe(){ //Renvoie le general de l'equipe
    return generalEquipe;
  }


  public void ajouterListeEquipesRencontres(Equipe equipe1){ //Ajoute une equipe a la liste des equipes rencontrees par cette equipe
    listeEquipesRencontres.add(equipe1.getNomEquipe());
  }

  public boolean equipeDejaRencontre(String nomEquipe){ //Renvoie true si l'equipe passee en argument a deja joue contre cette equipe. Renvoie false sinon
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

}
