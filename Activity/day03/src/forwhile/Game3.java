package forwhile;

import java.util.Random;
import java.util.Scanner;

public class Game3 {
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int a, b;
		String str = "";
		int c=1;
		for (;c==1;c=sc.nextInt()) {
			System.out.println("1���� 6 ������ ���ڸ� 2�� �Է��ϼ���");
			a = sc.nextInt();
			b = sc.nextInt();
			if ((a > 6 || a < 0) || (b > 6 || b < 0)) {
				System.out.println("� ���� ��ġ�� �����ñ���");
				sc.close();
				return;
			}
			switch (Math.abs(a - b)) {
			case 0:
				str = "���� ���µ� �������� ������ ���� ���̴�.";
				break;
			case 1:
				str = "������ �ֽ��� �޵��� ��Դϴ�.";
				break;
			case 2:
				str = "�ζ� 5õ����ġ ��µ� 5õ�� ��÷�� ��Դϴ�.";
				break;
			case 3:
				str = "�� ���ٰ� ���� ���� ��Դϴ�. ��Ƴ����� �ζ� �ϳ� �缼��";
				break;
			case 4:
				str = "��ٱ�� ��ٱ�, ����ö ������ ��Դϴ�.";
				break;
			case 5:
				str = "���������� �쿬�� �� �ﰢ����� 1+1 ��� ���� ��Դϴ�.";
				break;
			}			
			System.out.println(str);
			System.out.println("��� �Ͻ÷��� 1�� �Է��ϼ���");
						
		}
		sc.close();
	}
}
