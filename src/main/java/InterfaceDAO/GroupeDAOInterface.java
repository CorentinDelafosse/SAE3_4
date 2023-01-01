package main.java.InterfaceDAO;

import main.java.Donnée.Groupe;

public interface GroupeDAOInterface {
    public Groupe FindById(int id);

    public void Insert(Groupe group);

    public void Update(Groupe group);

    public void Delete(Groupe group);
}
