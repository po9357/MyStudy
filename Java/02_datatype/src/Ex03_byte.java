
public class Ex03_byte {

	public static void main(String[] args) {
		//정수형 byte : 정수 숫자 저장 256가지(-128 ~ 127)
		byte byte1 = 100;
		byte byte2 = 30;
		byte byte3 = 0;
		
		//sysout 타이핑 후 ctrl + space바 클릭
		System.out.println("byte1: " + byte1);
		//ctrl + alt + 화살표아래
		System.out.println("byte2: " + byte2);
		
		//바이트 타입의 연산 결과값은 int 타입이 됨
		byte3 = (byte)(byte1 + byte2);
		System.out.println("byte1 + byte2 : " + byte3);
		
	}

}
