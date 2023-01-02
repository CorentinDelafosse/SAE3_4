package main.java.ConnexionJDBC;

import java.sql.*;

public class CreationTable {

    ConnexionBD connexionBD = new ConnexionBD();
    Connection connexion = connexionBD.getConnexion();

    public boolean Creation(){
        boolean reussi = false;

        try{

            Statement statement = connexion.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS Groupes(" +
                    "   id_groupe INT," +
                    "   nom_groupe VARCHAR(50) NOT NULL," +
                    "   PRIMARY KEY(id_groupe)," +
                    "   UNIQUE(nom_groupe)" +
                    ");";

            statement.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS Matieres(" +
                    "   id_matiere INT," +
                    "   nom_matiere VARCHAR(20) NOT NULL," +
                    "   PRIMARY KEY(id_matiere)" +
                    ");";

            statement.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS Salles(" +
                    "   id_salle INT," +
                    "   type_salle VARCHAR(2) NOT NULL," +
                    "   nombre_places INT," +
                    "   deja_prise BOOLEAN NOT NULL," +
                    "   PRIMARY KEY(id_salle)" +
                    ");";

            statement.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS Jours_non_travailles(" +
                    "   jour_non_travaille DATE," +
                    "   raison VARCHAR(255)," +
                    "   PRIMARY KEY(jour_non_travaille)" +
                    ");";

            statement.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS Indisponibilites(" +
                    "   jour_indisponibilite DATE," +
                    "   horaire_indisponibilite TIME," +
                    "   PRIMARY KEY(jour_indisponibilite, horaire_indisponibilite)" +
                    ");";

            statement.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS Connexion(" +
                    "   id INT," +
                    "   id_connexion VARCHAR(50)," +
                    "   mdp_connexion VARCHAR(50) NOT NULL," +
                    "   status_connexion VARCHAR(50) NOT NULL," +
                    "   PRIMARY KEY(id)," +
                    "   UNIQUE(id_connexion)" +
                    ");";

            statement.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS Etudiants(" +
                    "   id_etudiant INT," +
                    "   nom_etudiant VARCHAR(50) NOT NULL," +
                    "   prenom_etudiant VARCHAR(50) NOT NULL," +
                    "   age_etudiant INT NOT NULL," +
                    "   promo_etudiant INT NOT NULL," +
                    "   id_connexion VARCHAR(50) NOT NULL," +
                    "   id_groupe INT NOT NULL," +
                    "   PRIMARY KEY(id_etudiant)," +
                    "   FOREIGN KEY(id_connexion) REFERENCES Connexion(id_connexion)," +
                    "   FOREIGN KEY(id_groupe) REFERENCES Groupes(id_groupe)" +
                    ");";

            statement.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS Enseignants(" +
                    "   id_enseignant INT," +
                    "   nom_enseignant VARCHAR(50) NOT NULL," +
                    "   prenom_enseignant VARCHAR(50) NOT NULL," +
                    "   couleur_enseignant VARCHAR(15)," +
                    "   id_connexion VARCHAR(50) NOT NULL," +
                    "   PRIMARY KEY(id_enseignant)," +
                    "   FOREIGN KEY(id_connexion) REFERENCES Connexion(id_connexion)" +
                    ");";

            statement.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS Heure_de_la_semaine(" +
                    "   id_groupe INT," +
                    "   id_matiere INT," +
                    "   nb_heure INT," +
                    "   heure_CM INT," +
                    "   heure_TD INT," +
                    "   heure_TP INT," +
                    "   PRIMARY KEY(id_groupe, id_matiere)," +
                    "   FOREIGN KEY(id_groupe) REFERENCES Groupes(id_groupe)," +
                    "   FOREIGN KEY(id_matiere) REFERENCES Matieres(id_matiere)" +
                    ");";

            statement.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS Enseigne(" +
                    "   id_enseignant INT," +
                    "   id_matiere INT," +
                    "   PRIMARY KEY(id_enseignant, id_matiere)," +
                    "   FOREIGN KEY(id_enseignant) REFERENCES Enseignants(id_enseignant)," +
                    "   FOREIGN KEY(id_matiere) REFERENCES Matieres(id_matiere)" +
                    ");";

            statement.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS Etudie(" +
                    "   id_enseignant INT," +
                    "   id_groupe INT," +
                    "   id_matiere INT," +
                    "   id_salle INT," +
                    "   id_cours INT NOT NULL," +
                    "   PRIMARY KEY(id_enseignant, id_groupe, id_matiere, id_salle)," +
                    "   UNIQUE(id_cours)," +
                    "   FOREIGN KEY(id_enseignant) REFERENCES Enseignants(id_enseignant)," +
                    "   FOREIGN KEY(id_groupe) REFERENCES Groupes(id_groupe)," +
                    "   FOREIGN KEY(id_matiere) REFERENCES Matieres(id_matiere)," +
                    "   FOREIGN KEY(id_salle) REFERENCES Salles(id_salle)" +
                    ");";

            statement.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS Est_indisponible(" +
                    "   id_enseignant INT," +
                    "   jour_indisponibilite DATE," +
                    "   horaire_indisponibilite TIME," +
                    "   raison VARCHAR(255)," +
                    "   PRIMARY KEY(id_enseignant, jour_indisponibilite, horaire_indisponibilite)," +
                    "   FOREIGN KEY(id_enseignant) REFERENCES Enseignants(id_enseignant)," +
                    "   FOREIGN KEY(jour_indisponibilite, horaire_indisponibilite) REFERENCES Indisponibilites(jour_indisponibilite, horaire_indisponibilite)" +
                    ");";

            statement.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS Hierarchie_groupe(" +
                    "   id_groupe INT," +
                    "   id_groupe_1 INT," +
                    "   nom_hierarchie VARCHAR(50) NOT NULL," +
                    "   PRIMARY KEY(id_groupe, id_groupe_1)," +
                    "   UNIQUE(nom_hierarchie)," +
                    "   FOREIGN KEY(id_groupe) REFERENCES Groupes(id_groupe)," +
                    "   FOREIGN KEY(id_groupe_1) REFERENCES Groupes(id_groupe)" +
                    ");";

            statement.executeUpdate(sql);

            reussi = true;

        }catch(SQLException ex) {
            throw new RuntimeException(ex);
        }

        // Derniere Etape : Close la BD

        try {
            connexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }


        return reussi;
    }

}
