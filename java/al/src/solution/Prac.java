package solution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Prac {
	public static void main(String[] args) {
		int n = 4;
		int[][] s = { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } };
		System.out.println(solution(n, s));
	}

	public static int solution(int n, int[][] costs) {
		int answer = 0;
		int l = costs.length;
		ArrayList<isl> list = new ArrayList<>();
		ArrayList<Integer> connected = new ArrayList<>(); // ����� ������ �̸�
		int tmp;
		for (int i = 0; i < l; i++) { // ���� ���ڰ� ���� ���� �ٲ�
			if (costs[i][0] > costs[i][1]) {
				tmp = costs[i][0];
				costs[i][0] = costs[i][1];
				costs[i][1] = tmp;
			}
		}
		for (int i = 0; i < l; i++) { // l �� ���鼭 list �� isl ���� �ִ´�.
			if (!list.contains(costs[i][0])) {// list �� ���� ��߼��̶�� ���� �����
				list.add(new isl(costs[i][0], costs[i][1], costs[i][2]));
			} else {// list�� ������ ������ �߰��Ѵ�.
				int a = list.indexOf(costs[i][0]);
				list.get(a).other.add(costs[i][1]);
				list.get(a).val.add(costs[i][2]);
			}
		}
		
		return answer;
	}

	public static class isl {
		int my;
		ArrayList<Integer> other = new ArrayList<>();
		ArrayList<Integer> val = new ArrayList<>();

		public isl(int my, int other, int val) {
			this.my = my;
			this.other.add(other);
			this.val.add(val);
		}

		public boolean checkEmpty() {
			if (other.isEmpty())
				return true;
			else
				return false;
		}

		public int minval() {// ���� �������� ����
			int min = Integer.MAX_VALUE;
			int tmp = 0;
			for (int i = 0; i < val.size(); i++) {
				if (val.get(i) < min) {
					min = val.get(i);
					tmp = i;
				}
			}
			return tmp;
		}

		public void remove(int idx) {// �������� ����
			other.remove(idx);
			val.remove(idx);
		}
	}
}
