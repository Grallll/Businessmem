package Classes;

import java.util.ArrayList;

import Classes.Logs.LogStash;

public class Local implements Storage{
    LogStash log_st = new LogStash();

    private ArrayList<Worker> arrWorker = new ArrayList<>();
    private ArrayList<Organization> arrOrganization = new ArrayList<>();
    private ArrayList<Businessman> arrBusinessman = new ArrayList<>();

    public void put(Worker worker){
        arrWorker.add(worker);
        log_st.set(worker);
    }
    public void put(Organization organization){arrOrganization.add(organization);}
    public void put(Businessman businessman){arrBusinessman.add(businessman);}

    public void del(Worker worker){arrWorker.remove(worker);}
    public void del(Organization organization){arrOrganization.remove(organization);}
    public void del(Businessman businessman){arrBusinessman.remove(businessman);}

    public ArrayList<Worker> getWorker(){return arrWorker;}
    public ArrayList<Organization> getOrganization(){return arrOrganization;}
    public ArrayList<Businessman> getBusinessman(){return arrBusinessman;}
}