package transportation;

import shape.Circle;

public class TrasnpTest {
	public static void main(String[] args) {
		Transportation[] t = new Transportation[4];
		t[0] = new Bus(new Location(0, 0), new Location(10, 10), "��������", 7016);
		t[1] = new Subway(new Location(10, 10), new Location(0, 0), "�д缱");
		t[2] = new Train(new Location(3, 3), new Location(20, 7), "���");
		t[3] = new Subway();
		((Subway)t[3]).setLine("3ȣ��");
		t[3].setBoardPoint(new Location(5,4));
		t[3].setGetoffPoint(new Location(-2,-3));
		for(Transportation tmp : t)
			System.out.println(tmp);

	}

}
