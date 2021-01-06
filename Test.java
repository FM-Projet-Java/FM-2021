public class Test{
	public static void main(String[] args){
	Joueur []Equipe=new Joueur[11];
	for(int i=0;i<Equipe.length;i++){
		Equipe[i]=new Joueur();
		Equipe[6]=null;
		System.out.println(Equipe[i]);
	}
	}
}
