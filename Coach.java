package JavaFootballSimulation;
/** Coach de l'équipe , il influe l'issu des matchs*/
public class Coach extends Staff{

/** Constructeur sans paramètre */

	public Coach(){
		super();
	}

/** Constructeur à un paramètres, le nom */
	public Coach(String nom){
		super(nom);
	}

/** Constructeur à deux paramètres : nom et nationalite */
	public Coach(String nom, String nationalite){
		super(nom,nationalite);
	}
	public String getRole(){ // retourne le role de cette personne, ici : Coach
		return "Coach";
	}

	public String toString(){
		return super.toString()+getRole();
	}
}
