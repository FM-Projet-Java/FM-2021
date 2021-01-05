public class Match{
  private Equipe equipe1;
  private Equipe equipe2;
  private double probaVictoireE1 = 0.5;
  private double probaVictoireE2 = 0.5;
  private int nbToursE1 = 0;
  private int nbToursE2 = 0;
  private int nbButsE1 = 0;
  private int nbButsE2 = 0;

  public Match(Equipe equipe1, Equipe equipe2){
    this.equipe1 = equipe1;
    this.equipe2 = equipe2;
  }


  public void simulationMatch(){

    /* Les Matchs se derouleront selon le systeme suivant :
    On ajuste la probaVictoire de chaque equipe en fonction de leurs statistiques.
    On fait une boucle qui s'arrete a 10 (par soucis de realisme) qui ajoute un tour au nombre de tour de l'equipe si le nombreAleatoire est inferieure a probaVictoire
    On a ensuite une probabilite probaVictoire de marquer un but a chaque tour.
    L'equipe victorieuse est l'equipe qui a marque le plus de buts.
    Si les nb de buts marques de chaque equipe sont egaux il y a match nul.
    */

    int i;
    double nombreAleatoire = Math.random();


    if(equipe1.getGeneralEquipe() > equipe2.getGeneralEquipe()){
      probaVictoireE1 += 0.1;
      probaVictoireE2 -= 0.1;
    }
    else{
      probaVictoireE1 -= 0.1;
      probaVictoireE2 += 0.1;
    }

    //Attribution du nombre de tours pour chaque equipe

    for(i = 0; i < 10; i++){
      if(Math.random() < probaVictoireE1){
        nbToursE1 += 1;
      }
      if(Math.random() < probaVictoireE2){
        nbToursE2 += 1;
      }
    }

    //Debut du match, les buts sont marques avec une probabilite probaVictoire a chaque tour. Le nombre de tours a ete donne precedemment.

    for(i = 0; i < nbToursE1; i++){
      if(Math.random() < probaVictoireE1){
        nbButsE1 += 1;
      }
      if(Math.random() < probaVictoireE2){
        nbButsE2 += 1;
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

      System.out.println(equipe2.getNomEquipe()+" a battu "+equipe1.getNomEquipe()+". Le score est de : "+nbButsE2+" - "+nbButsE1);
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
