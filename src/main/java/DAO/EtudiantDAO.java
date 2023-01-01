package main.java.DAO;

import main.java.ConnexionJDBC.ConnexionBD;
import main.java.Donnee.Etudiant;
import main.java.InterfaceDAO.DAOInterface;

import java.sql.SQLException;
import java.sql.*;

public class EtudiantDAO implements DAOInterface<Etudiant> {

    private Etudiant user = null;
    private ConnexionBD connexionBD = new ConnexionBD();
    private Connection connexion = connexionBD.getConnexion();

    public EtudiantDAO(Connection connexion){
        this.connexion = connexion;
    }


    public Etudiant FindById(int id, Date date) {

        try {
            PreparedStatement statement = connexion.prepareStatement("SELECT * FROM Etudiants WHERE id_etudiant = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int userId = result.getInt("id_etudiant");
                String lastName = result.getString("nom_etudiant");
                String firstName = result.getString("prenom_etudiant");
                int age = result.getInt("age_etudiant");
                int promo = result.getInt("promo_etudiant");
                int idConnexion = result.getInt("id_connexion");
                int idGroupe = result.getInt("id_groupe");

                user = new Etudiant(userId, lastName, firstName, age, promo, idConnexion, idGroupe);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return user;
    }


    public void Insert(Etudiant user){
        if(user != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("INSERT INTO Etudiants" +
                        "(id_etudiant,nom_etudiant,prenom_etudiant,age_etudiant,promo_etudiant,id_connexion,id_groupe)" +
                        "VALUES (?,?,?,?,?,?,?)");
                statement.setInt(1, user.getId());
                statement.setString(1, user.getLastName());
                statement.setString(1, user.getFirst_name());
                statement.setInt(1, user.getAge());
                statement.setInt(1, user.getPromo());
                statement.setInt(1, user.getIdConnexion());
                statement.setInt(1, user.getIdGroupe());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void Update(Etudiant user){
        if(user != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("UPDATE Etudiants" +
                "SET id_etudiant = ?, nom_etudiant = ?, prenom_etudiant = ?, age_etudiant = ?" +
                        "promo_etudiant = ?, id_connexion = ?, id_groupe = ?" +
                        "WHERE id_etudiant = ?");
                statement.setInt(1, user.getId());
                statement.setString(1, user.getLastName());
                statement.setString(1, user.getFirst_name());
                statement.setInt(1, user.getAge());
                statement.setInt(1, user.getPromo());
                statement.setInt(1, user.getIdConnexion());
                statement.setInt(1, user.getIdGroupe());
                statement.setInt(1, user.getId());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void Delete(Etudiant user) {
        if(user != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("DELETE FROM Etudiants" +
                        "WHERE id_etudiant = ?");
                statement.setInt(1, user.getId());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
