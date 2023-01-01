package main.java.Donnee;

public class Etudie {
    private int enseignant;
    private int groupe;
    private int matiere;
    private int salle;
    private int cours;


    public Etudie(int enseignant, int groupe, int matiere, int salle, int cours) {
        this.enseignant = enseignant;
        this.groupe = groupe;
        this.matiere = matiere;
        this.salle = salle;
        this.cours = cours;
    }


    public int getEnseignant() {
        return enseignant;
    }

    public int getGroupe() {
        return groupe;
    }

    public int getMatiere() {
        return matiere;
    }

    public int getSalle() {
        return salle;
    }

    public int getCours() {
        return cours;
    }
}
