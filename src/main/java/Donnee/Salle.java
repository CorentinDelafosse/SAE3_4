package main.java.Donnee;

public class Salle {
    private int id;
    private String type;
    private int nombrePlace;
    private boolean dejaPrise = false;

    public Salle(int id, String type, int nombrePlace, boolean dejaPrise) {
        this.id = id;
        this.type = type;
        this.nombrePlace = nombrePlace;
        this.dejaPrise = dejaPrise;
    }


    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getNombrePlace() {
        return nombrePlace;
    }

    public boolean isDejaPrise() {
        return dejaPrise;
    }

    @Override
    public String toString() {
        return "Salle{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", nombrePlace=" + nombrePlace +
                ", dejaPrise=" + dejaPrise +
                '}';
    }
}
