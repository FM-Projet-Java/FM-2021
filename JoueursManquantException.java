public class JoueursManquantExcepetion extends Exception{
	public JoueursManquantExcepetion(String message){
		super(message);
	}
	public String toString(){
		return " Equipe non complète ";
	}
}
