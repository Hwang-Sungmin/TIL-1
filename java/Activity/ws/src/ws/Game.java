package ws;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		System.out.println("������ ����� �Է��ϼ���");
		int a = 0;
		while (true) {
			a = sc.nextInt();
			if (a > 10 || a < 1) {
				System.out.println("\n1���� 10������ ���� �Է��ϼ���");
			} else
				break;
		}
		System.out.println("���� ���⸦ �Ͻðڽ��ϱ�");
		int goal;
		while (true) {
			goal = sc.nextInt();
			if (goal > (2 * a + 2) || a <= 0) {
				System.out.printf("������ ������ ������ϴ�. 1 ~ %d���� �Է��ϼ���.\n", (2 * a + 2));
			} else
				break;
		}
		int score = 0;
		boolean[] check = new boolean[101];
		int[][] pan = new int[a][a];
		int[][] pan2 = new int[a][a];
		int r;
		int sumG[] = new int[a];
		int sumS[] = new int[a];
		int flagG[] = new int[a];
		int flagS[] = new int[a];
		int sum, sum2, sum3, sum4;
		int c;
		int f1 = 0, f2 = 0, f3 = 0, f4 = 0;
		System.out.println("1: �ڵ� ��ȣ  2: ���� �Է�");
		int o = sc.nextInt();
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < a; j++) {
				while (true) {
					r = ran.nextInt(100) + 1;
					if (check[r] == false) {
						check[r] = true;
						pan2[i][j] = r;
						break;
					} else if (check[r] == true) {
						continue;
					}
				}
			}
		}
		switch (o) {
		case 1:
			for (int i = 0; i < a; i++) {
				for (int j = 0; j < a; j++) {
					while (true) {
						r = ran.nextInt(100) + 1;
						if (check[r] == false) {
							check[r] = true;
							pan[i][j] = r;
							break;
						} else if (check[r] == true) {

							continue;
						}
					}
				}
			}
			break;
		case 2:
			for (int i = 0; i < a; i++) {
				for (int j = 0; j < a; j++) {
					while (true) {
						r = sc.nextInt();
						if (check[r] == false) {
							check[r] = true;
							pan[i][j] = r;
							break;
						} else if (check[r] == true) {
							System.out.println("�ߺ��� ���ڰ� �־��.");
							continue;
						}
					}
				}
				System.out.println(Arrays.toString(pan[i]));
			}
			break;
		}
		while (true) {			
			System.out.println("####################################\n");
			for (int i = 0; i < a; i++) {
				for (int j = 0; j < a; j++) {
					System.out.print(pan2[i][j] + "\t");
				}
				System.out.println();
			}
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n\n");
			
			for (int i = 0; i < a; i++) {
				for (int j = 0; j < a; j++) {
					System.out.print(pan[i][j] + "\t");
				}
				System.out.println();
			}
			System.out.println(" ��ȣ�� �Է��ϼ���.");
			r = sc.nextInt();
			c = 0;
			loop: for (int i = 0; i < a; i++) {
				for (int j = 0; j < a; j++) {
					if (pan[i][j] == r) {
						pan[i][j] = 0;
						c = 1;
						break loop;
					}
				}
			}
			if (c == 0)
				System.out.println("�ǿ� ���� ���� �Դϴ�.");
			sum3 = 0;
			for (int i = 0, j = 0; i < a; i++, j++) {
				sum3 += pan[i][j];
			}
			sum4 = 0;
			for (int i = 0, j = a - 1; i < a; i++, j--) {
				sum4 += pan[i][j];
			}

			for (int i = 0; i < a; i++) {
				sum = 0;
				sum2 = 0;
				for (int j = 0; j < a; j++) {
					sum += pan[i][j];
					sum2 += pan[j][i];
				}
				sumG[i] = sum;
				sumS[i] = sum2;
				if (sumG[i] == 0 && flagG[i] == 0) {
					System.out.println(++score + " ����@@");
					flagG[i] = 1;
				}
				if (sumS[i] == 0 && flagS[i] == 0) {
					System.out.println(++score + " ����@@");
					flagS[i] = 1;
				}
				if (sum3 == 0 && f3 == 0) {
					System.out.println(++score + " ����@@");
					f3 = 1;
				}
				if (sum4 == 0 && f4 == 0) {
					System.out.println(++score + " ����@@");
					f4 = 1;
				}
			} // end for
			if (score >= goal) {
				System.out.println("!!!�̰��!!!");
				break;
			}
		} // end while

	}

}
