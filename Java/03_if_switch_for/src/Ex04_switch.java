
public class Ex04_switch {

	public static void main(String[] args) {
		//switch case��
		/*
		switch (���ǰ�) {
		case �񱳰� :
			������ ����;
			break;
		case �񱳰� :
			������ ����;
			break;
		...
		default :
			������ ����;
			break;
		}
		*/
		int month = 8; //��
		String result = "";
		
		switch (month) {
		case 1:
			System.out.println("31�ϱ���  �ֽ��ϴ�");
			break;
		case 2:
			System.out.println("28 �Ǵ� 29�ϱ��� �ֽ��ϴ�");
			break;
		case 3:
			System.out.println("31�ϱ���  �ֽ��ϴ�");
			break;
		case 4:
			System.out.println("30�ϱ���  �ֽ��ϴ�");
			break;
		}
		System.out.println("--------------------");
		switch (month) {
		case 1: 
		case 3:
		case 5:
		case 7: case 8: case 10: case 12:
			System.out.println(month + "���� 31�ϱ���  �ֽ��ϴ�");
			break;
		case 2:
			System.out.println(month + "���� 28 �Ǵ� 29�ϱ��� �ֽ��ϴ�");
			break;
		
		case 4: case 6: case 9: case 11:
			System.out.println(month + "���� 30�ϱ���  �ֽ��ϴ�");
			break;
		}

		//-----------------------------------------
		//��÷ ����� ���� ��ǰ ����
		//1��: �����, 2��: ��ġ�����, 3��: ��Ź��, 4��: û�ұ�
		result = "4��";
		switch (result) {
		case "1��" :
			System.out.println("�����");
			break;
		case "2��" :
			System.out.println("��ġ�����");
			break;
		case "3��" :
			System.out.println("��Ź��");
			break;
		case "4��" :
			System.out.println("û�ұ�");
			//4���� ������ �����ϱ�� ��
		default :
			System.out.println("����");
			//break;
		}
		
		
		
		
		
	}

}





