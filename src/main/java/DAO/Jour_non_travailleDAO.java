package main.java.DAO;

import main.java.ConnexionJDBC.ConnexionBD;
import main.java.Donnee.Jour_non_travaille;
import main.java.InterfaceDAO.DAOInterface;

import java.sql.*;

public class Jour_non_travailleDAO implements DAOInterface<Jour_non_travaille> {

    private ConnexionBD connexionBD = new ConnexionBD();
    private Connection connexion = connexionBD.getConnexion();

    public Jour_non_travailleDAO(Connection connexion){
        this.connexion = connexion;
    }


    public Jour_non_travaille FindById(int id, Date date) {

        Jour_non_travaille jour = null;

        try {
            PreparedStatement statement = connexion.prepareStatement("SELECT * FROM Jours_non_travailles WHERE jour_non_travaille LIKE ?");
            statement.setDate(1, date);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                Date dateNonTravaille = result.getDate("jour_non_travaille");
                String raison = result.getString("raison");

                jour = new Jour_non_travaille(dateNonTravaille, raison);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return jour;
    }


    public void Insert(Jour_non_travaille jour){
        if(jour != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("INSERT INTO Jours_non_travailles" +
                        "(jour_non_travaille, raison)" +
                        "VALUES (?,?)");
                statement.setDate(1, jour.getDate());
                statement.setString(1, jour.getRaison());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void Update(Jour_non_travaille jour){
        if(jour != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("UPDATE Jours_non_travailles" +
                        "SET jour_non_travaille = ?, raison = ?" +
                        "WHERE jour_non_travaille LIKE ?");
                statement.setDate(1, jour.getDate());
                statement.setString(1, jour.getRaison());
                statement.setDate(1, jour.getDate());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void Delete(Jour_non_travaille jour) {
        if(jour != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("DELETE FROM Jours_non_travailles" +
                        "WHERE jour_non_travaille LIKE ?");
                statement.setDate(1, jour.getDate());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
