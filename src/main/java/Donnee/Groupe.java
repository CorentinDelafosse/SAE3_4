package main.java.Donnee;

public class Groupe {

    private int id;
    private String nom;


    public Groupe(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }


    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Groupe{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
