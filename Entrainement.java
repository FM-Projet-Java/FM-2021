package JavaFootballSimulation;
import java.util.ArrayList;
/**  Classe permettant d'incorporer des methodes static : entrainement , dans le but d'ameliorer les equipes */
public class Entrainement {

//* Prend en paramètre une equipe, et ameliore le general de chacun de ses joueurs*/

	public static void EntrainementEquipe(Equipe equipe){
		Joueur [] joueurs=equipe.getJoueur();
		for(int i=0;i<joueurs.length;i++){
			joueurs[i].ameliorerGeneral();
		}
	}

//* Prend en paramètre une liste d'équipe, et entraine chacune de ces equipes */

	public static void Entrainement(ArrayList<Equipe> equipes){
			for(int i = 0; i < equipes.size(); i++){
				EntrainementEquipe(equipes.get(i));
			}
			System.out.println("les Equipes s'entrainent !");
	}

}
