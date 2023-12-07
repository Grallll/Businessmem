package Classes;

import java.util.ArrayList;

public interface Storage{
    void put(Worker worker);
    void put(Organization organization);
    void put(Businessman businessman);

    void del(Worker worker);
    void del(Organization organization);
    void del(Businessman businessman);

    ArrayList<Worker> getWorker();
    ArrayList<Organization> getOrganization();
    ArrayList<Businessman> getBusinessman();
}
