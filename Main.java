import Classes.Organization;
import Classes.Storage;
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
		org_1.getSpec("Carpenter", 100, 1, 1);
		org_1.getSpec("Ca", 100, 1, 1);

		for (int i = 0; i < 100; i++){ // Добавление большого количества специализаций для проверки JScrollPane.
			org_2.getSpec("Specialization_"+i, 100, 1, 1);
		}
		System.out.println(org_1.info());
		System.out.println(org_1.hire(worker));

		Storage store = new Storage();
		store.put(org_1);
		store.put(org_2);
		store.put(worker);
		
		store.put(org_1); // Добавление большого количества организаций для проверки JScrollPane.
		store.put(org_2);store.put(org_1);
		store.put(org_2);store.put(org_1);
		store.put(org_2);store.put(org_1);
		store.put(org_2);store.put(org_1);
		store.put(org_2);store.put(org_1);
		store.put(org_2);store.put(org_1);
		store.put(org_2);store.put(org_1);
		store.put(org_2);store.put(org_1);
		store.put(org_2);store.put(org_1);
		store.put(org_2);

        MyWindow myWindow = new MyWindow();
		myWindow.putStore(store);
	}
}