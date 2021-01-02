public class Joueur extends Equipe{
  private String nomJoueur;
  private int general;
  private int moral;
  private String nationalite;
  private String[] listeDeNationalites = {"Francais","Allemand","Anglais","Espagnol"}
  private String[] listeNomJoueursFr = {"Martin","Bernard","Thomas","Petit","Robert","Richard","Durand","Dubois","Moreau","Laurent"}
  private String[] listeNomJoueursEsp = {"Abril","Bautista","Cabrero","Delgado","Escobar","Franco","Garcea","Hortelano","Lutero","Mendoza"}
  private String[] listeNomJoueursAng = {"Smith","Jones","Williams","Brown","Taylor","Davies","Wilson","Evans","Thomas","Roberts","Johnson","Miller","Davis","Garcia","Rodriguez"}
  private String[] listeNomJoueursAll = {"Bauer","Baumann","Becker","Fischer","Hoffmann","Kauffmann","Keller","Koch","Schmidt","Schneider"}
  




  public Joueur(String nom, String general){
    this.nom = nom;
    this.general = general;

  }

  public Joueur(String nom){
    this.nom = nom;
    general = 1 + (int)(Math.random() * ((10 - 1) + 1));
  }





}
