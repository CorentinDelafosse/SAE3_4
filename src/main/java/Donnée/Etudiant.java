package main.java.Donnée;

public class Etudiant {

    int id;
    String first_name;
    String lastName;
    int age;
    int promo;
    int idConnexion;
    int idGroupe;


    public Etudiant(int id, String lastName, String firstName, int age, int promo, int idConnexion, int idGroupe) {
        this.id = id;
        this.lastName = lastName;
        this.first_name = firstName;
        this.age = age;
        this.promo = promo;
        this.idConnexion = idConnexion;
        this.idGroupe = idGroupe;
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

    public int getAge() {
        return age;
    }

    public int getPromo() {
        return promo;
    }

    public int getIdConnexion() {
        return idConnexion;
    }

    public int getIdGroupe() {
        return idGroupe;
    }
}
