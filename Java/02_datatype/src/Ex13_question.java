
public class Ex13_question {

	public static void main(String[] args) {
		//삼항연산자(Ternary Operator)
		//사용형태 : 조건 ? true일때 실행문장 : false일때 실행문장;
		int num1 = 30;
		int num2 = 20;
		boolean big = num1 > num2;
		System.out.println(big);
		
		String str = "문자열저장 String타입";
		System.out.println("str : " + str);
		
		System.out.println("--- 삼항연산자 실행 결과 ----");
		str = (num1 > num2) ? "num1크다" : "num1 크지않다";
		System.out.println("num1 > num2 결과 : " + str);

	}

}
