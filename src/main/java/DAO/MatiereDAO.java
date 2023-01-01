package main.java.DAO;

import main.java.ConnexionJDBC.ConnexionBD;
import main.java.Donnee.Matiere;
import main.java.InterfaceDAO.DAOInterface;

import java.sql.*;

public class MatiereDAO implements DAOInterface<Matiere> {

    private ConnexionBD connexionBD = new ConnexionBD();
    private Connection connexion = connexionBD.getConnexion();

    public MatiereDAO(Connection connexion){
        this.connexion = connexion;
    }


    public Matiere FindById(int id, Date date) {

        Matiere matiere = null;

        try {
            PreparedStatement statement = connexion.prepareStatement("SELECT * FROM Matieres WHERE id_matiere = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int ID = result.getInt("id_matiere");
                String name = result.getString("nom_matiere");;

                matiere = new Matiere(ID, name);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return matiere;
    }


    public void Insert(Matiere matiere){
        if(matiere != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("INSERT INTO Matieres" +
                        "(id_matiere,nom_matiere)" +
                        "VALUES (?,?)");
                statement.setInt(1, matiere.getId());
                statement.setString(1, matiere.getNom());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void Update(Matiere matiere){
        if(matiere != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("UPDATE Matieres" +
                        "SET id_matiere = ?, nom_matiere = ?" +
                        "WHERE id_enseignant = ?");
                statement.setInt(1, matiere.getId());
                statement.setString(1, matiere.getNom());
                statement.setInt(1, matiere.getId());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void Delete(Matiere matiere) {
        if(matiere != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("DELETE FROM Matieres" +
                        "WHERE id_matiere = ?");
                statement.setInt(1, matiere.getId());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

}
