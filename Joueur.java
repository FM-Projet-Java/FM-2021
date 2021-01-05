public class Joueur{
  private String nomJoueur;
  private int general;
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
    this.general = 1 + (int)(Math.random() * ((10 - 1) + 1));
    nationalite = listeNationalites[0 + (int)(Math.random() * ((listeNationalites.length - 0) + 1))];
    idJoueur = compt++;

    if(nationalite == "Francais")
    this.nomJoueur = listePrenomJoueursFr[0 + (int)(Math.random() * ((listePrenomJoueursFr.length - 0) + 1))]+" "+listeNomJoueursFr[0 + (int)(Math.random() * ((listeNomJoueursFr.length - 0) + 1))];
    if(nationalite == "Allemand")
    this.nomJoueur = listePrenomJoueursFr[0 + (int)(Math.random() * ((listePrenomJoueursAll.length - 0) + 1))]+" "+listeNomJoueursAll[0 + (int)(Math.random() * ((listeNomJoueursAll.length - 0) + 1))];
    if(nationalite == "Anglais")
    this.nomJoueur = listePrenomJoueursAng[0 + (int)(Math.random() * ((listePrenomJoueursAng.length - 0) + 1))]+" "+listeNomJoueursAng[0 + (int)(Math.random() * ((listeNomJoueursAng.length - 0) + 1))];
    if(nationalite == "Espagnol")
    this.nomJoueur = listePrenomJoueursEsp[0 + (int)(Math.random() * ((listePrenomJoueursEsp.length - 0) + 1))]+" "+listeNomJoueursEsp[0 + (int)(Math.random() * ((listeNomJoueursEsp.length - 0) + 1))];

  }

  public Joueur(String nom, int general){
    this.nomJoueur = nom;
    this.general = general;
    nationalite = listeNationalites[0 + (int)(Math.random() * ((listeNationalites.length - 0) + 1))];
    idJoueur = compt++;
  }

  public Joueur(String nom){
    this.nomJoueur = nom;
    this.general = 1 + (int)(Math.random() * ((10 - 1) + 1));
    nationalite = listeNationalites[0 + (int)(Math.random() * ((listeNationalites.length - 0) + 1))];
    idJoueur = compt++;

  }

  public void changerEquipeActuelle(String nouvelleEquipe){
    EquipeActuelle = nouvelleEquipe;
  }




}
