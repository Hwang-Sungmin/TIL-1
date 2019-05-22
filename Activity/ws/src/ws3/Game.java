package ws3;

//��縶��
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
//4.�� �÷��̾ �ֻ����� �ѹ��� ���� ���� ���ڸ�ŭ �̵�
//5.�ش� ��ġ�� �ִ� ���ڸ�ŭ ����Ʈ ����
//6.����ؼ� ������ �� ����Ʈ�� 0���ϰ� �� �÷��̾� �й�
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		int[][] map = new int[8][8];
		int p1 = 1000, p2 = 1000;
		boolean t = true;
		int[] p1s = { 0, 0 };
		int[] p2s = { 0, 0 };
		int c = 0;
		int i = 0;
		int j = 0;
		int cnt = 0;
		int r;
		// �׵θ����� ����Ḧ ���� �迭 ����
		for (i = 0; i < map.length - 1; i++) {
			r = ran.nextInt(100) + 1;
			map[i][j] = r;
		}
		for (i = 0; i < map.length - 1; i++) {
			r = ran.nextInt(100) + 1;
			map[j][i] = r;
		}
		for (j = 7; i >= 0; i--) {
			r = ran.nextInt(100) + 1;
			map[j][i] = r;
		}
		for (i = 0; i < map.length - 1; i++) {
			r = ran.nextInt(100) + 1;
			map[i][j] = r;
		}
		for(i=0;i<map.length;i++) {
			for(j=0;j<map.length ;j++) {
				System.out.print(map[i][j]+"\t");
			}
			System.out.println();
		}
		String str;
		while (true) {
			if (t) {
				System.out.println("�������� �����Ͻ÷��� �ƹ�Ű�� �Է��ϼ���");
				str = sc.next();
				System.out.println("Player1's turn");
				System.out.printf("������ġ: %d,%d ���� �ֻ���: ", p1s[0], p1s[1]);
				r = ran.nextInt(6) + 1;
				System.out.println(r);
				p1s = move2(p1s, r);
				System.out.printf("������ ��ġ: %d,%d ", p1s[0], p1s[1]);
				System.out.println("�����: " + map[p2s[0]][p2s[1]]);
				p1 -= map[p1s[0]][p1s[1]];
				System.out.println("���� ��: " + p1);
				t = false;
			} else {
				System.out.println("�������� �����Ͻ÷��� �ƹ�Ű�� �Է��ϼ���");
				str = sc.next();
				System.out.println("Player2's turn");
				System.out.printf("������ġ: %d,%d ���� �ֻ���: ", p2s[0], p2s[1]);
				r = ran.nextInt(6) + 1;
				System.out.println(r);
				p2s = move2(p2s, r);
				System.out.printf("������ ��ġ: %d,%d ", p2s[0], p2s[1]);
				System.out.println("�����: " + map[p2s[0]][p2s[1]]);
				p2 -= map[p2s[0]][p2s[1]];
				System.out.println("���� ��: " + p2);
				t = true;
			}
			System.out.println();
			cnt++;
			if (p1 <= 0) {
				System.out.println("Player2's win");
				break;
			}
			if (p2 <= 0) {
				System.out.println("Player1's win");
				break;
			}
		} // end while

	}

	static int[] move2(int[] a, int b) {
		int[] res = a;
		int c;
		if (res[0] == 0 && res[1] != 7) // ����������
			res[1] += b;
		else if (res[0] != 7 && res[1] == 7) // �Ʒ���
			res[0] += b;
		else if (res[0] == 7 && res[1] != 0) // ��������
			res[1] -= b;
		else if (res[0] != 0 && res[1] == 0) // ��������
			res[0] -= b;

		if (res[0] == 0 && res[1] > 7) { // ������ ����
			c = res[1] - 7; // ��ģ��ŭ
			res[0] += c; // �Ʒ��� ���ϰ�
			res[1] = 7; // ���ڸ���
		}
		if (res[0] > 7 && res[1] == 7) {
			c = res[0] - 7;
			res[1] -= c;
			res[0] = 7;
		}
		if (res[0] == 7 && res[1] < 0) {
			c = 0 - res[1];
			res[0] -= c;
			res[1] = 0;
		}
		if (res[0] < 0 && res[1] == 0) {
			c = 0 - res[0];
			res[1] += c;
			res[0] = 0;
		}
		return res;

	}

}
