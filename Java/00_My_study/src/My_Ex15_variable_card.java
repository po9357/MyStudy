
public class My_Ex15_variable_card {

	public static void main(String[] args) {
		System.out.println("Card.width : "+ Card.width);		
		System.out.println("Card.heigth : "+ Card.heigth);		
											//Card.width, Card.heigth�� ���� Ŭ��������(static����)��
		Card c1 = new Card();				//	������ ��ü ���� ���� 'Ŭ����.Ŭ��������'�� �ҷ� ��� ����
		c1.kind = "Heart";
		c1.number = 7;
		
		Card c2 = new Card();
		c2.kind = "Spade";			//�ν��Ͻ� ������ ���� ����	(CardŬ������ kind, number�� �ν��Ͻ�����)
		c2.number = 4;				//�ν��Ͻ� ������ ���� ����
		
		System.out.println("c1�� "+ c1.kind +", "+ c1.number
				+ "�̸�, ũ��� ("+ c1.width +", "+ c1.heigth +")");
		System.out.println("c2�� "+ c2.kind +", "+ c2.number
				+ "�̸�, ũ��� ("+ c2.width +", "+ c2.heigth +")");
		System.out.println("c1�� width�� height�� ���� 50, 80���� �����մϴ�.");
		c1.width = 50;				//Ŭ���� ������ ���� ����	(Card class�� static�� ���� ������
		c1.heigth = 80;				//Ŭ���� ������ ���� ����		Ŭ���� ����(static����)�̴�.)
		
		System.out.println("c1�� "+ c1.kind +", "+ c1.number
				+ "�̸�, ũ��� ("+ c1.width +", "+ c1.heigth +")");
		System.out.println("c2�� "+ c2.kind +", "+ c2.number
				+ "�̸�, ũ��� ("+ c2.width +", "+ c2.heigth +")");
		
		
		
	}
}	
class Card {
	String kind;
	int number;
	static int width  = 100;
	static int heigth = 250;
}
	

