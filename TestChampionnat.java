public class TestChampionnat{
  public static void main(String[] args){

    Championnat ligue1 = new Championnat();
    ligue1.afficherClassement();

    /*Match match1 = new Match(ligue1.getEquipe(0), ligue1.getEquipe(1));
    match1.simulationMatch();*/
	try{
    	ligue1.journeeDeMatch();
    } catch (JoueursManquantException e){
    	System.out.println("Le match ne peux pas se lancer ! "+e.getMessage()+",l'équipe n'étant pas complète a du déclarer forfait !");
    }
    	ligue1.actualiserClassement();

    	ligue1.afficherClassement();

      ligue1.journeeDeMatch();

      ligue1.actualiserClassement();

      ligue1.afficherClassement();

  }
}
