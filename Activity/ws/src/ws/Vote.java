package ws;
import java.util.Arrays;
import java.util.Random;
public class Vote {
	public static void main(String[] args) {
//		1������ 5�������� �����ĺ� ���� ���
//		�� 50���� ��ǥ �ο��� 5���� ��ǥ�� ���� �Ͽ���.
		int []mem = new int[5];
		char []memN= {'A','B','C','D','E'};
		int []vote = new int[50];
		Random ran = new Random();
		for(int i=0;i<50;i++) {
			vote[i] = ran.nextInt(5);
		}
		for(int i:vote)
			mem[i]++;
		System.out.println(Arrays.toString(mem));		
		System.out.println(Arrays.toString(memN));		
//		1. ���� ���� ��ǥ�� ���� �ĺ��� ������ ��� �Ͻÿ�
//		2. ���� ���� ��ǥ�� ���� �ĺ��� ������ ��� �Ͻÿ�
		int max=-1;
		int min=51;
		int maxM=-1;
		int minM=-1;
		for(int i=0;i<mem.length;i++) {
			if(mem[i]>max) {
				max = mem[i];				
				maxM=i+1;
			}
			if(mem[i]<min) {
				min = mem[i];
				minM=i+1;
			}
		}
		System.out.printf("�ִ��ǥ�� : %d�� %dǥ\n�ּҵ�ǥ�� : %d�� %dǥ\n",maxM,max,minM,min);
//		3. ��ǥ ��� ���� ǥ�� ���� ���� ���� ������ ���� �Ͽ� ��� �ϰ�
		for(int i=0;i<mem.length;i++) {
			for(int j=i;j<mem.length;j++) {
				if(mem[i]<mem[j]) {
					int tmp = mem[i];
					mem[i]=mem[j];
					mem[j]=tmp;
					char tmp2 = memN[i];
					memN[i] = memN[j];
					memN[j]=tmp2;
				}
			}
		}
		System.out.printf("��ǥ %s\n",Arrays.toString(mem));		
		System.out.printf("��ǥ�� %s\n\n",Arrays.toString(memN));	
//		4. ��ǥ ��� ���� ǥ�� ���� ���� ������ ���� �Ͽ� ��� �Ͻÿ�
		for(int i=0;i<mem.length;i++) {
			for(int j=i;j<mem.length;j++) {
				if(mem[i]>mem[j]) {
					int tmp = mem[i];
					mem[i]=mem[j];
					mem[j]=tmp;
					char tmp2 = memN[i];
					memN[i] = memN[j];
					memN[j]=tmp2;
				}
			}
		}System.out.printf("��ǥ %s\n",Arrays.toString(mem));
		
		System.out.printf("��ǥ�� %s\n",Arrays.toString(memN));
	}
}
