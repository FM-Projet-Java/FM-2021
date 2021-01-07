/** Gere l'exception lorsque un joueur manque à l'effectif d'une equipe*/
public class JoueursManquantException extends Exception{
	public JoueursManquantException(String message){
		super(message);
	}
	public String toString(){
		return " Equipe non complète ";
	}
}
