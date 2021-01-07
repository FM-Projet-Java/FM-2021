/** Classe abstraite correspondant aux membre du staff, ayant chacun un niveau de competence , (un membre de staff n'existe pas, mais un coach si ;) */
public abstract class Staff extends Personne{
	private int competence; //Competence du membre du staff allant de 5 à 10

/** Constructeur sans parametre qui initatilise competence entre 5 et 10 de maniere aleatoire*/

	public Staff(){
		super();
		competence=5+(int)(Math.random() * 4);
	}

/** Constructeur a un paramètre , le nom */

	public Staff(String nom){
		super(nom);
		competence=5+(int)(Math.random() * 4);
	}

/** Constructeur à deux paramètres , le nom et la Nationalite*/

	public Staff(String nom, String nationalite){
		super(nom,nationalite);
		competence=5+(int)(Math.random() * 4);
	}


	public int  getCompetence(){return competence;} // Retourne la valeur de competence du membre du staff

	public String toString(){
		String res=super.toString();
		res+="Niveau de competence : "+competence+"/10";
		return res;
	}
}
