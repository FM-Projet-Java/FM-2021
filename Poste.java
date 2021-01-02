public class Poste{
  private String listePostes = {"AG","A","AD","MG","MOC","MD","MDC","DG","DC","DD","G"};
  private String poste;

  public Poste(){ //Donne un poste aléatoire
    poste = listePostes[0 + (int)(Math.random() * ((listePostes.length - 0) + 1))]
  }

  public Poste(String poste){
    int i;
    for(i = 0; i < listePostes.length; i++){
      if(listePostes[i] == poste)
        this.poste = poste;
      else
        System.out.println("Le poste saisis ne correspond a aucun poste existant. Un poste aleatoire a ete assigne.");
        Poste();
    }
  }
}
