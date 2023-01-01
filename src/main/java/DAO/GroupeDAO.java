package main.java.DAO;

import main.java.ConnexionJDBC.ConnexionBD;
import main.java.Donnee.Groupe;
import main.java.InterfaceDAO.DAOInterface;

import java.sql.*;

public class GroupeDAO implements DAOInterface<Groupe> {

    private ConnexionBD connexionBD = new ConnexionBD();
    private Connection connexion = connexionBD.getConnexion();

    public GroupeDAO(Connection connexion){
        this.connexion = connexion;
    }


    public Groupe FindById(int id) {

        Groupe group = null;

        try {
            PreparedStatement statement = connexion.prepareStatement("SELECT * FROM Groupes WHERE id = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int userId = result.getInt("id_groupe");
                String nomGroupe = result.getString("nom_groupe");

                group = new Groupe(userId, nomGroupe);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return group;
    }


    public void Insert(Groupe group){
        if(group != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("INSERT INTO Groupes" +
                        "(id_groupe,nom_groupe" +
                        "VALUES (?,?");
                statement.setInt(1, group.getId());
                statement.setString(1, group.getNom());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void Update(Groupe group){
        if(group != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("UPDATE Groupes" +
                        "SET id_groupe = ?, nom_groupe = ?" +
                        "WHERE id_groupe = ?");
                statement.setInt(1, group.getId());
                statement.setString(1, group.getNom());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void Delete(Groupe group) {
        if(group != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("DELETE FROM Groupes" +
                        "WHERE id_groupe = ?");
                statement.setInt(1, group.getId());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
