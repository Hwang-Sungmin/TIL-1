package marray;

import java.util.Arrays;
import java.util.Random;

public class Marr3 {
	public static void main(String[] args) {
		// 5 �� ���� ���
		// ���� 1 ~ 100
		// ���� ���� ���� ����
		// �� �迭�� ù��°�� �й��� ����
		int[][] std = new int[4][4];
		Random ran = new Random();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				std[i][j] = ran.nextInt(100) + 1;
			}
		}
		for (int i[] : std)
			System.out.println(Arrays.toString(i));
		// �л��� ��� , ���� ��� , ��ü��� ���
		float st[] = new float[4];
		float subb[] = new float[4];
		int cnt = 0;
		int sum;
		int sum2;
		int sum3 = 0;
		float avg;
		for (int i = 0; i < std.length; i++) {
			sum = 0;
			sum2 = 0;
			for (int j = 0; j < std[0].length; j++) {
				sum += std[i][j];
				sum2 += std[j][i];
			}
			sum3 += sum;
			st[i] = (float) sum / std.length;
			subb[i] = (float) sum2 / std[0].length;
		}
		avg = sum3 / (std.length * std[0].length);
		System.out.println("\n�л��� ���");
		for (float i : st) {
			System.out.printf("%2.1f  ", i);
		}
		System.out.println("\n���� ���");
		for (float i : subb) {
			System.out.printf("%2.1f  ", i);
		}
		System.out.println("\n��ü ���");
		System.out.print(avg);
	}
}
