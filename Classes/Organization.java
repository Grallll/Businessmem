package Classes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Organization extends Base{

    private class Spec_data{
        public Integer salary, age, count;

        public Spec_data(Integer salary, Integer age, Integer count){
            this.salary = salary;
            this.age = age;
            this.count = count;
        }

        public String toString(){
            return ""+count;
        }
    }

    private Set<Worker> workers = new HashSet<Worker>();
    private Set<Businessman> businessmen = new HashSet<Businessman>();
    private Map<String, Spec_data> specializations = new HashMap<String, Spec_data>();

    public Organization(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

    public Map<String, String> info(){
        Map<String, String> result = new HashMap<String, String>();
        result.put("Name", name);
        result.put("Businessmen", ""+businessmen);
        result.put("Specializations", ""+specializations);
        result.put("Workers", ""+workers);
        return result;
    }

    public void getSpec(String spec, Integer salary, Integer age, Integer count){
        Spec_data spec_data = new Spec_data(salary, age, count);
        specializations.merge(spec, spec_data, ((oldV, newV) -> {
            newV.count += oldV.count;
            return newV;
        }));
        if (specializations.get(spec).count < 1){
            specializations.remove(spec);
        }
    }

    public void plusSpec(String spec, Integer count){
        if (specializations.containsKey(spec)){
            Spec_data old_spec = specializations.get(spec);
            Integer dif = old_spec.count+count;
            old_spec.count = dif > 0 ? dif : null;
            if (old_spec.count == null){
                specializations.remove(spec);
            }
        }
    }

    public boolean hire(Worker worker){
        if (specializations.containsKey(worker.specialization)){
            for (Organization org : worker.orgs){
                if (org.name == name){
                    Spec_data spec_need = specializations.get(worker.specialization);
                    if (spec_need.age <= worker.age &&
                        spec_need.salary >= worker.salary){
                            workers.add(worker);
                            return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dismissal(Worker worker){
        if (workers.contains(worker)){
            if (specializations.containsKey(worker.specialization)){
                plusSpec(worker.specialization, 1);
            }else{
                getSpec(worker.specialization, worker.salary, worker.age, 1);
            }
            workers.remove(worker);
            return true;
        }
        return false;
    }
}
