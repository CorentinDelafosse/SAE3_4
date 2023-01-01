package main.java.DAO;

import main.java.ConnexionJDBC.ConnexionBD;
import main.java.Donnee.Salle;
import main.java.InterfaceDAO.DAOInterface;

import java.sql.*;

public class SalleDAO implements DAOInterface<Salle> {
    private ConnexionBD connexionBD = new ConnexionBD();
    private Connection connexion = connexionBD.getConnexion();

    public SalleDAO(Connection connexion){
        this.connexion = connexion;
    }


    public Salle FindById(int id, Date date) {

        Salle salle = null;

        try {
            PreparedStatement statement = connexion.prepareStatement("SELECT * FROM Salles WHERE id_salle = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int salleId = result.getInt("id_salle");
                String type = result.getString("type_salle");
                int nombrePlace = result.getInt("nombre_places");
                boolean dejaPrise = result.getBoolean("deja_prise");

                salle = new Salle(salleId, type, nombrePlace, dejaPrise);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return salle;
    }


    public void Insert(Salle salle){
        if(salle != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("INSERT INTO Salles" +
                        "(id_salle,type_salle,nombre_places, deja_prise)" +
                        "VALUES (?,?,?,?)");
                statement.setInt(1, salle.getId());
                statement.setString(1, salle.getType());
                statement.setInt(1, salle.getNombrePlace());
                statement.setBoolean(1, salle.isDejaPrise());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void Update(Salle salle){
        if(salle != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("UPDATE Salles" +
                        "SET id_salle = ?, type_salle = ?, nombre_places = ?, deja_prise = ?" +
                        "WHERE id_salle = ?");
                statement.setInt(1, salle.getId());
                statement.setString(1, salle.getType());
                statement.setInt(1, salle.getNombrePlace());
                statement.setBoolean(1, salle.isDejaPrise());
                statement.setInt(1, salle.getId());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void Delete(Salle salle) {
        if(salle != null) {
            try {
                PreparedStatement statement = connexion.prepareStatement("DELETE FROM Salles" +
                        "WHERE id_salle = ?");
                statement.setInt(1, salle.getId());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
