public abstract class Personne{
	private static int cpt=1;
	private int id;
	private String nationalite;
	private String nom;
	
	public Personne(){
		id=cpt++;
		nationalite=Generate.Nationalite();
		nom=Generate.Nom(nationalite);
	}
	public Personne(String nom){
		id=cpt++;
		nationalite=Generate.Nationalite();
		this.nom=nom;
	}
	public Personne(String nom, String nationalite){
		id=cpt++;
		this.nationalite=nationalite;
		this.nom=nom;
	}
	
	public String getNom(){
		return nom;
	}
	
	public String getNationalite(){
		return nationalite;
	}
	
	public String toString(){
		return  "[ -"+id+"- "+nom+" , "+nationalite+" ]";
	}
}
