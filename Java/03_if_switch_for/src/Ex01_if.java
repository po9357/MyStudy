
public class Ex01_if {

	public static void main(String[] args) {
		//���-�б⹮(�񱳹�)
		//if��
		//if (�񱳹�) { �񱳰�� true�� �� ������ �����; }
		/*
		if (�񱳹�) {
			������ ����;
		}
		*/
		int num1 = 10;
		int num2 = 20;
		if (num1 < num2) {
			System.out.println("num1�� num2���� �۴�.");
		}
		System.out.println(">>> ���۾� ��");
		
		System.out.println("-------------");
		boolean result = num1 < num2;
		if (result) {
			System.out.println("num1�� num2���� �۴�.");
		}
		
		//-------------------------------
		//���� �� ��� : ��, ��, ��, ��, ��
		//100 ~ 90 : ��
		//89 ~ 80 : ��
		//79 ~ 70 : ��
		//69 ~ 60 : ��
		//59 ~ 0 : ��
		int jumsu = 90;
		if (jumsu < 100 && jumsu >= 90) {
		//if (jumsu >= 90 && jumsu < 100 ) {
		//if (90 >= jumsu && 100 < jumsu ) {
		//if (90 <= jumsu && jumsu < 100) { //90 <= jumsu < 100
			System.out.println("���� : ��");
		}
		if (jumsu < 90 && jumsu >= 80) { //80 ~ 89
			System.out.println("���� : ��");
		}
		if (jumsu <= 79 && jumsu >= 70) {
			System.out.println("���� : ��");
		}
		if (jumsu < 70 && jumsu >= 60) {
			System.out.println("���� : ��");
		}
		if (jumsu < 60 && jumsu >= 0) {
			System.out.println("���� : ��");
		}
		System.out.println(">>> ����ó�� ��");
		
	}

}
