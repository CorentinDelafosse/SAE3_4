package main.java.Donnee;

public class Connexion {
    private int id;
    private String id_connexion;
    private String mdp;
    private String status;

    public Connexion(int id, String id_connexion, String mdp, String status) {
        this.id = id;
        this.id_connexion = id_connexion;
        this.mdp = mdp;
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public String getId_connexion() {
        return id_connexion;
    }

    public String getMdp() {
        return mdp;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Connexion{" +
                "id=" + id +
                ", id_connexion='" + id_connexion + '\'' +
                ", mdp='" + mdp + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
