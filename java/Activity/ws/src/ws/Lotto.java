package ws;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
	public static void main(String[] args) {
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		int[] j = new int[11]; //���� ���� �ߺ� üũ�� ���� �迭
		int[] mynumb = new int[6]; // ���� ���� ����
		int[] Lnumb = new int[6]; //��÷ ��ȣ
		int in;
		int r;
		int cnt = 0;
		for (int i = 0; i < 6; i++) { // 6���� ��ȣ�� �Է¹ް� ���� �̹� ���� ��(J[in]==1) ��� �ٽ� �Է� �޴´�.
			while (true) {
				in = sc.nextInt();
				if (j[in] == 0) {
					j[in] = 1;
					mynumb[i] = in;
					break;
				} else if (j[in] == 1) {
					System.out.println("�ߺ��� ���ڰ� �ֽ��ϴ�");
					continue;
				}
			}
		}
		j = new int[11]; //���� �� ���� �迭 �ʱ�ȭ
		for (int i = 0; i < 6; i++) {
			while (true) {
				r = ran.nextInt(9) + 1;
				if (j[r] == 0) {
					j[r] = 1;
					Lnumb[i] = r;
					break;
				} else if (j[r] == 1)
					continue;
			}
		}
		Arrays.sort(mynumb); 
		Arrays.sort(Lnumb); // ���� ���� ���� ��ȣ�� ��÷��ȣ ����
		System.out.println("�� ��ȣ\t" + Arrays.toString(mynumb));
		System.out.println("��÷ ��ȣ\t" + Arrays.toString(Lnumb));
		for (int i : mynumb)
			for (int k : Lnumb)
				if (k == i)
					cnt++;
		long per;
		switch (cnt) { // ��ġ�ϴ� ��ȣ�� �� ��ŭ per�� ���� ��÷���� ����Ѵ�.
		case 3:
			per = 20;
			System.out.println("���: 4");
			break;
		case 4:
			per = 10;
			System.out.println("���: 3");
			break;
		case 5:
			per = 5;
			System.out.println("���: 2");
			break;
		case 6:
			per = 2;
			System.out.println("���: 1");
			break;
		default:
			per = 0;
			System.out.println("���: ��");
			break;
		}
		long lott = 0;
		for (int i = 0; i < 10; i++) { 
			// ��÷�� ����, Random.nextInt()�� ������ �ִ��� ���߱� ���� 0~10�� ���� �ϰ�, �ּҰ��� ���߱� ���� 1���� ���ߴ�.
			// �� 10�� �����Ͽ� ������ �����.
			lott += (long) (ran.nextInt(1000000000) + 100000000);
		}
		//�ڸ����� ǥ���ϱ����� �迭�� �ְ� �迭�� ���̸� ���� 
		//���ڸ��� ���� �˾Ƴ��� ����Ͽ� �ڸ����� ǥ���Ѵ�.
		long[] some = new long[1];
		some[0] = lott;
		long meGet = (long) (lott / per);
		String out = Arrays.toString(some);
		String out2 = "";
		int len = out.length() - 2; // �� ���ڸ����ΰ�
		int cnt2 = len % 3; //3���� ���� �������� �ڸ������� ���� ����
		for (int i = 1; i <= cnt2; i++) {
			out2 += out.charAt(i);
		}
		for (int i = cnt2 + 1; i <= len; i += 3) { //3�ڸ����� ��ǥ�� �߰��Ѵ�.
			out2 += "," + out.charAt(i) + out.charAt(i + 1) + out.charAt(i + 2);
		}
		if (cnt2 == 0)
			out2 = out2.substring(1, out.length() + 1);  // ���� �ڸ����� 3���� ������ �������ٸ� ,���� �� ��ǥ �ϳ��� �����
		System.out.println("�� ��÷��: " + out2);
		
		//���� ����
		some[0] = meGet;
		out = Arrays.toString(some);
		out2 = "";
		len = out.length() - 2;
		cnt2 = len % 3;
		for (int i = 1; i <= cnt2; i++) {
			out2 += out.charAt(i);
		}
		for (int i = cnt2 + 1; i <= len; i += 3) {

			out2 += "," + out.charAt(i) + out.charAt(i + 1) + out.charAt(i + 2);
		}
		if (cnt2 == 0)
			out2 = out2.substring(1, out.length() + 1);
		System.out.println("�� ��÷��: " + out2);

	}
}
