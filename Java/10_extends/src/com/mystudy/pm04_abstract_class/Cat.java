package com.mystudy.pm04_abstract_class;

public class Cat extends Animal {
	//��Ӱ��迡 �ִ� Ŭ��������
	//�θ�Ÿ�Կ� �ִ� �޼ҵ带 �ڽ�Ÿ���� Ŭ�������� ������
	//������ �����ϰ� ��ɸ� �ٸ��� ����
	//������ ���� : ����Ÿ��, �޼ҵ��, �Ķ���Ͱ� ����(�Ķ���� ����,����,Ÿ����ġ)
	//�޼ҵ� �������̵�(Overriding)
	@Override
	void sound() {
		System.out.println(">> �߿� �߿�");
	}
}
