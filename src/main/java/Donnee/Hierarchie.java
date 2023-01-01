package main.java.Donnee;

public class Hierarchie {
    private int idGroupe1;
    private int idGroupe2;
    private String nom;

    public Hierarchie(int idGroupe1, int idGroupe2, String nom) {
        this.idGroupe1 = idGroupe1;
        this.idGroupe2 = idGroupe2;
        this.nom = nom;
    }


    public int getIdGroupe1() {
        return idGroupe1;
    }

    public int getIdGroupe2() {
        return idGroupe2;
    }

    public String getNom() {
        return nom;
    }
}
