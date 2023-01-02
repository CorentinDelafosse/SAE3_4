package main.java.InterfaceDAO;

import java.sql.Date;

public interface DAOInterface<Donnee>{

    public Donnee FindById(int id, String date);

    public void Insert(Donnee donnee);

    public void Update(Donnee donnee);

    public void Delete(Donnee donnee);
}
