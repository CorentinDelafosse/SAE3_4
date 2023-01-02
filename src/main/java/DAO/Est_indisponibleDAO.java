package main.java.DAO;

import main.java.ConnexionJDBC.ConnexionBD;
import main.java.Donnee.Est_indisponible;
import main.java.InterfaceDAO.DAOInterface;

import java.sql.*;

public class Est_indisponibleDAO implements DAOInterface<Est_indisponible> {

    private ConnexionBD connexionBD = new ConnexionBD();
    private Connection connexion = connexionBD.getConnexion();

    public Est_indisponibleDAO(Connection connexion){
        this.connexion = connexion;
    }


    public Est_indisponible FindById(int id, String date) {

        Est_indisponible indisponible = null;

        try {
            PreparedStatement statement = connexion.prepareStatement("SELECT * FROM Est_indisponible WHERE id_enseignant = ? and jour_indisponibilite LIKE ?");
            statement.setInt(1, id);
            statement.setString(2, date);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int enseignant = result.getInt("id_enseignant");
                String jour = result.getString("jour_indisponibilite");
                Time horaire = result.getTime("horaire_indisponibilite");
                String raison = result.getString("raison");

                indisponible = new Est_indisponible(enseignant, jour, horaire, raison);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return indisponible;
    }


    public void Insert(Est_indisponible indisponible){
        if(indisponible != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("INSERT INTO Est_indisponible" +
                        "(id_enseignant, jour_indisponibilite, horaire_indisponibilite, raison)" +
                        "VALUES (?,?,?,?)");
                statement.setInt(1, indisponible.getEnseignant());
                statement.setString(1, indisponible.getDate());
                statement.setTime(1, indisponible.getHoraire());
                statement.setString(1, indisponible.getRaison());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void Update(Est_indisponible indisponible){
        if(indisponible != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("UPDATE Est_indisponible" +
                        "SET id_enseignant = ?, jour_indisponibilite = ?, horaire_indisponibilite = ?, raison = ?" +
                        "WHERE id_enseignant = ? and jour_indisponibilite LIKE ?");
                statement.setInt(1, indisponible.getEnseignant());
                statement.setString(1, indisponible.getDate());
                statement.setTime(1, indisponible.getHoraire());
                statement.setString(1, indisponible.getRaison());
                statement.setInt(1, indisponible.getEnseignant());
                statement.setString(1, indisponible.getDate());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void Delete(Est_indisponible indisponible) {
        if(indisponible != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("DELETE FROM Est_indisponible" +
                        "WHERE id_enseignant = ? and jour_indisponibilite = ?");
                statement.setInt(1, indisponible.getEnseignant());
                statement.setString(1, indisponible.getDate());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
