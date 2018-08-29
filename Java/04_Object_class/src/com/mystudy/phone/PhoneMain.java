package com.mystudy.phone;

public class PhoneMain {
	public static void main(String[] args) {
		
		Phone phone1 = new Phone();
		phone1.call();
		phone1.receiveCall();
		phone1.sendSms("hi");
		phone1.receiveSms("Good Bye");
		phone1.view();
		
		System.out.println("---------------------");
		
		Phone phone2 = new Phone("가로본능", "스마트폰");
		phone2.view();
		phone2.call();
		phone2.receiveCall();
		phone2.sendSms("hello");
		phone2.receiveSms("bye!");
		
		
		System.out.println("---------------------");
		Phone phone3 = new Phone("아이폰", "스마트폰", true);
		phone3.view();
		System.out.println(phone3.receiveSms("안녕"));
		
		String rms = phone3.receiveSms("하이");
//		String rms;
//		rms = phone.receiveSms("하이");
		System.out.println('-');
		System.out.println(rms);
		System.out.println('-');
		System.out.println(phone3.receiveSms("하이"));
		
	}

}
