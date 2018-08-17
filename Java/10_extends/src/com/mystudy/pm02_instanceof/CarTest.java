package com.mystudy.pm02_instanceof;

public class CarTest {

	public static void main(String[] args) {
		System.out.println("=== Car Ŭ���� ===");
		Car car = new Car();
		car.type = "�ڵ���";
		System.out.println("Ÿ��: " + car.type);
		car.drive();
		car.stop();
		
		System.out.println("==== Ambulance ===");
		Ambulance am = new Ambulance();
		am.type = "������";
		System.out.println("Ÿ��: " + am.type);
		am.drive();
		am.stop();
		am.siren();
		
		System.out.println("==== FireEngine =====");
		FireEngine fe = new FireEngine();
		fe.type = "�ҹ���";
		System.out.println("Ÿ��: " + fe.type);
		fe.drive();
		fe.stop();
		fe.siren();
		fe.water();
		
		System.out.println("----------------------");
		//Car <- Ambulance
		Car carTemp = new Car();
		carTemp = am; //�ڵ�����ȯ : Car <- Ambulance
		carTemp.drive();
		carTemp.stop();
		Ambulance am2 = (Ambulance)carTemp; //����� ����ȯ, ��������ȯ
		am2.siren();
		((Ambulance)(carTemp)).siren(); //����� ����ȯ

/*	
		System.out.println("---- Ambulance <- Car -----");
		//Ambulance <- Car : �θ�Ÿ���� �ڳ�Ÿ������ ����ȯ�ϴ� ���� �ȵ�
		//�����Ͻÿ��� ��������� ����� ClassCastException ���� �߻���
		Ambulance amTemp = new Ambulance();
		amTemp = (Ambulance) car; //�ڵ�����ȯ �ȵ� : Ambulance <- Car
		System.out.println(">>> ((Ambulance)car).siren ");
		amTemp.siren();
*/	
/*		
		//-----------------------
		//�ҹ��� <- ������
		System.out.println("---- FireEngine <- Ambulance -------");
		carTemp = am;
		//�����Ͻÿ��� ��������� ����� ClassCastException ���� �߻���
		fe = (FireEngine) carTemp; //FireEngine <- Ambulance
		fe.siren();
		fe.water();
*/		
		
		System.out.println("---- instanceof Ÿ�� Ȯ�� ---");
		carTemp = am; //Car <- Ambulance
		if (carTemp instanceof Car) { //CarŸ���� ��ü��?
			car.drive();
			car.stop();
		} 
		if (carTemp instanceof Ambulance) { //Ambulance ��ü��?
			((Ambulance)carTemp).siren(); //������
		}
		if (carTemp instanceof FireEngine) {//FireEngine ��ü��?
			((FireEngine) carTemp).siren();
			((FireEngine) carTemp).water();
		}
		
		System.out.println("--- function ���� ----");
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
		
		//instanceof : ��ü�� Ÿ�� Ȯ��
		//���Ұ�ü instanceof ��Ŭ������(Ÿ�Ը�)
		if (car instanceof Ambulance) { //Ambulance ��ü��?
			((Ambulance) car).siren(); //������
		}
		if (car instanceof FireEngine) {//FireEngine ��ü��?
			((FireEngine) car).siren();
			((FireEngine) car).water();
		}
	}

}






