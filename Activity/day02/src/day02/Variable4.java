package day02;

public class Variable4 {

	public static void main(String[] args) {
		// primitive Type
		int a = 0;
		char c = 'a';

		// Reference Type - java api �� �̿� Stack - Heap ����
		String s1 = "abc";
		String s2 = "abc";
		String s3 = new String(s2);
		String s4 = new String("abc");
		if (s1.equals(s3))
			System.out.println("�����ϴ�");

		a = 0b10;
		int b = 010;
		int d = 0x10;
		System.out.printf("%d %d %d", a, b, d);

	}

}
