package JavaFootballSimulation;
/** Classe abstraite correspondant a une personne, elle sert a generer nom et nationalite ( ainsi qu'un identifiant) */
public abstract class Personne{
	private static int cpt=1;
	private int id;
	private String nationalite;
	private String nom;

/** Constructeur sans paramètre */
	public Personne(){
		id=cpt++;
		nationalite=Generate.Nationalite();
		nom=Generate.Nom(nationalite);
	}

/** Constructeur à un paramètres, le nom */
	public Personne(String nom){
		id=cpt++;
		nationalite=Generate.Nationalite();
		this.nom=nom;
	}

/** Constructeur à deux paramètres : nom et nationalite */
	public Personne(String nom, String nationalite){
		id=cpt++;
		this.nationalite=nationalite;
		this.nom=nom;
	}

	public String getNom(){ // retourne le nom de la personne
		return nom;
	}

	public String getNationalite(){ // retourne la nationatlite de la personne
		return nationalite;
	}

	public String toString(){
		return  "[ -"+id+"- "+nom+" , "+nationalite+" ]";
	}
/** Méthode abstraite permettant d'obtenir le role (nom de classe) des ses classes filles */
	public abstract String getRole();
}
