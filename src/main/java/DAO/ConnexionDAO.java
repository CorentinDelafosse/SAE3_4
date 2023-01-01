package main.java.DAO;

import main.java.ConnexionJDBC.ConnexionBD;
import main.java.Donnee.Connexion;
import main.java.InterfaceDAO.DAOInterface;

import java.sql.*;

public class ConnexionDAO implements DAOInterface<Connexion> {

    private ConnexionBD connexionBD = new ConnexionBD();
    private Connection connexion = connexionBD.getConnexion();

    public ConnexionDAO(Connection connexion){
        this.connexion = connexion;
    }


    public Connexion FindById(int id, Date date) {

        Connexion compte = null;

        try {
            PreparedStatement statement = connexion.prepareStatement("SELECT * FROM Connexion WHERE id = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int Id = result.getInt("id");
                String idConnexion = result.getString("id_connexion");
                String mdp = result.getString("mdp_connexion");
                String status = result.getString("status_connexion");

                compte = new Connexion(Id, idConnexion, mdp, status);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return compte;
    }


    public void Insert(Connexion compte){
        if(compte != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("INSERT INTO Connexion" +
                        "(id, id_connexion, mdp_connexion, status_connexion)" +
                        "VALUES (?,?,?,?)");
                statement.setInt(1, compte.getId());
                statement.setString(1, compte.getId_connexion());
                statement.setString(1, compte.getMdp());
                statement.setString(1, compte.getStatus());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void Update(Connexion compte){
        if(compte != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("UPDATE Connexion" +
                        "SET id = ?, id_connexion = ?, mdp_connexion = ?, status_connexion = ?" +
                        "WHERE id = ?");
                statement.setInt(1, compte.getId());
                statement.setString(1, compte.getId_connexion());
                statement.setString(1, compte.getMdp());
                statement.setString(1, compte.getStatus());
                statement.setInt(1, compte.getId());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void Delete(Connexion compte) {
        if(compte != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("DELETE FROM Connexion" +
                        "WHERE id = ?");
                statement.setInt(1, compte.getId());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
