package Classes;

import java.util.ArrayList;

public class Storage {
    private ArrayList<Worker> arrWorker = new ArrayList<>();
    private ArrayList<Organization> arrOrganization = new ArrayList<>();
    private ArrayList<Businessman> arrBusinessman = new ArrayList<>();

    public void put(Worker worker){arrWorker.add(worker);}
    public void put(Organization organization){arrOrganization.add(organization);}
    public void put(Businessman businessman){arrBusinessman.add(businessman);}

    public ArrayList<Worker> getWorker(){return arrWorker;}
    public ArrayList<Organization> getOrganization(){return arrOrganization;}
    public ArrayList<Businessman> getBusinessman(){return arrBusinessman;}
}
