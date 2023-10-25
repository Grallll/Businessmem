package Classes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Worker extends Person{
    Set<Organization> orgs = new HashSet<Organization>();
    Integer salary, age;

    public Worker(  String name,
                    String specialization,
                    Integer salary,
                    Integer age){
        this.name = name;
        this.specialization = specialization;
        this.salary = salary;
        this.age = age;
    }

    public String toString(){
        return name;
    }

    public boolean getOrg(Organization org){
        return this.orgs.add(org);
    }

    public Map<String, String> info(){
        Map<String, String> result = new  HashMap<String, String>();
        result.put("Name", name);
        result.put("Specialization", specialization);
        result.put("Salary", salary+"k");
        result.put("Organizations", ""+orgs);
        result.put("Age", age+" year");
        return result;
    }
}
