public class TestChampionnat{
  public static void main(String[] args){

    Championnat ligue1 = new Championnat();
    ligue1.afficherClassement();

    Match match1 = new Match(ligue1.getEquipe(0), ligue1.getEquipe(1));
    match1.simulationMatch();



  }
}
