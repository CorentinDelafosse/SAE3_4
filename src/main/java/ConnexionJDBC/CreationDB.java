package main.java.ConnexionJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreationDB {

    public CreationDB() {
    }

    private Connection connexion;

    public void PremiereConnexion() {

        // 1ere Etape : Trouver driver jdbc sur internet (api)

        String nomDuDriverJDBCduSGBD = "com.mysql.cj.jdbc.Driver";


        // 2eme Etape : Trouver l'URL de notre base de donnee

        String urlBD = "jdbc:mysql://localhost:3306/";

        // 3eme Etape : charger en mémoire le Driver

        try{
            Class.forName(nomDuDriverJDBCduSGBD);
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
            System.exit(-1);
        }

        // 4eme Etape : Connecter entre programme et BD

        try {
            connexion = DriverManager.getConnection(urlBD, "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }


    public boolean Creation() {
        boolean reussi = false;

        PremiereConnexion();

        Statement statement = null;

        try {
            statement = connexion.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS sae";

            statement.executeUpdate(sql);

            reussi = true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        // Derniere Etape : Close la BD

        try {
            statement.close();
            connexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        return reussi;
    }
}
