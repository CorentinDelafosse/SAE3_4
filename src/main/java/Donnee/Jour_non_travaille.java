package main.java.Donnee;

import java.sql.*;

public class Jour_non_travaille {
    private Date date;
    private String raison;

    public Jour_non_travaille(Date date, String raison) {
        this.date = date;
        this.raison = raison;
    }

    public Date getDate() {
        return date;
    }

    public String getRaison() {
        return raison;
    }
}
