package db2;

//���� �� �� �ϵ� �ڵ� ����
public class App {

	public static String[] select(String id) {
		// ������ ����/
		// ID ���� �������
		String[] str = { "id2", "name", "password" };
		return str;
	}

	public static void main(String[] args) {
		String id = "id03";
		String name = "James";
		String pwd = "pwd02";
		DB db = new DbUser("132.654.987.321");
		User u = new User(id, name, pwd);
		db.insert(u);
		User gett =null;
		System.out.println(gett=(User) db.select(id));

	}

}
