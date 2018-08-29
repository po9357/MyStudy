public class Ex01_boolean {
	public static void main(String[] args) {
		//변수선언 형태 : 데이타타입 변수명
		//boolean타입 : true, false 값을 가짐
		boolean bool1 = true; //문자열 "true"가 아님
		boolean bool2 = false;
		System.out.println("bool1 : " + bool1);
		System.out.println("bool2 : " + bool2);
		System.out.println("------------------");
		
		bool1 = false;
		bool1 = 100 > 200; //비교연산 결과값 저장
		if (bool1) {
			System.out.println("bool1의 값은 true");
		} else {
			System.out.println("bool1의 값은 false");
		}
		
	}
}
