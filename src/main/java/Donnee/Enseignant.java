package main.java.Donnee;

public class Enseignant {

    private int id;
    private String first_name;
    private String lastName;
    private String couleur;
    private String idConnexion;



    public Enseignant(int id, String lastName, String firstName, String couleur, String idConnexion) {
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

    public String getIdConnexion() {
        return idConnexion;
    }

    @Override
    public String toString() {
        return "Enseignant{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", couleur='" + couleur + '\'' +
                ", idConnexion='" + idConnexion + '\'' +
                '}';
    }
}
