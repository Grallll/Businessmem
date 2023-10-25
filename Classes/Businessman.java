package Classes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Businessman extends Person {
    Set<Organization> orgs = new HashSet<Organization>();

    public Businessman(String name){
        this.name = name;
        this.specialization = "Businessman";
    }

    public String toString(){
        return name;
    }

    public boolean getOrg(Organization org){
        return orgs.add(org);
    }

    public boolean delOrg(Organization org){
        return orgs.remove(org);
    }

    public Set<Organization> hire(Worker worker){
        Set<Organization> result = new HashSet<Organization>();
        for (Organization org : orgs){
            if (org.hire(worker)){
                result.add(org);
            }
        }
        return result;
    }

    public boolean dismissal(Worker worker, Organization org){
        return org.dismissal(worker);
    }

    public Map<String, String> info(){
        Map<String, String> result = new  HashMap<String, String>();
        result.put("Name", name);
        result.put("Specialization", specialization);
        result.put("Organizations", ""+orgs);
        return result;
    }
}
