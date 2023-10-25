package Classes;

import java.util.Map;

public class Tests {
    public static void main(String[] args) {
        test_Worker();
        test_Businessman();
    }

    static class ClassesException extends Exception {
        public ClassesException(String message) {
            super(String.format("[ERROR]: Info by %s does not meet expectations.", message));
        }
    }

    static void test_Worker(){
        Worker worker = new Worker("Ivan", "Welder", 30, 5);
		Organization org_1 = new Organization("Org_1");
		Organization org_2 = new Organization("Org_2");
		worker.getOrg(org_1);
		worker.getOrg(org_2);
		worker.getOrg(org_2);
        Map<String, String> info = worker.info();
        try{
            if (!(info.get("Name").equals("Ivan") &&
                info.get("Specialization").equals("Welder") &&
                info.get("Salary").equals("30k") &&
                info.get("Age").equals("5 year") &&
                info.get("Organizations").equals("[Org_1, Org_2]"))){
                    throw new ClassesException("Worker");
                }
        }catch (ClassesException ex){
            System.out.println(ex.getMessage());
        }
    }

    static void test_Businessman(){
        Businessman businessman = new Businessman("BuMem");
		Organization org_1 = new Organization("Org_1");
		Organization org_2 = new Organization("Org_2");
		Organization org_3 = new Organization("Org_3");
		businessman.getOrg(org_1);
		businessman.getOrg(org_2);
		businessman.getOrg(org_2);
		businessman.getOrg(org_3);
        Map<String, String> info = businessman.info();
        try{
            if (!(info.get("Name").equals("BuMem") &&
                info.get("Specialization").equals("Businessman") &&
                info.get("Organizations").contains("Org_1") &&
                info.get("Organizations").contains("Org_2") &&
                info.get("Organizations").contains("Org_3"))){
                    throw new ClassesException("Businessman");
                }
            businessman.delOrg(org_2);
            info = businessman.info();
            if (!(info.get("Organizations").contains("Org_1") &&
                info.get("Organizations").contains("Org_3"))){
                    throw new ClassesException("Businessman(delOrg)");
            }

        }catch (ClassesException ex){
            System.out.println(ex.getMessage());
        }
    }
}
