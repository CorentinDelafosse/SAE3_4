package main.java.ConnexionJDBC;

import java.sql.*;

public class ConnexionBD {

    public ConnexionBD() {
    }

    Connection maConnexion = null;


    public Connection getConnexion() {

        // 1ere Etape : Trouver driver jdbc sur internet (api)

        String nomDuDriverJDBCduSGBD = "com.mysql.cj.jdbc.Driver";


        // 2eme Etape : Trouver l'URL de notre base de donnee

        String urlBD = "jdbc:mysql://localhost:3306/sae";

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
            maConnexion = DriverManager.getConnection(urlBD, "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }


        return maConnexion;
    }

}
