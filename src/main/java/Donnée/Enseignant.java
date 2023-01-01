package main.java.Donnée;

public class Enseignant {

    private int id;
    private String first_name;
    private String lastName;
    private String couleur;
    private int idConnexion;



    public Enseignant(int id, String lastName, String firstName, String couleur, int idConnexion) {
        this.id = id;
        this.lastName = lastName;
        this.first_name = firstName;
        this.couleur = couleur;
        this.idConnexion = idConnexion;
    }


    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCouleur() {
        return couleur;
    }

    public int getIdConnexion() {
        return idConnexion;
    }
}
