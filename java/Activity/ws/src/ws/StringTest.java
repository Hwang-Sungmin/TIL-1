package ws;

import java.util.Scanner;

public class StringTest {

	public static void main(String[] args) {
//		1. �ҹ��ڷ� �� ���ڿ��� �Է� �޾� ��� �Ѵ�.
//		2. �Է� ���� ���ڿ��� �빮�ڷ� ����� ������ ���ٷ� �Ͽ� ��� �Ѵ�.
//		3. 2������ ������� ���ڿ��� �� char�� +5�� �Ͽ� ��ȣȭ �Ͽ� ��� �Ѵ�.
//		4. 3������ ������� ���ڿ��� ��ȣȭ �Ͽ� ���� �Է� ���� ���ڿ��� ��� �Ѵ�. 
		String in = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("�ҹ��� ���ڿ��� �Կ��ϼ���");
		in = sc.nextLine();
		String save = "";
		String out = "";
		for (int i = 0; i < in.length(); i++) {// �빮�ڷ� ��ȯ�ϱ����� 32����
			save += (char) (in.charAt(i) - 32);
		}
		System.out.println(save);
		in = save;
		save = "";
		for (int i = in.length() - 1; 0 <= i; i--) { // ���� �ٲٱ�
			save += in.charAt(i);
		}
		System.out.println(save);
		in = save;
		save = "";
		for (int i = 0; i < in.length(); i++) { // ��ȣȭ
			save += (char) (in.charAt(i) + 5);
		}
		System.out.println(save);
		for (int i = in.length() - 1; 0 <= i; i--) {// ��ȣȭ
			out += (char) (save.charAt(i) + 27);
		}
		System.out.println(out);
	}

}
