package main.java.Donnee;

public class Etudiant {

    int id;
    String first_name;
    String lastName;
    int age;
    int promo;
    String idConnexion;
    int idGroupe;


    public Etudiant(int id, String lastName, String firstName, int age, int promo, String idConnexion, int idGroupe) {
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

    public String getIdConnexion() {
        return idConnexion;
    }

    public int getIdGroupe() {
        return idGroupe;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", promo=" + promo +
                ", idConnexion=" + idConnexion +
                ", idGroupe=" + idGroupe +
                '}';
    }
}
