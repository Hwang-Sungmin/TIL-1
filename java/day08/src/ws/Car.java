package ws;
public class Car {
//	2. �ڵ���
//	�Ӽ�:�ø���(����Ͻú���+1000, ���� 1001, 1002�� ����), �̸�, ����, ����
//	���: ���� ���
	private String serial;
	private String name;
	private Engine engine;
	private String color;
	private static int cnt;
	
	//initialization block
	{
		
	}
	static {
		cnt = 1000;		
	}
	
	public Car(String serial, String name, Engine eng, String color) {
		this.serial = serial + cnt++;
		this.name = name;
		this.engine = eng;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Car [serial=" + serial + ", name=" + name + ", eng=" + engine + ", color=" + color + "]";

	}

	public String getSerial() {
		return serial;
	}

	public String getName() {
		return name;
	}

	public Engine getEng() {
		return engine;
	}

	public String getColor() {
		return color;
	}

	public static int getCnt() {
		return cnt;
	}

}
