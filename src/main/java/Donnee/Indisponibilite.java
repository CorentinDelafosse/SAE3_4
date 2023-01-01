package main.java.Donnee;

import java.sql.*;

public class Indisponibilite {
    private Date jour;
    private Time horaire;


    public Indisponibilite(Date jour, Time horaire) {
        this.jour = jour;
        this.horaire = horaire;
    }


    public Date getJour() {
        return jour;
    }

    public Time getHoraire() {
        return horaire;
    }
}
