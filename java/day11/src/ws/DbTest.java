package ws;

import java.util.HashMap;

public class DbTest {

	public static void main(String[] args) {
		Db<User, String, HashMap<String, User>> db1 = new UserDb();
		Db<Product, Integer, HashMap<Integer, Product>> db2 = new ProductDb();
		Product p = new Product(100, "Pants", 49000);
		User u = new User("Lee", "id01", "pwd123");
		HashMap<String, User> map = new HashMap<>();
		System.out.println("UserDb");		
		db1.insert(u);
		User getU = db1.select("id04");
		System.out.println(getU);
		map = db1.select();
		System.out.println("��� ��������");
		System.out.println(map.toString());
		System.out.println("�����ϱ�");
		db1.delete("id03");
		System.out.println("�����ϱ�");
		User upU = new User("Lim", "id04", "pwd654");
		db1.Update(upU);
		System.out.println("ProductDb");
		HashMap<Integer, Product> map2 = new HashMap<Integer, Product>();
		db2.insert(p);
		System.out.println("�ϳ� ��������");
		Product getP = db2.select(3);
		System.out.println(getP);
		map2 = db2.select();
		System.out.println("��� ��������");
		System.out.println(map2.toString());
		System.out.println("�����ϱ�");
		db2.delete(1);
		System.out.println("�����ϱ�");
		Product upP = new Product(100, "Shirts", 49500);
		db2.Update(upP);

	}

}
