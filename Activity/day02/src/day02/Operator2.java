package day02;

public class Operator2 {
	public static void main(String[] args) {
		// �Ҽ��� 3�ڸ����� ���� ����ϰ� ���
		// �Ҽ��� 3�ڸ����� �ݿø� ����ϰ� ���
		double d = 3.141592;
		double a, b;
		a = (int) (d * 1000);
		a /= 1000.0;
		b = (int) (d * 1000 + 0.5) / 1000d;
		System.out.println(a + "\n" + b);

		a = Math.floor(d * 1000) / 1000d;
		b = Math.round(d * 1000) / 1000d;
		System.out.println(a + "\n" + b);

		// ���μ��ΰ� 5,4�� �ﰢ���� ������ ���̸� ���ض�
		int x = 5, y = 4;
		double z;
		z = Math.sqrt(x * x + y * y);
		System.out.println(z);
		System.out.println(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));

	}
}
