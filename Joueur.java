public class Joueur{
  private String nomJoueur;
  private int general = 1;
  private int moral;
  private String nationalite;
  private String[] listeNationalites = {"Francais","Allemand","Anglais","Espagnol"};
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
  private String EquipeActuelle;

  public Joueur(){
    this.general = 1 + (int)(Math.random() * 9);
    nationalite = listeNationalites[(int)(Math.random() * (listeNationalites.length))];
    idJoueur = compt++;

    if(nationalite == "Francais")
    this.nomJoueur = listePrenomJoueursFr[(int)(Math.random() * (listePrenomJoueursFr.length))]+" "+listeNomJoueursFr[(int)(Math.random() * (listeNomJoueursFr.length))];
    if(nationalite == "Allemand")
    this.nomJoueur = listePrenomJoueursFr[(int)(Math.random() * (listePrenomJoueursAll.length))]+" "+listeNomJoueursAll[(int)(Math.random() * (listeNomJoueursAll.length))];
    if(nationalite == "Anglais")
    this.nomJoueur = listePrenomJoueursAng[(int)(Math.random() * (listePrenomJoueursAng.length))]+" "+listeNomJoueursAng[(int)(Math.random() * (listeNomJoueursAng.length))];
    if(nationalite == "Espagnol")
    this.nomJoueur = listePrenomJoueursEsp[(int)(Math.random() * (listePrenomJoueursEsp.length))]+" "+listeNomJoueursEsp[(int)(Math.random() * (listeNomJoueursEsp.length))];

  }

  public Joueur(String nom, int general){
    this.nomJoueur = nom;
    this.general = general;
    nationalite = listeNationalites[(int)(Math.random() * (listeNationalites.length))];
    idJoueur = compt++;
  }

  public Joueur(String nom){
    this.nomJoueur = nom;
    this.general = 1 + (int)(Math.random() * 10);
    nationalite = listeNationalites[(int)(Math.random() * (listeNationalites.length))];
    idJoueur = compt++;

  }

  public void changerEquipeActuelle(String nouvelleEquipe){
    EquipeActuelle = nouvelleEquipe;
  }

  public String afficherNomJoueur(){
    return nomJoueur;
  }

  public void afficherEquipeJoueur(){
    System.out.println(nomJoueur+" est actuellement en contrat avec "+EquipeActuelle);
  }

  public int getGeneralJoueur(){
    return general;
  }

}
