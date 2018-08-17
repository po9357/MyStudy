
public class Ex01_if {

	public static void main(String[] args) {
		//제어문-분기문(비교문)
		//if문
		//if (비교문) { 비교결과 true일 때 실행할 문장들; }
		/*
		if (비교문) {
			실행할 문장;
		}
		*/
		int num1 = 10;
		int num2 = 20;
		if (num1 < num2) {
			System.out.println("num1이 num2보다 작다.");
		}
		System.out.println(">>> 비교작업 끝");
		
		System.out.println("-------------");
		boolean result = num1 < num2;
		if (result) {
			System.out.println("num1이 num2보다 작다.");
		}
		
		//-------------------------------
		//점수 평가 결과 : 수, 우, 미, 양, 가
		//100 ~ 90 : 수
		//89 ~ 80 : 우
		//79 ~ 70 : 미
		//69 ~ 60 : 양
		//59 ~ 0 : 가
		int jumsu = 90;
		if (jumsu < 100 && jumsu >= 90) {
		//if (jumsu >= 90 && jumsu < 100 ) {
		//if (90 >= jumsu && 100 < jumsu ) {
		//if (90 <= jumsu && jumsu < 100) { //90 <= jumsu < 100
			System.out.println("성적 : 수");
		}
		if (jumsu < 90 && jumsu >= 80) { //80 ~ 89
			System.out.println("성적 : 우");
		}
		if (jumsu <= 79 && jumsu >= 70) {
			System.out.println("성적 : 미");
		}
		if (jumsu < 70 && jumsu >= 60) {
			System.out.println("성적 : 양");
		}
		if (jumsu < 60 && jumsu >= 0) {
			System.out.println("성적 : 가");
		}
		System.out.println(">>> 성적처리 끝");
		
	}

}
