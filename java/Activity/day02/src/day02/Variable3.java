package day02;

import java.util.Scanner;

public class Variable3 {
	public static void main(String[] args) {
		// 4���� ������ ������ �Է� �޴´�,
		// �հ�� ��� ���϶�
		Scanner sc = new Scanner(System.in);
		int a, b, c, d, sum;
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		double avg;
		sum = a + b + c + d;
		avg = (double) sum / 4;
		System.out.println(sum + "\t" + avg);
		sc.close();

	}

}
