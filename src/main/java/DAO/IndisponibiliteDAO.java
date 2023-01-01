package main.java.DAO;

import main.java.ConnexionJDBC.ConnexionBD;
import main.java.Donnee.Indisponibilite;

import java.sql.*;

public class IndisponibiliteDAO {
    private ConnexionBD connexionBD = new ConnexionBD();
    private Connection connexion = connexionBD.getConnexion();

    public IndisponibiliteDAO(Connection connexion){
        this.connexion = connexion;
    }


    public Indisponibilite FindById(int id, Date date) {

        Indisponibilite indisponible = null;

        try {
            PreparedStatement statement = connexion.prepareStatement("SELECT * FROM Indisponibilites WHERE jour_indisponibilite LIKE ?");
            statement.setDate(1, date);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                Date jour = result.getDate("jour_indisponibilite");
                Time horaire = result.getTime("horaire_indisponibilite");

                indisponible = new Indisponibilite(jour, horaire);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return indisponible;
    }


    public void Insert(Indisponibilite indisponible){
        if(indisponible != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("INSERT INTO Indisponibilites" +
                        "(jour_indisponibilite, horaire_indisponibilite)" +
                        "VALUES (?,?");
                statement.setDate(1, indisponible.getJour());
                statement.setTime(1, indisponible.getHoraire());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void Update(Indisponibilite indisponible){
        if(indisponible != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("UPDATE Indisponibilites" +
                        "SET jour_indisponibilite = ?, horaire_indisponibilite = ?" +
                        "WHERE jour_indisponibilite LIKE ?");
                statement.setDate(1, indisponible.getJour());
                statement.setTime(1, indisponible.getHoraire());
                statement.setDate(1, indisponible.getJour());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void Delete(Indisponibilite indisponible) {
        if(indisponible != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("DELETE FROM Indisponibilites" +
                        "WHERE jour_indisponibilite LIKE ?");
                statement.setDate(1, indisponible.getJour());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
