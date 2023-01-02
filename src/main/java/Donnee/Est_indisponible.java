package main.java.Donnee;

import java.sql.*;

public class Est_indisponible {
    private int enseignant;
    private String date;
    private Time horaire;
    private String raison;

    public Est_indisponible(int enseignant, String date, Time horaire, String raison) {
        this.enseignant = enseignant;
        this.date = date;
        this.horaire = horaire;
        this.raison = raison;
    }


    public int getEnseignant() {
        return enseignant;
    }

    public String getDate() {
        return date;
    }

    public Time getHoraire() {
        return horaire;
    }

    public String getRaison() {
        return raison;
    }

    @Override
    public String toString() {
        return "Est_indisponible{" +
                "enseignant=" + enseignant +
                ", date=" + date +
                ", horaire=" + horaire +
                ", raison='" + raison + '\'' +
                '}';
    }
}
