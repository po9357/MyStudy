package com.mystudy.car;

public class CarMain {

	public static void main(String[] args) {
		
		Car car1 = new Car();
		
		System.out.println("자동차 이름: "+ car1.name);
		System.out.println("모델명: "+ car1.model);
		System.out.println("색상: "+ car1.color);
		System.out.println("차량길이: "+ car1.CAR_LENGTH);
		System.out.println("차량너비: "+ car1.CAR_WIDTH);
		System.out.println("에어백: " + car1.existAirbag);

		System.out.println("-------------------");
		
		car1.name = "처음가져본차";
		System.out.println("자동차 이름: "+ car1.name);
		car1.existAirbag = true;
		System.out.println("에어백: " + car1.existAirbag);
		
		System.out.println(">>> 기능 작동 -------------");
		car1.run();
		car1.stop();
		car1.back();
		
		System.out.println("======= Car2 =======");
		Car car2 = new Car("패밀리카", "소나타", "검정");
		
		System.out.println("자동차 이름: "+ car2.name);
		System.out.println("모델명: "+ car2.model);
		System.out.println("색상: "+ car2.color);
		System.out.println("차량길이: "+ car2.CAR_LENGTH);
		System.out.println("차량너비: "+ car2.CAR_WIDTH);
		System.out.println("에어백: " + car2.existAirbag);
		
		System.out.println(">>> 기능 작동 -------------");
		car2.run();
		car2.stop();
		car2.back();
		
		//final 변수값 변경 시도
		//The final field Car.CAR_LENGTH cannot be assigned
//		car2.CAR_LENGTH = 400;		상수처리되기 때문에 변경 못함(final)
		
		//final 
		//변수에 붙으면 변경 불가(상수처리)
		//클래스에 붙으면 확장 밑 상속 불가
		//메소드에 붙으면 오버라이딩 불가
		
		System.out.println(car2);
		System.out.println(car1);
		
	}

}