
public class Ex06_for2 {

	public static void main(String[] args) {
		//for문 : 1~10 숫자 중 홀수를 출력(1,3,5,7,9)
		for (int i=1; i<=10; i=i+2) {
			System.out.println(i);
		}
		
		System.out.println("-------------");
		//for문 : 1~10 숫자 중 짝수를 출력(2,4,6,8,10)
		for (int i=2; i<=10; i=i+2) {
			System.out.println(i);
		}
		System.out.println("여기부터");
		for (int i=1; i<=10; i++) {
			if ((i%2) == 0) {
				System.out.println(i);
			}
		}
		System.out.println("여기까지");
		System.out.println(">>>>");
		for (int i=1; i<=10; i++) {
			if (i % 2 == 0) { //2로 나눈 나머지가 0이냐?
				System.out.println(i);
			}
		}
		
		System.out.println("================");
		//900~1000 사이의 숫자 중 17의 배수인 숫자만 출력
		for (int i=900; i<=1000; i++) {
			if (i % 17 == 0) { //17로 나눈 나머지가 0이냐?
				System.out.println(i);
			}
		}
		
		System.out.println("----------------");
		int startNum = 2000;
		int endNum = 3000;
		int divNum = 19;
		
		for (int i=startNum; i<=endNum; i++) {
			if (i % divNum == 0) { 
				System.out.println(i);
			}
		}
		System.out.println("===================");
		//2000~3000 사이의 숫자 중 19의 배수인 숫자만 출력

		
		

	}

}
