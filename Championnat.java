import java.util.ArrayList;

/** Classe qui permet de simuler le deroulé d'un vrai Championnat de Football (ici Ligue 1) en réalisant des rencontres (aller/retour)
   *entre chaque equipe du classement
*/

public class Championnat{
  private ArrayList<Equipe> classement = new ArrayList<Equipe>();
  private String[] listeNomEquipe = {"Lyon","Lille","Paris-SG","Rennes","Marseille","Monaco","Lens","Montpellier","Angers","Metz","Brest","Nice","Bordeaux","Saint-Etienne","Reims","Nantes","Strasbourg","Lorient","Dijon","Nimes"};
  private ArrayList<Equipe> classementTitres = new ArrayList<Equipe>();

/** Constructeur à un paramètre, une liste de nom d'équipe, qui crée les equipes correspondantes et les ajoute au classement du championnat*/
  public Championnat(Equipe[] listeEquipes){
    int i;
    for(i = 0; i < listeEquipes.length; i++){
      classement.add(listeEquipes[i]);
    }
  }

/** Constructeur sans paramètre, qui prend les noms des equipes de Ligue 1 (Championnat De Football Français de 1ere division)*/
  public Championnat(){
    int i;
    for(i = 0; i < listeNomEquipe.length; i++){
      classement.add(new Equipe(listeNomEquipe[i]));
    }
  }
/**Actualise le classement en triant les equipes par leur nombre de points*/
  public void actualiserClassement(){
    int i,j;
    int maxNbPoints = 0;
    int indiceMax = 0;
    ArrayList<Equipe> classementActualise = new ArrayList<Equipe>();
    int tailleClassement = classement.size();

    for(i = 0; i < tailleClassement; i++){
      for(j = 0; j < classement.size(); j++){
        if(maxNbPoints <= classement.get(j).getNbPointsEquipe()){
          maxNbPoints = classement.get(j).getNbPointsEquipe();
          indiceMax = j;
        }
      }
      classementActualise.add(classement.get(indiceMax));
      classement.remove(indiceMax);
      maxNbPoints = 0;
    }
    classement = classementActualise;


  }

/**Affiche le classement des equipes par nombre de points */
  public void afficherClassement(){
    int i;

    System.out.println("");
    System.out.println("Voici le classement actuel du championnat");
    System.out.println("");

    for(i = 0; i < classement.size(); i++){
      System.out.println(i+1+". "+classement.get(i).getNomEquipe()+String.format("%-6d", classement.get(i).getNbPointsEquipe()));
    }
  }

