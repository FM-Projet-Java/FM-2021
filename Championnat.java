
import java.util.ArrayList;

public class Championnat{
  private ArrayList<Equipe> classement = new ArrayList();
  private String[] listNomEquipe = {"Lyon","Lille","Paris-SG","Rennes","Marseille","Monaco","Lens","Montpellier","Angers","Metz","Brest","Nice","Bordeaux","Saint-Etienne","Reims","Nantes","Strasbourg","Lorient","Dijon","Nimes"};


  public Championnat(){
    int i;
    for(i = 0; i < listNomEquipe.length; i++){
      classement.add(listNomEquipe[i]);
    }
  }




}
