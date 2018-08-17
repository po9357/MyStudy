
public class Ex05_for {

	public static void main(String[] args) {
		//제어문 - 반복문(for, while, do~while)
		//for문
		//for (초기값; 실행(종결)조건문; 증감치) {}
		System.out.println("*");
		System.out.println("*");
		System.out.println("*");
		System.out.println("*");
		System.out.println("*");
		System.out.println("------------------");
		
		//for (초기값; 실행(종결)조건문; 증감치) {}
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
		
		//시작값을 0 부터 시작하고 1씩 증가시키면서 10회 반복 출력
		for (int i=0; i<10; i++) { //i<=9
			System.out.println("*****");
		}
		System.out.println("------------------");
		
		//1~10 숫자를 출력하세요(for문 사용)
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
		
		//주의사항: 반복인자값을 for문 내에서 변화시키는 것은 자제
		System.out.println("*******************");
		for (int i=1; i<=10; i++) {
			System.out.println(i);
			i++; //for문 내에서 i값 변경
		}
	}

}
