package main.java.DAO;

import main.java.ConnexionJDBC.ConnexionBD;
import main.java.Donnee.Hierarchie;
import main.java.InterfaceDAO.DAOInterface;

import java.sql.*;

public class HierarchieDAO implements DAOInterface<Hierarchie> {

    private ConnexionBD connexionBD = new ConnexionBD();
    private Connection connexion = connexionBD.getConnexion();

    public HierarchieDAO(Connection connexion){
        this.connexion = connexion;
    }


    public Hierarchie FindById(int id, String date) {

        Hierarchie hierarchie = null;

        try {
            PreparedStatement statement = connexion.prepareStatement("SELECT * FROM Hierarchie_groupe WHERE id_groupe = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int groupe1 = result.getInt("id_groupe");
                int groupe2 = result.getInt("id_groupe_1");
                String nom = result.getString("nom_hierarchie");

                hierarchie = new Hierarchie(groupe1, groupe2, nom);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return hierarchie;
    }


    public void Insert(Hierarchie hierarchie){
        if(hierarchie != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("INSERT INTO Hierarchie_groupe" +
                        "(id_groupe, id_groupe_1, nom_hierarchie)" +
                        "VALUES (?,?,?)");
                statement.setInt(1, hierarchie.getIdGroupe1());
                statement.setInt(1, hierarchie.getIdGroupe2());
                statement.setString(1, hierarchie.getNom());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void Update(Hierarchie hierarchie){
        if(hierarchie != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("UPDATE Hierarchie_groupe" +
                        "SET id_groupe = ?, id_groupe_1 = ?, nom_hierarchie = ?" +
                        "WHERE id_groupe = ? and id_groupe_1 = ?");
                statement.setInt(1, hierarchie.getIdGroupe1());
                statement.setInt(1, hierarchie.getIdGroupe2());
                statement.setString(1, hierarchie.getNom());
                statement.setInt(1, hierarchie.getIdGroupe1());
                statement.setInt(1, hierarchie.getIdGroupe2());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void Delete(Hierarchie hierarchie) {
        if(hierarchie != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("DELETE FROM Hierarchie_groupe" +
                        "WHERE nom_hierarchie = ?");
                statement.setString(1, hierarchie.getNom());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
