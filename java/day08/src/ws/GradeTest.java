package ws;

import java.util.Arrays;
import java.util.Scanner;

public class GradeTest {
	//4������ ������ �Է� �޴´�.����, ����, ����, ����	
	//�Է� ��: 89 92 89 100
	//�Է� ���� ������ �̿��Ͽ� ������ ��� �Ͻÿ�
	//1. ���� ��� �Ͻÿ�
	//2. ����� ��� �Ͻÿ�
	//3. ����� 90�� �̻��̸� A, 80�� �̻��̸� B, 70�� �̻��̸� C, 60�� �̻��̸� D, ���ϸ� F
	//4. �ְ����� ������ ��� �Ͻÿ�
	//5. �������� ������ ��� �Ͻÿ�
	//6. �������� ���� 
	//7. �������� ����
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] grades = new int[4];;
		Scanner sc = new Scanner(System.in);
		System.out.println("���� ,���� , ����, ����  �װ����� ������ �Է��ϼ���");
		for(int i=0;i<4;i++)
			grades[i] = sc.nextInt();
		Grade myg = new Grade(grades);
		System.out.println("�� ���� :"+myg.sum());
		System.out.println("������� :"+myg.avg());
		System.out.println("���� :"+myg.grade());
		System.out.println("�ְ����� :"+myg.maxsub());
		System.out.println("�������� :"+myg.minsub());
		System.out.println(Arrays.toString(myg.asort()));
		System.out.println(Arrays.toString(myg.dsort()));
		System.out.println();
	}

}
