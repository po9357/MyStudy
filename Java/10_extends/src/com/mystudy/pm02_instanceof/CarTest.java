package com.mystudy.pm02_instanceof;

public class CarTest {

	public static void main(String[] args) {
		System.out.println("=== Car 클래스 ===");
		Car car = new Car();
		car.type = "자동차";
		System.out.println("타입: " + car.type);
		car.drive();
		car.stop();
		
		System.out.println("==== Ambulance ===");
		Ambulance am = new Ambulance();
		am.type = "구급차";
		System.out.println("타입: " + am.type);
		am.drive();
		am.stop();
		am.siren();
		
		System.out.println("==== FireEngine =====");
		FireEngine fe = new FireEngine();
		fe.type = "소방차";
		System.out.println("타입: " + fe.type);
		fe.drive();
		fe.stop();
		fe.siren();
		fe.water();
		
		System.out.println("----------------------");
		//Car <- Ambulance
		Car carTemp = new Car();
		carTemp = am; //자동형변환 : Car <- Ambulance
		carTemp.drive();
		carTemp.stop();
		Ambulance am2 = (Ambulance)carTemp; //명시적 형변환, 강제형변환
		am2.siren();
		((Ambulance)(carTemp)).siren(); //명시적 형변환

/*	
		System.out.println("---- Ambulance <- Car -----");
		//Ambulance <- Car : 부모타입을 자녀타입으로 형변환하는 것은 안됨
		//컴파일시에는 허용하지만 실행시 ClassCastException 예외 발생됨
		Ambulance amTemp = new Ambulance();
		amTemp = (Ambulance) car; //자동형변환 안됨 : Ambulance <- Car
		System.out.println(">>> ((Ambulance)car).siren ");
		amTemp.siren();
*/	
/*		
		//-----------------------
		//소방차 <- 구급차
		System.out.println("---- FireEngine <- Ambulance -------");
		carTemp = am;
		//컴파일시에는 허용하지만 실행시 ClassCastException 예외 발생됨
		fe = (FireEngine) carTemp; //FireEngine <- Ambulance
		fe.siren();
		fe.water();
*/		
		
		System.out.println("---- instanceof 타입 확인 ---");
		carTemp = am; //Car <- Ambulance
		if (carTemp instanceof Car) { //Car타입의 객체냐?
			car.drive();
			car.stop();
		} 
		if (carTemp instanceof Ambulance) { //Ambulance 객체냐?
			((Ambulance)carTemp).siren(); //구급차
		}
		if (carTemp instanceof FireEngine) {//FireEngine 객체냐?
			((FireEngine) carTemp).siren();
			((FireEngine) carTemp).water();
		}
		
		System.out.println("--- function 동작 ----");
		System.out.println("--- Car function ---");
		function(car);
		
		System.out.println("--- Ambulance function ---");
		function(am);
		
		System.out.println("--- FireEngine function ---");
		function(fe);
	}
	
	static void function(Car car) {
		car.drive();
		car.stop();
		
		//instanceof : 객체의 타입 확인
		//비교할객체 instanceof 비교클래스명(타입명)
		if (car instanceof Ambulance) { //Ambulance 객체냐?
			((Ambulance) car).siren(); //구급차
		}
		if (car instanceof FireEngine) {//FireEngine 객체냐?
			((FireEngine) car).siren();
			((FireEngine) car).water();
		}
	}

}






