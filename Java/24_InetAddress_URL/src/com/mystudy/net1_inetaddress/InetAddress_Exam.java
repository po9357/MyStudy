package com.mystudy.net1_inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddress_Exam {

	public static void main(String[] args) throws UnknownHostException {
		//InetAddress : IP�ּ� ���� Ŭ����
		InetAddress iaddr = InetAddress.getLocalHost();
		System.out.printf("ȣ��Ʈ�̸�: %s \n", iaddr);
		System.out.printf("ȣ��Ʈ IP�ּ�: %s \n", iaddr.getHostAddress());

		//---------------------------
	}

}
