
public class My_Ex15_variable_card {

	public static void main(String[] args) {
		System.out.println("Card.width : "+ Card.width);		
		System.out.println("Card.heigth : "+ Card.heigth);		
											//Card.width, Card.heigth과 같은 클래스변수(static변수)는
		Card c1 = new Card();				//	별도의 객체 생성 없이 '클래스.클래스변수'로 불러 사용 가능
		c1.kind = "Heart";
		c1.number = 7;
		
		Card c2 = new Card();
		c2.kind = "Spade";			//인스턴스 변수의 값을 변경	(Card클래스의 kind, number가 인스턴스변수)
		c2.number = 4;				//인스턴스 변수의 값을 변경
		
		System.out.println("c1은 "+ c1.kind +", "+ c1.number
				+ "이며, 크기는 ("+ c1.width +", "+ c1.heigth +")");
		System.out.println("c2은 "+ c2.kind +", "+ c2.number
				+ "이며, 크기는 ("+ c2.width +", "+ c2.heigth +")");
		System.out.println("c1의 width와 height를 각각 50, 80으로 변경합니다.");
		c1.width = 50;				//클래스 변수의 값을 변경	(Card class의 static이 붙은 변수가
		c1.heigth = 80;				//클래스 변수의 값을 변경		클래스 변수(static변수)이다.)
		
		System.out.println("c1은 "+ c1.kind +", "+ c1.number
				+ "이며, 크기는 ("+ c1.width +", "+ c1.heigth +")");
		System.out.println("c2은 "+ c2.kind +", "+ c2.number
				+ "이며, 크기는 ("+ c2.width +", "+ c2.heigth +")");
		
		
		
	}
}	
class Card {
	String kind;
	int number;
	static int width  = 100;
	static int heigth = 250;
}
	

