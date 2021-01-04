public class Equipe{
  private Joueur[] listJoueurs = new Joueur[11];
  protected String nomEquipe;

  public Equipe(String nomEquipe){
    int i;
    this.nomEquipe = nomEquipe;
    for(i = 0; i < listJoueurs.length; i++)
      listJoueurs[i] = new Joueur();

  }


  public changerNomEquipe(String nouveauNom){
    nomEquipe = nouveauNom;
  }

}
