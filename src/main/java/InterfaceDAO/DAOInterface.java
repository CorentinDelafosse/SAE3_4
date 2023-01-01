package main.java.InterfaceDAO;

public interface DAOInterface<Donnee>{

    public Donnee FindById(int id);

    public void Insert(Donnee donnee);

    public void Update(Donnee donnee);

    public void Delete(Donnee donnee);
}
