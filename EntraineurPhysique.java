public class EntraineurPhysique extends Staff{
	
	public EntraineurPhysique(){
		super();
	}
	public EntraineurPhysique(String nom){
		super(nom);
	}
	public EntraineurPhysique(String nom, String nationalite){
		super(nom,nationalite);
	}
	
	public String getRole(){
		return "Entraineur Physique";
	};
}
