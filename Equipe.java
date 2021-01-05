public class Equipe{
  private Joueur[] listJoueurs = new Joueur[11];
  protected String nomEquipe;

  public Equipe(String nomEquipe){
    int i;
    this.nomEquipe = nomEquipe;
    for(i = 0; i < 11; i++){
      listJoueurs[i] = new Joueur();
      listJoueurs[i].changerEquipeActuelle(nomEquipe);
    }
  }


  public void changerNomEquipe(String nouveauNom){
    System.out.println("L'equipe : "+nomEquipe+" s'appelle maintenant : "+nouveauNom);
    nomEquipe = nouveauNom;

  }


  public void afficherJoueurs(){
    int i;
    for(i = 0; i < 11; i++){
      System.out.println(listJoueurs[i].afficherNomJoueur());
    }
  }

  public Joueur getJoueur(int i){
    return listJoueurs[i];
  }

  public String getNomEquipe(){
    return nomEquipe;
  }


}
