package forwhile;

import java.util.Random;
import java.util.Scanner;

public class Game32 {
	public static void main(String[] args) {
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		int a, b;
		String str = "";
		
		System.out.println("1���� 6 ������ ���ڸ� 2�� �Է��ϼ���");
		a = sc.nextInt();
		b = sc.nextInt();
		if ((a > 6 || a < 0) || (b > 6 || b < 0)) {
			System.out.println("� ���� ��ġ�� �����ñ���");
			sc.close();
			return;
		}
		int r;
		int[] outI = new int[6];
		String [] out = {"���� ���µ� �������� ������ ���� ���̴�.",
				"������ �ֽ��� �޵��� ��Դϴ�.",
				"�ζ� 5õ����ġ ��µ� 5õ�� ��÷�� ��Դϴ�.",
				"�� ���ٰ� ���� ���� ��Դϴ�. ��Ƴ����� �ζ� �ϳ� �缼��",
				"��ٱ�� ��ٱ�, ����ö ������ ��Դϴ�.",
				"���������� �쿬�� �� �ﰢ����� 1+1 ��� ���� ��Դϴ�."};
		for(int i=0;i<6;i++) {
			r=ran.nextInt(6);
			outI[i]=r-Math.abs(a-b);
		}
		str = out[Math.abs(a-b)];
		System.out.println(str);
		sc.close();
	}
}
