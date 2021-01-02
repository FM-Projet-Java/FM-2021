public class Joueur extends Equipe{
  private String nomJoueur;
  private int general;
  private int moral;
  private String nationalite;
  private String[] listeDeNationalites = {"Francais","Allemand","Anglais","Espagnol"};
  private String[] listeNomJoueursFr = {"Martin","Bernard","Thomas","Petit","Robert","Richard","Durand","Dubois","Moreau","Laurent"};
  private String[] listeNomJoueursEsp = {"Abril","Bautista","Cabrero","Delgado","Escobar","Franco","Garcea","Hortelano","Lutero","Mendoza"};
  private String[] listeNomJoueursAng = {"Smith","Jones","Williams","Brown","Taylor","Davies","Wilson","Evans","Thomas","Roberts","Johnson","Miller","Davis","Garcia","Rodriguez"};
  private String[] listeNomJoueursAll = {"Bauer","Baumann","Becker","Fischer","Hoffmann","Kauffmann","Keller","Koch","Schmidt","Schneider"};
  private String[] listePrenomJoueursFr = {"Jean","Pierre","Michel","Philippe","Louis","Alain","Jacques","Bernard","Marcel","Robert","Paul","Christian","Nicolas"};
  private String[] listePrenomJoueursEsp = {"Hugo","Diego","Elio","Pablo","Elias","Esteban","Lorenzo","Ruben","Luis","Lisandro","Paco","Miguel"};
  private String[] listePrenomJoueursAng = {"Bradley","Michael","Matthew","Joshua","Nicholas","Christopher","Joseph","Ethan","Andrew","Daniel","William","Anthony"};
  private String[] listePrenomJoueursAll = {"Stephan","Wilfried","Ludwig","Lukas","Erwin","Hermann","Franz","Kurt","Fritz","Siegfried","Leni"};
  private int idJoueur;
  private static int compt = 0;


  public Joueur(String nom, String general){
    this.nom = nom;
    this.general = general;
    idJoueur = compt++;
    nationalite = listeDeNationalites[0 + (int)(Math.random() * ((listeDeNationalites.length - 0) + 1))];
  }

  public Joueur(String nom){
    this.nom = nom;
    general = 1 + (int)(Math.random() * ((10 - 1) + 1));
    nationalite = listeDeNationalites[0 + (int)(Math.random() * ((listeDeNationalites.length - 0) + 1))];

  }

  public Joueur(){
    general = 1 + (int)(Math.random() * ((10 - 1) + 1));
    nationalite = listeDeNationalites[0 + (int)(Math.random() * ((listeDeNationalites.length - 0) + 1))];

    if(nationalite == "Francais"){
      this.nom = listeDePrenomJoueursFr[0 + (int)(Math.random() * ((listeDePrenomJoueursFr.length - 0) + 1))]+" "+listeDeNomJoueursFr[0 + (int)(Math.random() * ((listeDeNomJoueursFr.length - 0) + 1))];
    }

  }



}
