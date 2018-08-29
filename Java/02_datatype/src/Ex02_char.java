public class Ex02_char {

	public static void main(String[] args) {
		//문자형(Character - char) : 2byte, 문자1글자 저장(65536개)
		//자바 문자처리 유니코드(Unicode) 형태
		char ch1 = 'A'; //"A"는 문자열(String)
		System.out.println("ch1 : " + ch1); //A : 아스키코드값 65
		System.out.println(ch1);
		System.out.println(ch1 + 1); //65 + 1
		System.out.println( (char)(ch1 + 1) ); //(char)66
		System.out.println(    (char)(67)   );
		
		char ch2 = '가';
		System.out.println("ch2: " + ch2);
		System.out.println(   (ch2 + 1)   );
		System.out.println(   (char)(ch2 + 1)   );

		//유니코드 표현방식 : \uAC00 - 가
		char ch3 = '\uAC01';
		System.out.println("ch3: " + ch3);
		
		ch3 = '\uD7A3';
		System.out.println("ch3: " + ch3);
		
	}

}
