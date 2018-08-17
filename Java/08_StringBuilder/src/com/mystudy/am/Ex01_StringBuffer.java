package com.mystudy.am;

public class Ex01_StringBuffer {

	public static void main(String[] args) {
		//StringBuffer 클래스
		String str = new String("Hello World!!!");
		System.out.println(str);
		
		StringBuffer sb = new StringBuffer("Hello World!!!");
		System.out.println(sb);
		System.out.println("sb.length() : "+ sb.length());			//길이
		System.out.println("sb.capacity() : "+ sb.capacity());		//용량 : 16의 여유를 두고 생성
		System.out.println();
		
		str = str + " 반갑습니다.";
		System.out.println("str + \" 반갑습니다.\" : "+ str);
		System.out.println(str.toString());
		System.out.println();
		
		System.out.println(str.replace("l", "L"));		//원본 데이터 변경 안함
		System.out.println(str);
		System.out.println();
		
		System.out.println("--- StringBuffer ---");
		sb.append(" 반갑습니다.");
		System.out.println(sb);
		System.out.println(sb.toString());
		sb.reverse();				//원본 데이터 변경
		System.out.println(sb.toString());
		System.out.println(sb.reverse());
		System.out.println();
		
		System.out.println("---- delete(), insert(), replace() ----");
		System.out.println("sb.delete(0, 6) : "+ sb.delete(0, 6));
		System.out.println("sb : " +sb);
		
		System.out.println("sb.insert(0, \"Hello \") : "+ sb.insert(0, "Hello "));
		System.out.println("sb : " +sb);
		
		System.out.println("sb.replace(0, 5, \"Hi,\") : "
								+ sb.replace(0, 5, "Hi,"));
		
		System.out.println("sb.length() : "+ sb.length());			//길이 변화. (반갑습니다 등 문자 추가)
		System.out.println("sb.capacity() : "+ sb.capacity());		//용량은 유지
		
		System.out.println("----------------------------------");
		StringBuffer sb2 = new StringBuffer(100);
		System.out.println("sb2.length() : "+ sb2.length());
		System.out.println("sb2.capacity() : "+ sb2.capacity());
		
		//sb2.append("안녕하세요. 반갑습니다!!");
		sb2.append("안녕하세요.").append(" 반갑습니다!!");
		System.out.println("sb2 : "+ sb2);
		System.out.println("sb2.length() : "+ sb2.length());
		System.out.println("sb2.capacity() : "+ sb2.capacity());
		System.out.println();
		
		System.out.println("--- trimToSize() 실행 후 ---");
		sb2.trimToSize();
		System.out.println("sb2 : "+ sb2);
		System.out.println("sb2.length() : "+ sb2.length());
		System.out.println("sb2.capacity() : "+ sb2.capacity());
		System.out.println();
		
		System.out.println(">> append 실행 후");
		sb2.append(" 자바 공부 중");
		System.out.println("sb2 : "+ sb2);
		System.out.println("sb2.length() : "+ sb2.length());
		System.out.println("sb2.capacity() : "+ sb2.capacity());
		System.out.println();
		
		System.out.println(">> setLength() 실행 후");
		sb2.setLength(5);
		System.out.println("sb2 : "+ sb2);
		System.out.println("sb2.length() : "+ sb2.length());
		System.out.println("sb2.capacity() : "+ sb2.capacity());
		
	}

}
