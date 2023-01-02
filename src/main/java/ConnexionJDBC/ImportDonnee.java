package main.java.ConnexionJDBC;

import java.sql.*;

public class ImportDonnee {

    ConnexionBD connexionBD = new ConnexionBD();
    Connection connexion = connexionBD.getConnexion();

    public boolean Import(){
        boolean reussi = false;

        try{

            Statement statement = connexion.createStatement();
            String sql = "";

            sql = "SELECT * FROM Groupes";

            ResultSet result = statement.executeQuery(sql);
            if(!result.next()) {
                sql = "INSERT INTO Groupes (id_groupe, nom_groupe)" +
                        " VALUES (0, 'G1')," +
                        " (1, 'G2')," +
                        " (2, 'G3')," +
                        " (3, 'G4')," +
                        " (4, 'G5')," +
                        " (5, 'PR');";

                statement.executeUpdate(sql);
            }

            sql = "SELECT * FROM Matieres";

            result = statement.executeQuery(sql);
            if(!result.next()) {
                sql = "INSERT INTO Matieres (id_matiere, nom_matiere)" +
                        " VALUES (0, 'Developpement web')," +
                        " (1, 'Developpement efficace')," +
                        " (2, 'Analyse')," +
                        " (3, 'Qualite de developpement')," +
                        " (4, 'Programmation systeme')," +
                        " (5, 'Architecture des reseaux')," +
                        " (6, 'SQL dans un langage de programmation')," +
                        " (7, 'Probabilites')," +
                        " (8, 'Cryptographie et sécurite')," +
                        " (9, 'Management des systemes d’information')," +
                        " (10, 'Droits des contrats et du Numerique')," +
                        " (11, 'Anglais')," +
                        " (12, 'Communication professionnelle')," +
                        " (13, 'PPP');";

                statement.executeUpdate(sql);
            }

            sql = "SELECT * FROM Salles";

            result = statement.executeQuery(sql);
            if(!result.next()) {
                sql = "INSERT INTO Salles (id_salle, type_salle, nombre_places, deja_prise)" +
                        " VALUES (0, 'td', 30, FALSE)," +
                        " (1, 'td', 30, FALSE)," +
                        " (2, 'td', 30, FALSE)," +
                        " (3, 'td', 30, FALSE)," +
                        " (4, 'td', 30, FALSE)," +
                        " (5, 'tp', 30, FALSE)," +
                        " (6, 'tp', 30, FALSE)," +
                        " (7, 'tp', 30, FALSE)," +
                        " (8, 'tp', 30, FALSE)," +
                        " (9, 'tp', 30, FALSE)," +
                        " (10, 'tp', 30, FALSE)," +
                        " (11, 'tp', 30, FALSE)," +
                        " (12, 'tp', 30, FALSE)," +
                        " (13, 'tp', 30, TRUE);";

                statement.executeUpdate(sql);
            }

            sql = "SELECT * FROM Jours_non_travailles";

            result = statement.executeQuery(sql);
            if(!result.next()) {
                sql = "INSERT INTO Jours_non_travailles (Jour_non_travaille, raison)" +
                        " VALUES ('2022-12-24', 'Noel')," +
                        " ('2022-05-01', 'Fête du travail');";

                statement.executeUpdate(sql);
            }


            sql = "SELECT * FROM Indisponibilites";

            result = statement.executeQuery(sql);
            if(!result.next()) {
                sql = "INSERT INTO Indisponibilites (Jour_indisponibilite, horaire_indisponibilite)" +
                        " VALUES ('2023-01-05', '20:00:00')," +
                        " ('2023-01-15', '07:00:00');";

                statement.executeUpdate(sql);
            }


            sql = "SELECT * FROM Connexion";

            result = statement.executeQuery(sql);
            if(!result.next()) {
                sql = "INSERT INTO Connexion (id, id_connexion,mdp_connexion,status_connexion)" +
                        " VALUES (0, 'A22102025', 'Azerty123', 'connecter')," +
                        " (1, 'A56254124', 'Qwerty123', 'deconnecter')," +
                        " (2, 'B56254124', 'Werty123', 'deconnecter')," +
                        " (3, 'C56254124', 'Uerty123', 'deconnecter')," +
                        " (4, 'D15254684', 'Qerty123', 'deconnecter')," +
                        " (5, 'D15247884', 'Azerty123', 'deconnecter');";

                statement.executeUpdate(sql);
            }

            sql = "SELECT * FROM Etudiants";

            result = statement.executeQuery(sql);
            if(!result.next()) {
                sql = "INSERT INTO Etudiants (id_etudiant, nom_etudiant,prenom_etudiant,age_etudiant,promo_etudiant,id_connexion,id_groupe)" +
                        " VALUES (0, 'Delafosse', 'Corentin', 19, 29, 'A22102025',0)," +
                        " (1, 'Delevingne', 'Nicolas', 19, 29, 'A56254124',1)," +
                        " (2, 'Leroux', 'Matteo', 19, 29, 'B56254124',1)," +
                        " (3, 'Priez', 'Lucas', 19, 29, 'C56254124',0);";

                statement.executeUpdate(sql);
            }

            sql = "SELECT * FROM Enseignants";

            result = statement.executeQuery(sql);
            if(!result.next()) {
            sql = "INSERT INTO Enseignants (id_enseignant, nom_enseignant,prenom_enseignant,couleur_enseignant,id_connexion)" +
                    " VALUES (0, 'PROF1', 'Math', 'rouge', 'D15254684')," +
                    " (1, 'PROF2', 'FR', 'bleu', 'D15247884');";

            statement.executeUpdate(sql);
            }


            sql = "SELECT * FROM Heure_de_la_semaine";

            result = statement.executeQuery(sql);
            if(!result.next()) {
                sql = "INSERT INTO Heure_de_la_semaine (id_groupe, id_matiere,nb_heure,heure_CM,heure_TD,heure_TP)" +
                        "VALUES (0, 0, 24, 4,10,10)," +
                        "(0, 1, 25, 5,10,10);";

                statement.executeUpdate(sql);
            }


            sql = "SELECT * FROM Enseigne";

            result = statement.executeQuery(sql);
            if(!result.next()) {
                sql = "INSERT INTO Enseigne (id_enseignant, id_matiere)" +
                        " VALUES (0,0)," +
                        " (1,1);";

                statement.executeUpdate(sql);
            }

            sql = "SELECT * FROM Etudie";

            result = statement.executeQuery(sql);
            if(!result.next()) {
                sql = "INSERT INTO Etudie (id_enseignant, id_groupe,id_matiere,id_salle,id_cours)" +
                        " VALUES (0, 5, 0, 0,0)," +
                        " (1, 5, 1, 1,1);";

                statement.executeUpdate(sql);
            }

            sql = "SELECT * FROM Est_indisponible";

            result = statement.executeQuery(sql);
            if(!result.next()) {
                sql = "INSERT INTO Est_indisponible (id_enseignant, Jour_indisponibilite,horaire_indisponibilite,raison)" +
                        " VALUES (0, '2023-01-05', '20:00:00', 'Fermeture IUT')," +
                        " (1, '2023-01-15', '07:00:00', 'Maladie');";

                statement.executeUpdate(sql);
            }

            sql = "SELECT * FROM Hierarchie_groupe";

            result = statement.executeQuery(sql);
            if(!result.next()) {
                sql = "INSERT INTO Hierarchie_groupe (id_groupe, id_groupe_1,nom_hierarchie)" +
                        " VALUES (0, 5, 'professeur')," +
                        " (1, 5, 'professeur2')," +
                        " (2, 5, 'professeur3')," +
                        " (3, 5, 'professeur4')," +
                        " (4, 5, 'professeur5');";

                statement.executeUpdate(sql);
            }
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
