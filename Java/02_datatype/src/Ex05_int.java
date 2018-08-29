
public class Ex05_int {

	public static void main(String[] args) {
		//정수형 int : 4byte, 범위(-2,147,483,648 ~ 2,147,483,647)
		int num1 = 70000;
		int num2 = 30000;
		int sum = num1 + num2; //sum <- num1 + num2
		//num1 + num2 = sum
		System.out.println(num1 + " + " + num2 + " = " + sum);
		System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
		System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
		System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
		// % 연산자 : 나누기 연산 후 나머지 값을 구함
		System.out.println(num1 + " % " + num2 + " = " + (num1 % num2));
		
		//0으로 나누는 경우 
		int num3 = 0;
		System.out.println(num1 + " / 0" + (num1 / num3));
		
		System.out.println(">>> 프로그램의 끝");

	}

}
