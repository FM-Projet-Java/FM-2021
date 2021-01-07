/** Genere une nationalite, ainsi qu'un nom et prenom aleatoirement selon des listes predefinis en variable d'instance final*/
public class Generate{

	private static final String[] listeNationalites = {"Francais","Allemand","Anglais","Espagnol"};
  	private static final String[] listeNomJoueursFr = {"Martin","Bernard","Thomas","Petit","Robert","Richard","Durand","Dubois","Moreau","Laurent"};
  	private static final String[] listeNomJoueursEsp = {"Abril","Bautista","Cabrero","Delgado","Escobar","Franco","Garcea","Hortelano","Lutero","Mendoza"};
  	private static final String[] listeNomJoueursAng = 	{"Smith","Jones","Williams","Brown","Taylor","Davies","Wilson","Evans","Thomas","Roberts","Johnson","Miller","Davis","Garcia","Rodriguez"};
  	private static final String[] listeNomJoueursAll = {"Bauer","Baumann","Becker","Fischer","Hoffmann","Kauffmann","Keller","Koch","Schmidt","Schneider"};
  	private static final String[] listePrenomJoueursFr = {"Jean","Pierre","Michel","Philippe","Louis","Alain","Jacques","Bernard","Marcel","Robert","Paul","Christian","Nicolas"};
  	private static final String[] listePrenomJoueursEsp = {"Hugo","Diego","Elio","Pablo","Elias","Esteban","Lorenzo","Ruben","Luis","Lisandro","Paco","Miguel"};
  	private static final String[] listePrenomJoueursAng = {"Bradley","Michael","Matthew","Joshua","Nicholas","Christopher","Joseph","Ethan","Andrew","Daniel","William","Anthony"};
  	private static final String[] listePrenomJoueursAll = {"Stephan","Wilfried","Ludwig","Lukas","Erwin","Hermann","Franz","Kurt","Fritz","Siegfried","Leni"};

/** Retourne une nationalite aleatoire*/

  	public static String Nationalite(){
  	return listeNationalites[(int)(Math.random() * (listeNationalites.length))];
  	}

/** Retourne une combinaison nom + prenom aleatoire en fonction de la nationalite passé en parametre*/

  	public static String Nom(String nationalite){
  	if(nationalite == "Francais")
    return listePrenomJoueursFr[(int)(Math.random() * (listePrenomJoueursFr.length))]+" "+listeNomJoueursFr[(int)(Math.random() * (listeNomJoueursFr.length))];
    if(nationalite == "Allemand")
    return listePrenomJoueursAll[(int)(Math.random() * (listePrenomJoueursAll.length))]+" "+listeNomJoueursAll[(int)(Math.random() *   (listeNomJoueursAll.length))];
    if(nationalite == "Anglais")
    return listePrenomJoueursAng[(int)(Math.random() * (listePrenomJoueursAng.length))]+" "+listeNomJoueursAng[(int)(Math.random() * (listeNomJoueursAng.length))];
    if(nationalite == "Espagnol")
    return listePrenomJoueursEsp[(int)(Math.random() * (listePrenomJoueursEsp.length))]+" "+listeNomJoueursEsp[(int)(Math.random() * (listeNomJoueursEsp.length))];
    return "...";
  	}
}
