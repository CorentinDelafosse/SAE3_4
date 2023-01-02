package main.java.DAO;

import main.java.ConnexionJDBC.ConnexionBD;
import main.java.Donnee.Enseigne;
import main.java.InterfaceDAO.DAOInterface;

import java.sql.*;

public class EnseigneDAO implements DAOInterface<Enseigne> {

    private ConnexionBD connexionBD = new ConnexionBD();
    private Connection connexion = connexionBD.getConnexion();

    public EnseigneDAO(Connection connexion){
        this.connexion = connexion;
    }


    public Enseigne FindById(int id, String date) {

        Enseigne cours = null;

        try {
            PreparedStatement statement = connexion.prepareStatement("SELECT * FROM Enseigne WHERE id_enseignant = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int enseignant = result.getInt("id_enseignant");
                int matiere = result.getInt("id_matiere");

                cours = new Enseigne(enseignant, matiere);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return cours;
    }


    public void Insert(Enseigne cours){
        if(cours != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("INSERT INTO Enseigne" +
                        "(id_enseignant, id_matiere)" +
                        "VALUES (?,?)");
                statement.setInt(1, cours.getEnseignant());
                statement.setInt(1, cours.getMatiere());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void Update(Enseigne cours){
        if(cours != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("UPDATE Enseigne" +
                        "SET id_enseignant = ?, id_matiere = ?" +
                        "WHERE id_groupe = ? and id_matiere != ?");
                statement.setInt(1, cours.getEnseignant());
                statement.setInt(1, cours.getMatiere());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void Delete(Enseigne cours) {
        if(cours != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("DELETE FROM Enseigne" +
                        "WHERE id_enseignant = ? and id_matiere = ?");
                statement.setInt(1, cours.getEnseignant());
                statement.setInt(1, cours.getMatiere());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
