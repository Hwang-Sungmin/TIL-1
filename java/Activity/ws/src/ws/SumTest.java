package ws;

import java.util.Arrays;
import java.util.Random;

public class SumTest {

	public static void main(String[] args) {

		Random ran = new Random();
		int[] numb = new int[100];
		boolean[] check = new boolean[101];
		int[] holl = new int[50];
		int[] zak = new int[50];
		int[] sum = new int[50];
		int r;
//		1. 100���� ������ �迭�� 1~100������ ���ڸ� ������ �߻� ��Ų��. �ߺ� ������� �ʴ´�. 
		for (int i = 0; i < numb.length; i++) {
			while (true) {
				r = ran.nextInt(100) + 1;
				if (!check[r]) {
					check[r] = true;
					numb[i] = r;
					break;
				}
			}
		}
//		2. ¦�� ��°�� �ִ� �����鸸 50���� �迭�� ����
//		3. Ȧ�� ��°�� �ִ� �����鸸 50���� �迭�� ���� 
		for (int a = 0, b = 0, i = 0; i < numb.length; i++) {
			if (i % 2 == 0) {
				zak[b++] = numb[i];
			} else
				holl[a++] = numb[i];
		}
		System.out.println("¦����° ��");
		System.out.println(Arrays.toString(zak));
		System.out.println("Ȧ�� ��° ��");
		System.out.println(Arrays.toString(holl));
//		4. ¦�� ��° �迭�� ù��° ���ڿ� Ȧ�� ��° �迭�� ������ ���ڸ� �ջ�, 
//		�ٽ� ¦�� ��° �ι�° ���ڴ� Ȧ�� ��° �迭�� ���������� �ι�° ���ڿ��� 
//		�ջ� ....... �̷������� �ջ��� ����� ��� �Ͻÿ�
		int len = holl.length - 1;
		System.out.println("¦����°  + Ȧ�� ��°");
		for (int i = 0; i <= len; i++)
			sum[i] = zak[i] + holl[len - i];
		System.out.println(Arrays.toString(sum));

	}
}
