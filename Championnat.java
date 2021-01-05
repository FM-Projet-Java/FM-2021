import java.util.ArrayList;

public class Championnat{
  private ArrayList<Equipe> classement = new ArrayList<Equipe>();
  private String[] listeNomEquipe = {"Lyon","Lille","Paris-SG","Rennes","Marseille","Monaco","Lens","Montpellier","Angers","Metz","Brest","Nice","Bordeaux","Saint-Etienne","Reims","Nantes","Strasbourg","Lorient","Dijon","Nimes"};


  public Championnat(Equipe[] listeEquipes){
    int i;
    for(i = 0; i < listeEquipes.length; i++){
      classement.add(listeEquipes[i]);
    }
  }


  public Championnat(){
    int i;
    for(i = 0; i < listeNomEquipe.length; i++){
      classement.add(new Equipe(listeNomEquipe[i]));
    }
  }

  public void actualiserClassement(){
    ArrayList<Equipe> classementActualise = new ArrayList<Equipe>();
    int i,j;
    int maxNbPoints = 0;
    Equipe equipeMax = new Equipe("temporaire");

    for(i = 0; i < classement.size(); i++){
      for(j = 0; j < classement.size(); j++){
        if(maxNbPoints < classement.get(j).getNbPointsEquipe()){
          maxNbPoints = classement.get(j).getNbPointsEquipe();
          equipeMax = classement.get(j);
          System.out.println(classement.get(j).getNbPointsEquipe());
          classement.remove(j);
        }
      }
      classementActualise.add(equipeMax);
      maxNbPoints = 0;
    }
  }


  public void afficherClassement(){
    int i;
    System.out.println("Voici le classement actuel du championnat");
    for(i = 0; i < classement.size(); i++){
      System.out.println(i+1+". "+classement.get(i).getNomEquipe()+String.format("%-6d", classement.get(i).getNbPointsEquipe()));
    }
  }

  public Equipe getEquipe(int i){
    return classement.get(i);
  }

  public void journeeDeMatch(){
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
  }
}
