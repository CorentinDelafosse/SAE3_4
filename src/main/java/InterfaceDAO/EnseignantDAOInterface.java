package main.java.InterfaceDAO;

import main.java.Donnée.Enseignant;

public interface EnseignantDAOInterface {
    public Enseignant FindById(int id);

    public void Insert(Enseignant user);

    public void Update(Enseignant user);

    public void Delete(Enseignant user);
}
