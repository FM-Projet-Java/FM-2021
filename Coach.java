public class Coach extends Staff{
	
	public Coach(){
		super();
	}
	public Coach(String nom){
		super(nom);
	}
	public Coach(String nom, String nationalite){
		super(nom,nationalite);
	}
	public String getRole(){
		return "Coach";
	};
}
