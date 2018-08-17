
public class Ex08_double {

	public static void main(String[] args) {
		//실수형 double : 8 byte(범위 -1.7E308 ~ 1.7E308)
		//표시형식 : 숫자.숫자     / 숫자.숫자 + D 또는 d
		double d1 = 1.1;
		double d2 = 1.12345678901234567890d;
		System.out.println("double 1.1 : " + d1);
		System.out.println("double 1.12345678901234567890d : " + d2);
		
		double sum = d1 + d2;
		System.out.println("d1 + d2 : " + sum);

		System.out.println("3.4d + 3.2d : " + (3.4d + 3.2d));
		
		float f1 = 3.4f;
		d1 = f1; //double <- float : 자동형변환
		
		//정수형 <->실수형
		f1 = 123456789012345.0f;
		System.out.println("123456789012345.0f : " + f1);
		
		d1 = 123456789012345.0d;
		System.out.println("123456789012345.0d ->double : " + d1);
		
		int numInt = 1234567890;
		f1 = numInt; //자동형변환 처리
		System.out.println("1234567890 -> float : " + f1);
		
		//numInt = f1; //자동형변환 되지 않음 : float 표현범위가 int보다 크기 때문
	}

}



