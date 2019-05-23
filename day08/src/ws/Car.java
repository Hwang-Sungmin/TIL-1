package ws;
public class Car {
//	2. �ڵ���
//	�Ӽ�:�ø���(����Ͻú���+1000, ���� 1001, 1002�� ����), �̸�, ����, ����
//	���: ���� ���
	private String serial;
	private String name;
	private Engine eng;
	private String color;
	private static int cnt = 1000;
	
	public Car(String serial, String name, Engine eng, String color) {
		this.serial = serial + cnt++;
		this.name = name;
		this.eng = eng;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Car [serial=" + serial + ", name=" + name + ", eng=" + eng + ", color=" + color + "]";

	}

	public String getSerial() {
		return serial;
	}

	public String getName() {
		return name;
	}

	public Engine getEng() {
		return eng;
	}

	public String getColor() {
		return color;
	}

	public static int getCnt() {
		return cnt;
	}

}
