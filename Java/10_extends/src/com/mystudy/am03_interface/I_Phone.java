package com.mystudy.am03_interface;

public interface I_Phone {
	//�߻� �޼ҵ�(�������� ���� �޼ҵ�)
	void view();		//0. ��ȭ���� Ȯ��
	void call();		//1. ��ȭ�ɱ�
	void receiveCall();	//2. ��ȭ�ޱ�
	void sendMsg();		//3. �޽��� ������
	void receiveMsg(String rms);	//4. �޽��� �ޱ�

}