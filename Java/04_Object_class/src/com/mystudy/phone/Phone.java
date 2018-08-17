package com.mystudy.phone;

//���������� : public, protected, (default), private
//Ŭ���� : public, (default)
//������ : Ŭ������ ���� ������ ������ ���
//�ʵ�, �޼ҵ� : public, protected, (default), private
public class Phone {
	//�ʵ弱��(�Ӽ�)
	String name;	//������ : null�� �ʱ�ȭ
	String type;
	int hsize;	//int : 0 �ʱ�ȭ (�ʱⰪ�� �������� ������)
	int vsize;
	boolean hasLCD;
	
	Phone () {}				//�⺻ ������
	public Phone(String n, String t) {
		name = n;
		type = t;
		hsize = 55;
		vsize = 115;
	}
	
	public Phone(String n, String t, boolean l) {
		this.name = n;			//this	-> ���� ��ü�� ���� �Ӽ��� �ǹ�
		type = t;				//super	-> super class(��ü)�� ���� �Ӽ��� �ǹ�
		hasLCD = l;
		hsize = 50;
		vsize = 87;
	}
	
	void call() {
		System.out.println(">>��ȭ �ɱ�");
	}
	
	void receiveCall() {
		System.out.println(">>��ȭ �ޱ�");
	}
	
	void sendSms(String sm) {
		System.out.println("[�޽��� ����] : " + sm);
	}
	
	public String receiveSms(String rm) {
		System.out.println("[�޽��� ����] : "+rm);
		return rm;
	}
	
	public void view() {
		System.out.println("=== ��� ���� ===");
		System.out.println("�𵨸� : " + name);
		System.out.println("Ÿ�� : " + type);
		System.out.println("���� ũ�� : " + hsize +"mm");
		System.out.println("���� ũ�� : " + vsize +"mm");
		System.out.println("LCD ���� : " + hasLCD);
	}
	

}
