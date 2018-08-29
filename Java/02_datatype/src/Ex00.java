public class Ex00 {

	public static void main(String[] args) {
		//계산결과: 3
		//계산결과: 12
		//"계산결과: " + 1  ---> "계산결과: 1" + 2
		//---> "계산결과: 12"
		System.out.println("계산결과: " + 1 + 2);
		System.out.println("계산결과: " + (1 + 2));
		
		//문자열 내에 " 작성하려고 하는 경우 : \" 처리
		// "홍길동"이 말했다
		System.out.println("\"홍길동\"이 말했다");
		System.out.println("'홍길동'이 말했다");
		
		//\n(줄바꿈), \t(탭)
		//홍길동님!
		//반갑습니다.
		System.out.println("홍길동님!");
		System.out.println("반갑습니다.");
		System.out.println("홍길동님!\n반갑습니다.");
		
		System.out.println("1\t2\t3");
		System.out.println("12345678901234\t2\t3");
	}

}
