package solution;

import java.util.*;

public class Prac {
	public static void main(String[] args) {
		String name = "JEROEN";
		System.out.println(solution(name));
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
		fromz = 'Z' - n[0] + 1;
		toa = n[0] - 'A';
		tmp = fromz < toa ? toa : fromz;
		cnt += tmp;
		cnt++;
		cnt2 += tmp;
		cnt2++;
		

		return answer;
	}
}
