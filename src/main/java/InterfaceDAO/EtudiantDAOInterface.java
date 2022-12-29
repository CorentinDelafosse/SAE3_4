package main.java.InterfaceDAO;

import main.java.Donnée.Etudiant;

public interface EtudiantDAOInterface {
    public Etudiant FindById(int id);

    public void Insert(Etudiant user);

    public void Update(Etudiant user);

    public void Delete(Etudiant user);
}
