package forwhile;

public class Forex2 {
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == i)
					System.out.print("���º� ");
				else if (i - j == -1 || i - j == 2)
					System.out.print("�Ľ� ");
				else
					System.out.print("������ ");
			}
			System.out.println();
		}
	}
}
