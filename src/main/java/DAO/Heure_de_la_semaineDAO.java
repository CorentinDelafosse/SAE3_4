package main.java.DAO;

import main.java.ConnexionJDBC.ConnexionBD;
import main.java.Donnee.Heure_de_la_semaine;
import main.java.InterfaceDAO.DAOInterface;

import java.sql.*;

public class Heure_de_la_semaineDAO implements DAOInterface<Heure_de_la_semaine> {

    private ConnexionBD connexionBD = new ConnexionBD();
    private Connection connexion = connexionBD.getConnexion();

    public Heure_de_la_semaineDAO(Connection connexion){
        this.connexion = connexion;
    }


    public Heure_de_la_semaine FindById(int id, String date) {

        Heure_de_la_semaine horaire = null;

        try {
            PreparedStatement statement = connexion.prepareStatement("SELECT * FROM Heure_de_la_semaine WHERE id = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int groupe = result.getInt("id_groupe");
                int matiere = result.getInt("id_matiere");
                int nbHeure = result.getInt("nb_heure");
                int heureCM = result.getInt("heure_CM");
                int heureTD = result.getInt("heure_TD");
                int heureTP = result.getInt("heure_TP");

                horaire = new Heure_de_la_semaine(groupe, matiere, nbHeure, heureCM, heureTD, heureTP);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return horaire;
    }


    public void Insert(Heure_de_la_semaine horaire){
        if(horaire != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("INSERT INTO Heure_de_la_semaine" +
                        "(id_groupe, id_matiere, nb_heure, heure_CM, heure_TD, heure_TP)" +
                        "VALUES (?,?,?,?)");
                statement.setInt(1, horaire.getGroupe());
                statement.setInt(1, horaire.getMatiere());
                statement.setInt(1, horaire.getNbHeure());
                statement.setInt(1, horaire.getHeureCM());
                statement.setInt(1, horaire.getHeureTD());
                statement.setInt(1, horaire.getHeureTP());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void Update(Heure_de_la_semaine horaire){
        if(horaire != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("UPDATE Heure_de_la_semaine" +
                        "SET id_groupe = ?, id_matiere = ?, nb_heure = ?, heure_CM = ?, heure_TD = ?, heure_TP = ?" +
                        "WHERE id_groupe = ? and id_matiere = ?");
                statement.setInt(1, horaire.getGroupe());
                statement.setInt(1, horaire.getMatiere());
                statement.setInt(1, horaire.getNbHeure());
                statement.setInt(1, horaire.getHeureCM());
                statement.setInt(1, horaire.getHeureTD());
                statement.setInt(1, horaire.getHeureTP());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void Delete(Heure_de_la_semaine horaire) {
        if(horaire != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("DELETE FROM Heure_de_la_semaine" +
                        "WHERE id_groupe = ? and id_matiere = ?");
                statement.setInt(1, horaire.getGroupe());
                statement.setInt(1, horaire.getMatiere());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
