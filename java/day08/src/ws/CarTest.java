package ws;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �ڵ����� ���� �ϰ� �ڵ��� ������ ��� �Ͻÿ�
		Engine eg1 = new Engine(3000, 12);
		Engine eg2 = new Engine(3000, 8);
		Car c1 = new Car("20190523024602", "BestCar", eg1, "Red");
		Car c2 = new Car("20190523024610", "BetterOne", eg2, "Yellow");
		System.out.println(c1.toString());
		System.out.println(c2.toString());

	}

}
