package main.java.Donnee;

public class Enseigne {
    private int enseignant;
    private int matiere;

    public Enseigne(int enseignant, int matiere) {
        this.enseignant = enseignant;
        this.matiere = matiere;
    }


    public int getEnseignant() {
        return enseignant;
    }

    public int getMatiere() {
        return matiere;
    }
}
