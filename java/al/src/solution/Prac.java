package solution;

import java.util.*;

public class Prac {
	public static void main(String[] args) {
		String name = "JAZ";
		solution(name);
	}

	public static int solution(String name) {
		int answer = 0;
		int l = name.length();
		char[] n = new char[l];
		n = name.toCharArray();
		// i ��° �ڸ��� ���ڸ� �����ͼ� Z���� ���°� ������ A���� ���°� ������ ���ϰ� �� ���� ��ŭ ���� ���Ѵ�.
		int fromz = 0;
		int toa = 0;
		int cnt = 0; // ���������� �����϶�
		int cnt2 = 0; // �������� �����϶�
		int tmp = 0;
		// ���� ù ���ڴ� Ŀ���� �����̱� ���� ���.
		fromz = 'Z' - n[0] + 1;
		toa = n[0] - 'A';
		tmp = fromz < toa ? fromz : toa;
		cnt += tmp;
		cnt2 += tmp;
		// ++ �� ���� ���ڷ� �̵�. �ش� ���ڿ��� ����� �� ������ ����ϰ� cnt�� ���ѵڿ� �������ڷ� �̵�.
		for (int i = 1, j = l - 1; i < l; i++, j--) {
			{ // ���������� ����
				cnt++;
				fromz = 'Z' - n[i] + 1;
				toa = n[i] - 'A';
				tmp = fromz < toa ? fromz : toa;
				cnt += tmp;
			}
			{// �������� ����
				cnt2++;
				fromz = 'Z' - n[j] + 1;
				toa = n[j] - 'A';
				tmp = fromz < toa ? fromz : toa;
				cnt2 += tmp;
				System.out.println(n[j] + " " + cnt2);
			}
			// ���������� �����ϴ� �༮�� A �� ĭ�� �ѱ��� �ʰ� ������.
			
			
		}
		System.out.println();
		System.out.println();
		System.out.println(cnt);
		System.out.println(cnt2);

		return answer;
	}
}
