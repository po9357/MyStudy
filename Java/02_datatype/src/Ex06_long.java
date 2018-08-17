
public class Ex06_long {
	public static void main(String[] args) {
		//정수형 long : 8byte
		//범위 : -9,223,372,036,854,775,808 
		//    ~ 9,223,372,036,854,775,807
		//long 타입값 명시적 표현 : 숫자 + L 또는 l(영문 대소문자 엘)
		long num1 = 200000000000L;
		long num2 = 300000000000l;
		long sum = num1 + num2;
		//출력 : num1 + num2 = sum
		System.out.println(num1 + " + " + num2 + " = " + sum);
		
		System.out.println("------------------");
		byte numByte = 100;
		short numShort = 3000;
		int numInt = 30000000;
		long numLong = 5000000000000L;
		
		System.out.println("numByte: " + numByte);
		System.out.println("numShort: " + numShort);
		
		numByte = (byte) numShort; //강제 형변환 short(2byte) -> byte(1byte)
		System.out.println("numByte: " + numByte);
		System.out.println("numShort: " + numShort);
		
		System.out.println("----------------");
		numInt = numShort; //자동형변환(작은데이타 타입 -> 큰 데이타 타입)
		
		numInt = (int) numLong; //long(8byte) -> int(4byte)
		System.out.println("numInt = (int)numLong : " + numInt);
		
	}
}






