package com.mystudy.pm01_interface;

//�������̽� ���� ���(���ȭ�� Ŭ��������, �߻�޼ҵ�)
//Ŭ������� : public static final Ÿ�� ������
//�߻�޼ҵ� : ����θ� �ִ� �޼ҵ�
//         public abstract ����Ÿ�� �޼ҵ��();
// - �޼ҵ忡 ������ {} �� ����
public interface I_Phone {
	//����(Ŭ���� ���)
	public static final boolean SUCCESS = true;
	boolean FAIL = false; //public static final ����
	
	//�߻�޼ҵ�
	public abstract String getType();
	abstract String getPhoneNo(); //public ����
	public String toString(); //abstract ����
	void call(); //public abstract ����
	void receiveCall(); //public abstract ����
	void sendMsg(); //public abstract ����
	void receiveMsg(); //public abstract ����
}
