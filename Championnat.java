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

  public void afficherClassement(){
    int i;
    for(i = 0; i < classement.size(); i++){
      System.out.println(i+1+". "+classement.get(i).getNomEquipe());
    }
  }

  public Equipe getEquipe(int i){
    return classement.get(i);
  }

  public void journeeDeMatch(){
    int i = 0;
    int j = 0;
    for(i = 0; i < classement.size(); i++){
      for(j = 0; i < classement.size(); i++){
        if(classement.get(i) != classement.get(j))
      }
    }
  }
}
