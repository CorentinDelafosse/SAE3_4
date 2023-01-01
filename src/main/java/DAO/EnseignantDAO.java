package main.java.DAO;

import main.java.ConnexionJDBC.ConnexionBD;
import main.java.Donnée.Enseignant;
import main.java.InterfaceDAO.EnseignantDAOInterface;

import java.sql.*;

public class EnseignantDAO implements EnseignantDAOInterface {

    private ConnexionBD connexionBD = new ConnexionBD();
    private Connection connexion = connexionBD.getConnexion();

    public EnseignantDAO(Connection connexion){
        this.connexion = connexion;
    }


    public Enseignant FindById(int id) {

        Enseignant user = null;

        try {
            PreparedStatement statement = connexion.prepareStatement("SELECT * FROM Enseignants WHERE id = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int userId = result.getInt("id_enseignant");
                String lastName = result.getString("nom_enseignant");
                String firstName = result.getString("prenom_enseignant");
                String couleur = result.getString("couleur_enseignant");
                int idConnexion = result.getInt("id_connexion");

                user = new Enseignant(userId, lastName, firstName, couleur, idConnexion);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return user;
    }


    public void Insert(Enseignant user){
        if(user != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("INSERT INTO Enseignants" +
                        "(id_enseignant,nom_enseignant,prenom_etudiant,couleur_enseignant,id_connexion" +
                        "VALUES (?,?,?,?,?");
                statement.setInt(1, user.getId());
                statement.setString(1, user.getLastName());
                statement.setString(1, user.getFirst_name());
                statement.setString(1, user.getCouleur());
                statement.setInt(1, user.getIdConnexion());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void Update(Enseignant user){
        if(user != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("UPDATE Enseignants" +
                        "SET id_enseignant = ?, nom_çenseignant = ?, prenom_enseignant = ?, couleur_enseignant = ?" +
                        ",id_connexion = ?" +
                        "WHERE id_enseignant = ?");
                statement.setInt(1, user.getId());
                statement.setString(1, user.getLastName());
                statement.setString(1, user.getFirst_name());
                statement.setString(1, user.getCouleur());
                statement.setInt(1, user.getIdConnexion());
                statement.setInt(1, user.getId());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void Delete(Enseignant user) {
        if(user != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("DELETE FROM Enseignants" +
                        "WHERE id_enseignant = ?");
                statement.setInt(1, user.getId());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
