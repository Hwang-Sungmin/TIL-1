package programmers;

import java.util.Scanner;

public class LetterPress {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String exStr = sc.next();
        String bufStr = ""; //�ߺ� �˻縦 ���� ����
        String resultStr = ""; //�ߺ��˻縦 ��ģ ����� ���ڿ��� ������ ����
        int bufCount = 1; //�ߺ�Ƚ��

        //�Է¹��� ���ڿ��� ����
        int resultLen = exStr.length();
        //��ȯ�� ���� ����
        int resultCount = resultLen;

        //exStr/2�� �� ������ŭ �ɰ��� ����մϴ�.
        for(int i = 1 ; i <= resultLen/2; i++) {
            //i���� j������� �߶���ϴ�.
            for(int j = 1 ; j <= exStr.length()/i; j++) {
                //����׿� ��� ���
                System.out.println("���� ������ �� : " + exStr.substring((j-1)*i , j*i)  + "   bufString�� �ִ� �� :"+bufStr);
                //������ ����ߴ� ���� ��ġ�ϴ��� Ȯ���մϴ�.
                if(bufStr.equals(exStr.substring((j-1)*i , j*i))) {
                    bufCount++;
                }else {
                    if(bufCount != 1) {
                        resultStr += Integer.toString(bufCount);
                        bufCount = 1;
                    }
                    resultStr += exStr.substring((j-1)*i , j*i);
                }
                bufStr = exStr.substring((j-1)*i , j*i);
            }
            //������ ó��
            if(bufCount != 1) {
                resultStr += Integer.toString(bufCount);
                bufCount = 1;
            }
            if(resultLen % i != 0)
                resultStr += exStr.substring( resultLen - resultLen % i,resultLen);
            System.out.println("���  ��� : "+resultStr);

            //���� 1�� �ɰ��� ���� ���̺��� �۴ٸ�
            if(resultStr.length() < resultCount) {
                resultCount = resultStr.length();
//                System.out.println("�ּ��� ��� : "+resultStr);
            }
            resultStr = "";
        }
        System.out.println(resultCount);
    }

}