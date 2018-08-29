package com.mystudy.string;

public class Ex02_String2 {
	
	public static void main(String[] args) {
		//String 메소드들
		String st1 = "Java";
		System.out.println(st1);
		System.out.println(st1.toString());
		
		System.out.println("--- indexOf() ---");	//문자열의 위치를 찾는 메소드
		System.out.println(st1.indexOf("J"));		//없으면 -1, 0 부터 해당 문자가 어딨는지 int값으로 알려줌.
													//			(배열 번호라 생각하면 편함)
		System.out.println("--- isEmpty ---");
		System.out.println(st1.isEmpty());			//st1 = "";라면 true값 반환
		
		System.out.println("--- replace() ---");
		System.out.println("st1 : "+ st1);
		System.out.println(st1.replace('a', 'B'));	//원본 데이터는 변하지 않음.
		System.out.println(st1);					
	
		st1 = "java java";
		System.out.println("st1: " + st1);
		System.out.println(st1.replaceAll("ja", "Ja"));
		System.out.println(st1.replaceFirst("ja", "Ja"));
		
		System.out.println(st1.indexOf("a"));
		System.out.println(st1.indexOf("a", st1.indexOf("a")+1));
		
		///////////////////////////////////////////////////
		System.out.println("--- substring() ---");
		String str = "java World";
		System.out.println("str : "+ str);
		System.out.println("str.substring(5) : "+ str.substring(5));
		System.out.println(str.substring(0, str.length()));		//beginIndex부터(포함)(0부터 시작)
		System.out.println(str.substring(0, str.length()-2));	//endIndex이전(미포함)까지
		
		System.out.println("--- toCharArray() ---");
		char[] ch = str.toCharArray();
		System.out.println(ch);
		
		System.out.println("--- toUpperCase(), toLowerCase() ---");
		System.out.println("str : "+ str);
		System.out.println("대문자로 toUpperCase() : "+ str.toUpperCase());
		System.out.println("소문자로 toLowerCase() : "+ str.toLowerCase());
		
		System.out.println("--- trim() ---");
		String str2 = "    ab c D    EFG     ";
		System.out.println("str2 : -"+ str2 +"-");
		System.out.println("trim() : -"+ str2.trim() +"-");
		
		System.out.println("--- valueOf() ---");
		int num = 100;
		str2 = String.valueOf(num);		//static 메소드 valueOf 사용
		System.out.println(num+1);
		System.out.println(String.valueOf(num)+1);
		
		////////////////////
		int num2 = Integer.parseInt("200");			//int <- String
		
	}
}
