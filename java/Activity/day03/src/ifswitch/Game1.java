package ifswitch;

import java.util.Random;
import java.util.Scanner;

public class Game1 {

	public static void main(String[] args) {
		// 1~3 ����� �ȳ� ���
		System.out.println("1:���� ,2:���� ,3:��");
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int c = random.nextInt(3) + 1;
		int u = sc.nextInt();
		if (u != 1 && u != 2 && u != 3) {
			System.out.println("�ȳ�!~");
			return;
		}
		String str = "";
		String[] K = { "����", "����", "��" };
		System.out.println("����� " + K[u - 1] + " �½��ϴ�");
		System.out.println("��ǻ�ʹ� " + K[c - 1] + " �½��ϴ�");
		// 1: ����, 2: ����, 3: ��
		switch (u - c) {
		case -1:// u = ����&& c =���� || u=����&& c=��
		case 2:
			str = "�����ϴ�";
			break;
		case -2:
		case 1:
			str = "�̰���ϴ�";
			break;
		case 0:
			str = "�����ϴ�";
			break;
		}
		System.out.println(str);
	}

}
