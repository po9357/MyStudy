
public class Ex06_for_sum {

	public static void main(String[] args) {
		//����: 1~10������ �հ踦 ���Ͻÿ�(ȭ�����)
		//System.out.println(55);
		//System.out.println("1~10���� �հ�: " + (1+2+3+4+5+6+7+8+9+10));
		//��Ʈ
		int num = 0;
		int sum = 0;
		
//		num = num + 1;
//		sum = sum + num; //sum ����
//		System.out.println(sum);
		
		//���� ���α׷� ���
		for (int i=1; i<=10; i++) {
			sum = sum + i;
		}
		System.out.println("1~10������ �հ� : " + sum);
		
		//---------------------
		System.out.println("====================");
		num = 1; //1~10���� ���ϴ� ��
		sum = 0; //������ ���� ������ ����
/*		
		//�ݺ�: 1
		sum = sum + num; //sum = 0 + 1
		System.out.println("sum: " + sum);
		num = num + 1; //num: 2 -  num++, num += 1 
		
		//�ݺ�: 2
		sum = sum + num; //sum = (0 + 1) + 2
		System.out.println("sum: " + sum);
		num = num + 1; //num: 3 -  num++, num += 1 
		
		//�ݺ�: 3
		sum = sum + num; //sum = (0 + 1 + 2) + 3
		System.out.println("sum: " + sum);
		num = num + 1; //num: 3 -  num++, num += 1 
*/
		
		for (int i=1; i<=10; i++) {
			sum = sum + num; 
			System.out.println("i: "+ i +", num: "+ num + ", sum: " + sum);
			num = num + 1; 
		}
		System.out.println("1~10������ �հ�: " + sum);
		
		System.out.println(">>>>> ");
		sum = 0;
		for (int i=1; i<=10; i++) {
			sum = sum + i; 
			System.out.println("i: "+ i +", sum: " + sum);
		}
		System.out.println("1~10������ �հ�: " + sum);
		
		//-------------------------
		//10 ~ 1 ���(for��)
		/*
		10
		9
		8
		...
		1
		*/
		
		System.out.println("====================");
		System.out.print(1);
		System.out.print(2);
		System.out.print(3);
		System.out.println();
		System.out.print(4);
		System.out.print(5);
		
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}

}
