/** Classe permettant de gerer un match entre deux equipes*/
public class Match{
  private Equipe equipe1;
  private Equipe equipe2;
  private double probaVictoireE1 ;
  private double probaVictoireE2 ;
  private double probaBlessure=0.001;
  private int nbToursE1 = 0;
  private int nbToursE2 = 0;
  private int nbButsE1 = 0;
  private int nbButsE2 = 0;

/** Instance de match entre deux equipe passé en parametre, leur probabilité est calculé selon la difference de general entre
   *les deux équipes  ainsi que la competence du coach des deux equipes
   */

  public Match(Equipe equipe1, Equipe equipe2){
    this.equipe1 = equipe1;
    this.equipe2 = equipe2;

    probaVictoireE1=0.5+(((((double)(equipe1.getGeneralEquipe())-(double)(equipe2.getGeneralEquipe()))/1000000)+(double)(equipe1.getCoach().getCompetence())/100));
    probaVictoireE2=0.5+(((((double)(equipe2.getGeneralEquipe())-(double)(equipe1.getGeneralEquipe()))/1000000)+(double)(equipe2.getCoach().getCompetence())/100));

  }

/** Permet de simuler le deroulé d'un match entre deux equipes : Au début ou regarde si les 11 joueurs de l'équipe sont aptes a joueur, si ce n'est pas le cas
   *l'equipe avec le joueur blessé se doit de porter forfait et de remplacer le joueur par un nouveau.
   *Puis grace a un systeme de tours de jeu (obtenu selon l'aleatoire, et les variable de probaVictoire)
   *puis de buts marques à chaque tours selon le meme procedé, le vainqueur du match est alors decidé
*/

  public void simulationMatch() {//throws JoueursManquantException

	// On regarde si les deux equipes on bien  11 joueurs de valides, si l'un d'entre est blessé, l'equipe se doit de declaré forfait et le joueur est alors remplacé

	if(equipe1.estComplete()==false){
    System.out.println("L'equipe de "+equipe1.getNomEquipe()+" dispose d'un blesse et ne peut pas jouer ce match");
    System.out.println("");
		equipe2.victoire();
    equipe1.defaite();
    equipe1.remplacerJoueur(equipe1.getBlesse());
  	System.out.println(equipe2.getNomEquipe()+" a battu "+equipe1.getNomEquipe());
    System.out.println("");

    //throw new JoueursManquantException("Joueur Manquant");
	}
	if(equipe2.estComplete()==false){
    System.out.println("L'equipe de "+equipe2.getNomEquipe()+" dispose d'un blesse et ne peut pas jouer ce match");
    System.out.println("");
		equipe1.victoire();
  	equipe2.defaite();
    equipe2.remplacerJoueur(equipe2.getBlesse());
    System.out.println(equipe1.getNomEquipe()+" a battu "+equipe2.getNomEquipe());
    System.out.println("");

    //throw new JoueursManquantException("Joueur Manquant");
	}

    /* Les Matchs se derouleront selon le systeme suivant :
    On ajuste la probaVictoire de chaque equipe en fonction de leurs statistiques.
    On fait une boucle qui s'arrete a 10 (par soucis de realisme) qui ajoute un tour au nombre de tour de l'equipe si le nombreAleatoire est inferieure a probaVictoire
    On a ensuite une probabilite probaVictoire de marquer un but a chaque tour.
    L'equipe victorieuse est l'equipe qui a marque le plus de buts.
    Si les nb de buts marques de chaque equipe sont egaux il y a match nul.
    */


    //Attribution du nombre de tours pour chaque equipe

    for(int i = 0; i < 10; i++){
		  double alea=Math.random();
		  if(alea < probaVictoireE1){
        nbToursE1 += 1;
      }
      if(alea < probaVictoireE2){
      	nbToursE2 += 1;
      }
    }

    //Debut du match, les buts sont marques avec une probabilite probaVictoire a chaque tour. Le nombre de tours a ete donne precedemment.

	for(int i = 0; i < nbToursE1; i++){
    	double alea=Math.random();
		  if(alea < probaVictoireE1){
        nbButsE1 += 1;
     	}
	}
	for(int i = 0; i < nbToursE2; i++){
    	double alea=Math.random();
     	if(alea < probaVictoireE2){
        	nbButsE2 += 1;
    	}
    }
	//Gestion de la blessure des joueurs de chaque equipe : Les joueurs une probabilité "probaBlessure" de se blesser, ils sont alors retirés de leur equipe
	//et plus apte a jouer au prochain match.
	for (int i=0;i < 11; i++){
		double alea=Math.random();
		if(alea < probaBlessure){
        	equipe1.blessureJoueur(i);
        }
	}
	for (int i=0;i < 11; i++){
		double alea=Math.random();
		if(alea < probaBlessure){
        	equipe2.blessureJoueur(i);
        }
	}
    //Fin du match

    //Application des resultats du match aux equipes participantes.

    if(nbButsE1 > nbButsE2){
      equipe1.victoire();
      equipe2.defaite();

      equipe1.nombreButsMarques(nbButsE1);
      equipe2.nombreButsMarques(nbButsE2);

      System.out.println(equipe1.getNomEquipe()+" a battu "+equipe2.getNomEquipe()+". Le score est de : "+nbButsE1+" - "+nbButsE2);
      System.out.println("");
    }
    if(nbButsE1 < nbButsE2){
      equipe1.defaite();
      equipe2.victoire();

      equipe1.nombreButsMarques(nbButsE1);
      equipe2.nombreButsMarques(nbButsE2);

      System.out.println(equipe2.getNomEquipe()+" a battu "+equipe1.getNomEquipe()+". Le score est de : "+nbButsE1+" - "+nbButsE2);
      System.out.println("");
    }
    if(nbButsE1 == nbButsE2){
      equipe1.matchNul();
      equipe2.matchNul();

      equipe1.nombreButsMarques(nbButsE1);
      equipe2.nombreButsMarques(nbButsE2);

      System.out.println(equipe2.getNomEquipe()+" et "+equipe1.getNomEquipe()+" on fait match nul. Le score est de : "+nbButsE1+" - "+nbButsE2);
      System.out.println("");
    }


  }



}
