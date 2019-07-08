package solution;

public class Mi {
	public static void main(String[] args) {
		String s = "falsefalsefalse";
		String t = "falsefalsefalsefalsefalsefalsefalsefalse";
		System.out.println(solution(s, t));
		System.out.println(solution2(s, t));

	}

	public static boolean solution(String s, String t) {
		boolean answer = true;

		int sl = s.length();
		int tl = t.length();

		String a; // ���̰� ª�� �� �ֱ�
		String b;

		int minl = sl > tl ? tl : sl; // �� �� ���� ����
		int maxl = sl > tl ? sl : tl;

		if (sl == tl)// �ΰ��� ���̰� ������
			return answer = s.equals(t);

		if (minl == sl) {
			a = s;
			b = t;

		} else {
			a = t;
			b = s;
		}

		boolean flag = false;

		for (int i = 0; i < minl; i++) {
			if (!(b.charAt(0) == a.charAt(i))) {
				flag = true; // �ٸ��� �ϳ��� ������
				answer = false;
				break;
			}
		}

		if (!flag) {// �ٸ��� ���ٸ�
			for (int i = 1; i < maxl; i++) {
				if (!(b.charAt(0) == b.charAt(i))) {
					answer = false;
					break;
				}
			}
		}

		if (maxl % minl == 0) { // ���̰� ������ �������ٸ�,
			// ū�� �ȿ��� �������� ��� �ݼӵǾ� ������ üũ
			for (int i = 0; i < maxl; i += minl) {
				System.out.println(i + minl);
				if (!(b.substring(i, i + minl).equals(a))) {
					answer = false;
					break;
				}
			}
		} else {
			int ll = maxl % minl;
			for (int i = 0; i < minl; i += ll) {
				System.out.println(b.substring(maxl - ll, maxl));
				if (!(a.substring(i, i + ll).equals(b.substring(maxl - ll, maxl)))) {
					answer = false;
					break;
				}
			}

		}
		return answer;
	}

	public static boolean solution2(String s, String t) {
		boolean answer = true;
		int sl = s.length();
		int tl = t.length();
		String a; // ���̰� ª�� �� �ֱ�
		String b;
		int minl = sl > tl ? tl : sl; // �� �� ���� ����
		int maxl = sl > tl ? sl : tl;
		if (sl == tl)// �ΰ��� ���̰� ������
			return s.equals(t);
		if (minl == sl) {
			a = s;
			b = t;
		} else {
			a = t;
			b = s;
		}
		int n = 0;
		String bb = "";
		for (int i = 1; i <= minl * maxl; i++) {
			bb += b;
			if (maxl * i % minl == 0) {
				n = maxl * i;
				break;
			}
		}
		System.out.println(n);
		String aa = "";
		for (int i = 0; i < n / minl; i++) {
			aa += a;
		}
		System.out.println(bb);
		System.out.println(aa);
		if (bb.equals(aa))
			answer = true;
		else
			answer = false;

		return answer;
	}
}
