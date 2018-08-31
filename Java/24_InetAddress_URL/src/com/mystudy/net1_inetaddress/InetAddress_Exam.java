package com.mystudy.net1_inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddress_Exam {

	public static void main(String[] args) throws UnknownHostException {
		//InetAddress : IP주소 관련 클래스
		InetAddress iaddr = InetAddress.getLocalHost();
		System.out.printf("호스트이름: %s \n", iaddr);
		System.out.printf("호스트 IP주소: %s \n", iaddr.getHostAddress());

		//---------------------------
	}

}
