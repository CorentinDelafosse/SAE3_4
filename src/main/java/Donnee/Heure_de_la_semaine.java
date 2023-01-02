package main.java.Donnee;

public class Heure_de_la_semaine {
    private int groupe;
    private int matiere;
    private int nbHeure;
    private int heureCM;
    private int heureTD;
    private int heureTP;

    public Heure_de_la_semaine(int groupe, int matiere, int nbHeure, int heureCM, int heureTD, int heureTP) {
        this.groupe = groupe;
        this.matiere = matiere;
        this.nbHeure = nbHeure;
        this.heureCM = heureCM;
        this.heureTD = heureTD;
        this.heureTP = heureTP;
    }


    public int getGroupe() {
        return groupe;
    }

    public int getMatiere() {
        return matiere;
    }

    public int getNbHeure() {
        return nbHeure;
    }

    public int getHeureCM() {
        return heureCM;
    }

    public int getHeureTD() {
        return heureTD;
    }

    public int getHeureTP() {
        return heureTP;
    }

    @Override
    public String toString() {
        return "Heure_de_la_semaine{" +
                "groupe=" + groupe +
                ", matiere=" + matiere +
                ", nbHeure=" + nbHeure +
                ", heureCM=" + heureCM +
                ", heureTD=" + heureTD +
                ", heureTP=" + heureTP +
                '}';
    }
}
