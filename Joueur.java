public class Joueur{
  private String nom;
  private int general;
  private int moral;



  public Joueur(String nom, String general){
    this.nom = nom;
    this.general = general;

  }

  public Joueur(String nom){
    this.nom = nom;
    general = 1 + (int)(Math.random() * ((10 - 1) + 1));
  }





}
