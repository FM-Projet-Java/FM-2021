package JavaFootballSimulation;
/** Entraineur Physique de l'equipe, il influe les entrainements*/
public class EntraineurPhysique extends Staff{

/** Constructeur sans paramètre */

	public EntraineurPhysique(){
		super();
	}

/** Constructeur à un paramètres, le nom */
	public EntraineurPhysique(String nom){
		super(nom);
	}

/** Constructeur à deux paramètres : nom et nationalite */
	public EntraineurPhysique(String nom, String nationalite){
		super(nom,nationalite);
	}

	public String getRole(){
		return "Entraineur Physique";
	}

	public String toString(){ //retourne le role de cette personne, ici : Coach
		return super.toString()+getRole();
	}
}
