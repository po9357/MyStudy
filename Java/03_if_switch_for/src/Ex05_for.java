
public class Ex05_for {

	public static void main(String[] args) {
		//��� - �ݺ���(for, while, do~while)
		//for��
		//for (�ʱⰪ; ����(����)���ǹ�; ����ġ) {}
		System.out.println("*");
		System.out.println("*");
		System.out.println("*");
		System.out.println("*");
		System.out.println("*");
		System.out.println("------------------");
		
		//for (�ʱⰪ; ����(����)���ǹ�; ����ġ) {}
		for (int i=1; i<=5; i++) {
			System.out.println("*");
		}
		System.out.println("------------------");
//		for (int i=1; i<=5; i=i+1) {
//			System.out.println("*");
//		}
//		System.out.println("------------------");
//		for (int i=1; i<=5; i+=1) {
//			System.out.println("*");
//		}
//		System.out.println("------------------");
		//////////////////////////////////////////
		//
		
		System.out.println("*****");
		
		//���۰��� 0 ���� �����ϰ� 1�� ������Ű�鼭 10ȸ �ݺ� ���
		for (int i=0; i<10; i++) { //i<=9
			System.out.println("*****");
		}
		System.out.println("------------------");
		
		//1~10 ���ڸ� ����ϼ���(for�� ���)
		//1
		//2
		//...
		//10
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println(5);
		//...
		System.out.println(10);
		
		System.out.println("-----------");
//		int num = 1;
//		
//		System.out.println(num);
//		num = num + 1;
//		
//		System.out.println(num);
//		num = num + 1;
//		
//		System.out.println(num);
//		num = num + 1;
//		
//		System.out.println(4);
//		System.out.println(5);
//		//...
//		System.out.println(10);
		System.out.println("================");
		
		int num = 1;
		
		for (int i=0; i<10; i++) {
			System.out.println(num);
			num = num + 1;
		}
		System.out.println("================");
		for (int i=0; i<10; i++) {
			System.out.println(i + 1);
		}
		System.out.println("================");
		for (int i=1; i<=10; i++) {
			System.out.println(i);
		}
		
		//���ǻ���: �ݺ����ڰ��� for�� ������ ��ȭ��Ű�� ���� ����
		System.out.println("*******************");
		for (int i=1; i<=10; i++) {
			System.out.println(i);
			i++; //for�� ������ i�� ����
		}
	}

}