  public ArrayList<Equipe> getClassement(){
    return classement;
  }
  public Equipe getEquipe(int i){
    return classement.get(i);
  }
/**Simule une journee de match c'est a dire un match pour chaque equipe. A la fin de la journee de match les equipes s'entrainent*/
  public void journeeDeMatch(){ //throws JoueursManquantException{
    int i = 0;
    int j = 0;

    /*On organise les matchs entre les equipes qui n'ont jamais joue contre
    Toutes les equipes auront joue un match a la fin d'une journee*/

    for(i = 0; i < classement.size(); i++){
      for(j = 0; j < classement.size(); j++){
        if(classement.get(i) != classement.get(j) && !(classement.get(i).equipeDejaRencontre(classement.get(j).getNomEquipe())) && classement.get(i).getNbMatchJoues() < 1 && classement.get(j).getNbMatchJoues() < 1 ){
          new Match(classement.get(i), classement.get(j)).simulationMatch();
          classement.get(i).ajouterListeEquipesRencontres(classement.get(j));
          classement.get(j).ajouterListeEquipesRencontres(classement.get(i));
          classement.get(i).incrementeMatchJoues();
          classement.get(j).incrementeMatchJoues();
        }
      }
    }
    Entrainement.Entrainement(this.getClassement());
  }
/**Simule une journee de match retour. Les equipes ayant deja joue contre s'affrontent a nouveau. Cette methode doit etre precede de journeeDeMatch pour correctement fonctionner. A la fin de la journee de match les equipes s'entrainent*/
  public void journeeDeMatchRetour(){// throws JoueursManquantException{
    int i = 0;
    int j = 0;

    /*On organise les matchs entre les equipes qui n'ont jamais joue contre
    Toutes les equipes auront joue un match a la fin d'une journee*/

    for(i = 0; i < classement.size(); i++){
      for(j = 0; j < classement.size(); j++){
        if(classement.get(i) != classement.get(j) && (classement.get(i).equipeDejaRencontre(classement.get(j).getNomEquipe())) && classement.get(i).getNbMatchJoues() == 1 && classement.get(j).getNbMatchJoues() == 1 ){
          new Match(classement.get(i), classement.get(j)).simulationMatch();
          classement.get(i).ajouterListeEquipesRencontres(classement.get(j));
          classement.get(j).ajouterListeEquipesRencontres(classement.get(i));
          classement.get(i).incrementeMatchJoues();
          classement.get(j).incrementeMatchJoues();
        }
      }
    }
    Entrainement.Entrainement(this.getClassement());

  }
/**Simule une journee de math aller plus une journee de match retour*/
  public void matchAllerRetour(){// throws JoueursManquantException{
    System.out.println("");
    System.out.println("||||||||||      Journee de Matchs aller       ||||||||||");
    System.out.println("");
    this.journeeDeMatch();
    System.out.println("");
    System.out.println("||||||||||      Journee de Matchs retour       ||||||||||");
    System.out.println("");
    this.journeeDeMatchRetour();
    int i;
    for(i = 0; i < classement.size(); i++){
      classement.get(i).setMatchsJoues(0);
      classement.get(i).resetListesDejaRencontres();
    }

  }
/**Simule tout les matchs d'un championnat. Le vainqueur est annonce. */
  public void simulerChampionnat(){// throws JoueursManquantException{
    int i,j;

    for(i = 0; i < 19; i++){
      this.matchAllerRetour();
      this.actualiserClassement();
      this.afficherClassement();
    }
    System.out.println("----------------------------------------------------------------------------------------------");
    System.out.println(classement.get(0).getNomEquipe()+" remporte le championnat !");
    System.out.println("----------------------------------------------------------------------------------------------");
    classement.get(0).incrementeNbTitres();

    for(j = 0; j < classement.size(); j++){
      classement.get(j).resetNbPoints();
    }


  }
/**Simule 100 championnats et donne un classement par nombre de titres gagnes a la fin. */
  public void simulerSiecleChampionnat() {//throws JoueursManquantException{
    int i;
    for(i = 0; i < 100; i++){
      this.simulerChampionnat();
    }
    this.afficherClassementTitresChampionnat();
  }
/**Affiche le classement des equipes par nombre de titres gagnes */
  public void afficherClassementTitresChampionnat(){ //throws JoueursManquantException{
    int i,j;
    int maxNbTitres = 0;
    int indiceMax = 0;
    int tailleClassement = classement.size();
    ArrayList<Equipe> classementCopie = classement;


    for(i = 0; i < tailleClassement; i++){
      for(j = 0; j < classementCopie.size(); j++){
        if(maxNbTitres <= classementCopie.get(j).getNbTitres()){
          maxNbTitres = classementCopie.get(j).getNbTitres();
          indiceMax = j;
        }
      }
      classementTitres.add(classementCopie.get(indiceMax));
      classementCopie.remove(indiceMax);
      maxNbTitres = 0;
    }
    System.out.println("");
    this.afficherClassementTitres();
    System.out.println("");
  }
/**Methode completant afficherClassementTitresChampionnat */
  public void afficherClassementTitres(){
    int i;
    System.out.println("");
    System.out.println("Voici le classement des equipes en fonction du nombre de titres remportes");
    System.out.println("");
    for(i = 0; i < classementTitres.size(); i++){
      System.out.println(i+1+". "+classementTitres.get(i).getNomEquipe()+String.format("%-6d", classementTitres.get(i).getNbTitres()));
    }
  }


}
