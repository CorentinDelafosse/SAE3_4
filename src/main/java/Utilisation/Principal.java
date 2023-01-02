package main.java.Utilisation;

import main.java.ConnexionJDBC.ConnexionBD;
import main.java.ConnexionJDBC.CreationDB;
import main.java.ConnexionJDBC.CreationTable;

import java.sql.Connection;

public class Principal {
    public static void main(String[] args) {

        CreationDB creation = new CreationDB();
        boolean reussiCreation = creation.Creation();
        if(reussiCreation){
            System.out.println("Creation de la database reussi");
        }
        else{
            System.out.println("Creation de la database a echoue");
        }


        CreationTable creationTable = new CreationTable();
        boolean reussiCreationTable = creationTable.Creation();
        if(reussiCreationTable){
            System.out.println("Creation des tables reussi");
        }
        else{
            System.out.println("Creation des tables a echoue");
        }






        ConnexionBD connexionBD = new ConnexionBD();
        Connection connexion = connexionBD.getConnexion();

        if(connexion != null){
            System.out.println("Connexion a la base de donnee reussi");
        }
    }
}
