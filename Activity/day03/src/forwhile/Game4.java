package forwhile;

import java.util.Random;
import java.util.Scanner;

public class Game4 {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int c, u, cnt = 0, cnt2 = 0;
		String in;
		String str , str2;
		while (true) {
			System.out.println("1:���� ,2:���� ,3:��");
			c = random.nextInt(3) + 1;
			in = sc.next();
			if (in.equals("q")) {
				System.out.println("����");
				break;
			}
			u = Integer.parseInt(in);
			if (u != 1 && u != 2 && u != 3) {
				System.out.println("1���� 3���� �Է��ϼ���");
				continue;
			}
			str = "";
			if(u==1)
				str2="����";
			else if(u==2)
				str2="����";
			else
				str2="��";
			System.out.print(str2+"vs");
			if(c==1)
				str2="����";
			else if(c==2)
				str2="����";
			else
				str2="��";
			System.out.println(str2);
			cnt2++;
			switch (u - c) {
			case -1:// u = ����&& c =���� || u=����&& c=��
			case 2:
				str = "�й�";
				break;
			case -2:
			case 1:
				str = "�¸�!";
				cnt++;
				break;
			case 0:
				str = "���º�";
				break;
			}
			System.out.println(str);
			System.out.println("�� ���� Ƚ��:" + cnt2 + " �̱� Ƚ��: " + cnt);
			System.out.println("�ٸ� ���� ������\n");
		}
		
	}
}
