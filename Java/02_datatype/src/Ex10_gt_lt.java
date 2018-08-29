
public class Ex10_gt_lt {

	public static void main(String[] args) {
		//비교연산자 : >, <, >= (크거나 같다), <= (작거나 같다)
		//         == (같다), != (같지 않다, 다르다)
		//비교 연산의 결과 : true, false
		int num1 = 10;
		int num2 = 20;
		int num3 = 20;
		//num1 > num2 : ??
		System.out.println(num1 +" > "+ num2 +" : "+ (num1 > num2));
		System.out.println(num1 +" < "+ num2 +" : "+ (num1 < num2));
		System.out.println(num1 +" >= "+ num2 +" : "+ (num1 >= num2));
		System.out.println(num1 +" <= "+ num2 +" : "+ (num1 <= num2));
		System.out.println(num1 +" != "+ num2 +" : "+ (num1 != num2));
		//num2 == num3 : ??
		System.out.println(num2 +" == "+ num3 +" : "+ (num2 == num3));
		
		System.out.println("---------------------");
		//부정의 의미 : ! (not)
		boolean power = true; //전원이 켜짐
		System.out.println("power : " + power);
		power = !power;
		System.out.println("power : " + power);
		power = !power;
		System.out.println("power : " + power);
		
		System.out.println("-------------");
		power = false;
		//power 값이 true 일때 if문 실행
		if (power) { //power가 true값을 가지면 실행
			System.out.println("power값이 true : 전원 ON 상태 입니다");
		}
		//power 값이 false 일때 if문 실행
		if (!power) { //power 값이 true일때 실행되지 않고, false 일때 실행
			System.out.println("power값이 false : 전원 OFF 상태 입니다");
		}
		
		
		System.out.println(">>> 프로그램 끝 ");
	}

}
