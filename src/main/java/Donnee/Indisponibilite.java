package main.java.Donnee;

import java.sql.*;

public class Indisponibilite {
    private String jour;
    private Time horaire;


    public Indisponibilite(String jour, Time horaire) {
        this.jour = jour;
        this.horaire = horaire;
    }


    public String getJour() {
        return jour;
    }

    public Time getHoraire() {
        return horaire;
    }

    @Override
    public String toString() {
        return "Indisponibilite{" +
                "jour=" + jour +
                ", horaire=" + horaire +
                '}';
    }
}
