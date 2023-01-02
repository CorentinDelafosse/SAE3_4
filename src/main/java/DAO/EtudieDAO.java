package main.java.DAO;

import main.java.ConnexionJDBC.ConnexionBD;
import main.java.Donnee.Etudie;
import main.java.InterfaceDAO.DAOInterface;

import java.sql.*;

public class EtudieDAO implements DAOInterface<Etudie> {

    private ConnexionBD connexionBD = new ConnexionBD();
    private Connection connexion = connexionBD.getConnexion();

    public EtudieDAO(Connection connexion){
        this.connexion = connexion;
    }


    public Etudie FindById(int id, String date) {

        Etudie cours = null;

        try {
            PreparedStatement statement = connexion.prepareStatement("SELECT * FROM Etudie WHERE id_cours = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int enseignant = result.getInt("id_enseignant");
                int groupe = result.getInt("id_groupe");
                int matiere = result.getInt("id_matiere");
                int salle = result.getInt("id_salle");
                int id_cours = result.getInt("id_cours");

                cours = new Etudie(enseignant, groupe, matiere, salle, id_cours);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return cours;
    }


    public void Insert(Etudie cours){
        if(cours != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("INSERT INTO Etudie" +
                        "(id_enseignant, id_groupe, id_matiere, id_salle, id_cours)" +
                        "VALUES (?,?,?,?,?)");
                statement.setInt(1, cours.getEnseignant());
                statement.setInt(1, cours.getGroupe());
                statement.setInt(1, cours.getMatiere());
                statement.setInt(1, cours.getSalle());
                statement.setInt(1, cours.getCours());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void Update(Etudie cours){
        if(cours != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("UPDATE Etudie" +
                        "SET id_enseignant = ?, id_groupe = ?, id_matiere = ?, id_salle = ?, id_cours = ?" +
                        "WHERE id_groupe = ? and id_matiere = ?");
                statement.setInt(1, cours.getEnseignant());
                statement.setInt(1, cours.getGroupe());
                statement.setInt(1, cours.getMatiere());
                statement.setInt(1, cours.getSalle());
                statement.setInt(1, cours.getCours());
                statement.setInt(1, cours.getGroupe());
                statement.setInt(1, cours.getMatiere());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void Delete(Etudie cours) {
        if(cours != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("DELETE FROM Etudie" +
                        "WHERE id_enseignant = ? and id_groupe = ? and id_matiere = ? and id_salle = ?");
                statement.setInt(1, cours.getEnseignant());
                statement.setInt(1, cours.getGroupe());
                statement.setInt(1, cours.getMatiere());
                statement.setInt(1, cours.getSalle());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
