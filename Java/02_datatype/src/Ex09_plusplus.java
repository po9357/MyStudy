﻿
public class Ex09_plusplus {

	public static void main(String[] args) {
		//증감연산자 : ++, --
		//사용형태 : ++변수명, 변수명++, --변수명, 변수명--
		//++ : 값을 1 증가 시킴
		//-- : 값을 1 감소 시킴
		// ++num -> num = num + 1;
		int num1 = 100;
		num1 = num1 + 1; // ++num1; 또는 num1++
		System.out.println("num1 = num1 + 1 : " + num1);
		
		num1 = 100;
		++num1;
		System.out.println("++num1 : " + num1);
		
		num1 = 100;
		num1++;
		System.out.println("num1++ : " + num1);
		
		System.out.println("-----------------");
		int sum = 0;
		num1 = 100;
		sum = ++num1 + 1;
		//sum 값 출력
		//num1 값 출력
		System.out.println("num1 : " + num1);
		System.out.println("sum : " + sum);
		
		num1 = 100;
		sum = num1++ + 1;
		//sum 값 출력
		//num1 값 출력
		System.out.println("num1 : " + num1);
		System.out.println("sum : " + sum);
		
		System.out.println("------------------");
		num1 = 100;
		System.out.println("num1 : " + num1);
		System.out.println("++num1 : " + ++num1);
		num1 = 100;
		System.out.println("num1 : " + num1);
		System.out.println("num1++ : " + num1++);
		
		System.out.println("---------------");
		num1 = 100;
		//num1--;
		--num1;
		int num2 = num1;
		System.out.println("num2 : " + num2);
		
		num1 = 100;
		num2 = 200;
		sum = 0;
		sum = ++num1 + --num2;
		System.out.println("sum : " + sum);
		
		System.out.println("====================");
		num1 = 100;
		num2 = 200;
		sum = 0;
		sum = num1++ + ++num2; //100 + 201
		System.out.println("sum : " + sum);
		
		System.out.println("--------------------");
		num1 = 100;
		num2 = 200;
		sum = 0;
		
		++num2;
		sum = num1 + num2;
		num1++;
		System.out.println("sum : " + sum);
	}
	

}
