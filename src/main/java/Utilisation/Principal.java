package main.java.Utilisation;

import main.java.ConnexionJDBC.ConnexionBD;
import main.java.ConnexionJDBC.CreationDB;
import main.java.ConnexionJDBC.CreationTable;
import main.java.ConnexionJDBC.ImportDonnee;

import main.java.DAO.*;
import main.java.Donnee.*;

import java.sql.Connection;
import java.util.Scanner;


public class Principal {
    private static Connection connexion = null;

    public static void main(String[] args) {


        //creation de la base de donnee
        CreationDB creation = new CreationDB();
        boolean reussiCreation = creation.Creation();
        if(reussiCreation){
            System.out.println("Creation de la database reussi");
        }
        else{
            System.out.println("Creation de la database a echoue");
        }

        //connexion a la base de donnée
        ConnexionBD connexionBD = new ConnexionBD();
        Connection connexion = connexionBD.getConnexion();
        if(connexion != null){
            System.out.println("Connexion a la base de donnee reussi");
        }

        //Creation des table dans la base de donnee
        CreationTable creationTable = new CreationTable();
        boolean reussiCreationTable = creationTable.Creation();
        if(reussiCreationTable){
            System.out.println("Creation des tables reussi");
        }
        else{
            System.out.println("Creation des tables a echoue");
        }

        //import des donne dans la base
        ImportDonnee insertionDonnee = new ImportDonnee();
        boolean reussiInsertionDonnee = insertionDonnee.Import();
        if(reussiInsertionDonnee){
            System.out.println("Insertion des données reussi");
        }
        else{
            System.out.println("Insertion des données a echoue");
        }

        if (reussiCreationTable == true && reussiCreation == true){
            Scanner sc = new Scanner(System.in);

            ConnexionDAO connexionDao = new ConnexionDAO(connexion);
            EnseignantDAO enseignantDao = new EnseignantDAO(connexion);
            EnseigneDAO enseigneDao = new EnseigneDAO(connexion);
            Est_indisponibleDAO est_indisponibleDao = new Est_indisponibleDAO(connexion);
            EtudiantDAO etudiantDAO = new EtudiantDAO(connexion);
            EtudieDAO etudieDAO = new EtudieDAO(connexion);
            GroupeDAO groupeDAO = new GroupeDAO(connexion);
            Heure_de_la_semaineDAO heure_de_la_semaineDAO = new Heure_de_la_semaineDAO(connexion);
            HierarchieDAO hierarchieDAO = new HierarchieDAO(connexion);
            IndisponibiliteDAO indisponibiliteDAO = new IndisponibiliteDAO(connexion);
            Jour_non_travailleDAO jour_non_travailleDAO = new Jour_non_travailleDAO(connexion);
            MatiereDAO matiereDAO = new MatiereDAO(connexion);
            SalleDAO salleDAO = new SalleDAO(connexion);

            while (true) {
                System.out.println("------------------------------------------------------------------------------------------");
                System.out.println("1. Rechercher une connexion par ID");
                System.out.println("2. Rechercher un enseignant par ID");
                System.out.println("3. Rechercher une relation enseignement par ID");
                System.out.println("4. Rechercher quand un enseigant est indisponible par ID et par date");
                System.out.println("5. Rechercher un etudiant par ID");
                System.out.println("6. Rechercher quel cours est étudier par ID");
                System.out.println("7. Rechercher un groupe par ID");
                System.out.println("8. Rechercher combien d'heure a un groupe une matiere dans une semaine par ID");
                System.out.println("9. Rechercher une hierarchie par ID");
                System.out.println("10. Rechercher les indisponibilite par date");
                System.out.println("11. Rechercher les jour sans travail par date");
                System.out.println("12. Rechercher une matiere par ID");
                System.out.println("13. Rechercher une salle par ID");
                System.out.println("14. Quitter");
                System.out.print("Veuillez choisir une option : ");

                int choice = 0;
                try {
                    choice = sc.nextInt();
                }catch(Exception e){
                    System.out.println("La valeur entrée n'est pas valide.");
                }
                    if (choice == 14) {
                        System.out.print("Au revoir");
                        break;
                    }
                    if (choice>0 && choice <14) {
                        if (choice == 1) {
                            try {
                                int id = InputInt();
                                Connexion connexiond = connexionDao.FindById(id, null);
                                if (connexion != null) {
                                    System.out.println("Connexion trouvée : " + connexiond);
                                } else {
                                    System.out.println("Aucune connexion trouvée avec l'ID " + id);
                                }
                            } catch (Exception e) {
                                System.out.println("Veuillez rentrer un ID correct");
                            }
                        } else if (choice == 2) {
                            try {
                                int id = InputInt();
                                Enseignant enseignant = enseignantDao.FindById(id, null);
                                if (enseignant != null) {
                                    System.out.println("Enseignant trouvé : " + enseignant);
                                } else {
                                    System.out.println("Aucun enseignant trouvé avec l'ID " + id);
                                }
                            } catch (Exception E){
                                System.out.println("Veuillez rentrer un ID correct");
                            }
                        } else if (choice == 3) {
                            try {
                                int id = InputInt();
                                Enseigne enseigne = enseigneDao.FindById(id, null);
                                if (enseigne != null) {
                                    System.out.println("Relation enseignement trouvée : " + enseigne);
                                } else {

                                    System.out.println("Aucune relation enseignement trouvée avec l'ID " + id);
                                }
                            } catch (Exception e) {
                                System.out.println("Veuillez rentrer un ID correct");
                            }
                        } else if (choice == 4) {
                            try {
                                int id = InputInt();
                                String date = InputString();
                                Est_indisponible est_indisponible = est_indisponibleDao.FindById(id, date);
                                if (est_indisponible != null) {
                                    System.out.println("Relation enseignement trouvée : " + est_indisponible);
                                } else {

                                    System.out.println("Aucune relation enseignement trouvée avec l'ID "+ id +" et la date " + date);
                                }
                            } catch (Exception e) {
                                System.out.println("Veuillez rentrer un ID correct");
                            }
                        } else if (choice == 5) {
                            try {
                                int id = InputInt();
                                Etudiant etudiant = etudiantDAO.FindById(id, null);
                                if (etudiant != null) {
                                    System.out.println("Relation enseignement trouvée : " + etudiant);
                                } else {

                                    System.out.println("Aucune relation enseignement trouvée avec l'ID " + id);
                                }
                            } catch (Exception e) {
                                System.out.println("Veuillez rentrer un ID correct");
                            }
                        } else if (choice == 6) {
                            try {
                                int id = InputInt();
                                Etudie etudie = etudieDAO.FindById(id, null);
                                if (etudie != null) {
                                    System.out.println("Relation enseignement trouvée : " + etudie);
                                } else {

                                    System.out.println("Aucune relation enseignement trouvée avec l'ID " + id);
                                }
                            } catch (Exception e) {
                                System.out.println("Veuillez rentrer un ID correct");
                            }
                        } else if (choice == 7) {
                            try {
                                int id = InputInt();
                                Groupe groupe = groupeDAO.FindById(id, null);
                                if (groupe != null) {
                                    System.out.println("Relation enseignement trouvée : " + groupe);
                                } else {

                                    System.out.println("Aucune relation enseignement trouvée avec l'ID " + id);
                                }
                            } catch (Exception e) {
                                System.out.println("Veuillez rentrer un ID correct");
                            }
                        } else if (choice == 8) {
                            try {
                                int id = InputInt();
                                Heure_de_la_semaine heure_de_la_semaine = heure_de_la_semaineDAO.FindById(id, null);
                                if (heure_de_la_semaine != null) {
                                    System.out.println("Relation enseignement trouvée : " + heure_de_la_semaine);
                                } else {

                                    System.out.println("Aucune relation enseignement trouvée avec l'ID " + id);
                                }
                            } catch (Exception e) {
                                System.out.println("Veuillez rentrer un ID correct");
                            }
                        } else if (choice == 9) {
                            try {
                                int id = InputInt();
                                Hierarchie hierarchie = hierarchieDAO.FindById(id, null);
                                if (hierarchie != null) {
                                    System.out.println("Relation enseignement trouvée : " + hierarchie);
                                } else {

                                    System.out.println("Aucune relation enseignement trouvée avec l'ID " + id);
                                }
                            } catch (Exception e) {
                                System.out.println("Veuillez rentrer un ID correct");
                            }
                        } else if (choice == 10) {
                            try {
                                System.out.print("Entrez une date au format yyyy-mm-dd :");
                                String date  = sc.next();

                                Indisponibilite indisponibilite = indisponibiliteDAO.FindById(0, date);
                                if (indisponibilite != null) {
                                    System.out.println("Relation enseignement trouvée : " + indisponibilite);
                                } else {

                                    System.out.println("Aucune relation enseignement trouvée avec la date " + date);
                                }
                            } catch (Exception e) {
                                System.out.println("Veuillez rentrer une date valide");
                            }
                        } else if (choice == 11) {
                            try {
                                String date = InputString();
                                Jour_non_travaille jour_non_travaille = jour_non_travailleDAO.FindById(0, date);
                                if (jour_non_travaille != null) {
                                    System.out.println("Relation enseignement trouvée : " + jour_non_travaille);
                                } else {

                                    System.out.println("Aucune relation enseignement trouvée avec la date " + date);
                                }
                            } catch (Exception e) {
                                System.out.println("Veuillez rentrer une date valide");
                            }
                        } else if (choice == 12) {
                            try {
                                int id = InputInt();
                                Matiere matiere = matiereDAO.FindById(id, null);
                                if (matiere != null) {
                                    System.out.println("Relation enseignement trouvée : " + matiere);
                                } else {

                                    System.out.println("Aucune relation enseignement trouvée avec l'ID " + id);
                                }
                            } catch (Exception e) {
                                System.out.println("Veuillez rentrer un ID correct");
                            }
                        } else if (choice == 13) {
                            try {
                                int id = InputInt();
                                Salle salle = salleDAO.FindById(id, null);
                                if (salle != null) {
                                    System.out.println("Relation enseignement trouvée : " + salle);
                                } else {

                                    System.out.println("Aucune relation enseignement trouvée avec l'ID " + id);
                                }
                            } catch (Exception e) {
                                System.out.println("Veuillez rentrer un ID correct");
                            }

                        }
                    }

            }
            sc.close();
        }
    }
    public static int InputInt(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Veuillez entrer l'ID à rechercher : ");

        int id = sc.nextInt();
        return id;
    }
    public static String InputString(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez une date au format yyyy-mm-dd :");
        String date  = sc.next();
        return date;
    }


}
