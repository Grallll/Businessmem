import Classes.Organization;
import Classes.Worker;

public class Main
{
	public static void main(String[] args) {
		Worker worker = new Worker("Ivan", "Welder", 30, 5);
		Organization org_1 = new Organization("org_1");
		Organization org_2 = new Organization("org_2");
		worker.getOrg(org_1);
		worker.getOrg(org_1); // Не добавится дубликат.
		worker.getOrg(org_2);
		org_1.getSpec("Welder", 100, 1, 1);
		org_1.plusSpec("Welder", 1); // Будет необходимость орагнизации в двух Welder (Сварщик).
		System.out.println(org_1.info());
		System.out.println(org_1.hire(worker));
	}
}