package main.java.Donnee;

import java.sql.*;

public class Est_indisponible {
    private int enseignant;
    private Date date;
    private Time horaire;
    private String raison;

    public Est_indisponible(int enseignant, Date date, Time horaire, String raison) {
        this.enseignant = enseignant;
        this.date = date;
        this.horaire = horaire;
        this.raison = raison;
    }


    public int getEnseignant() {
        return enseignant;
    }

    public Date getDate() {
        return date;
    }

    public Time getHoraire() {
        return horaire;
    }

    public String getRaison() {
        return raison;
    }
}
