package com.mystudy.string;

public class Ex02_String2 {
	
	public static void main(String[] args) {
		//String �޼ҵ��
		String st1 = "Java";
		System.out.println(st1);
		System.out.println(st1.toString());
		
		System.out.println("--- indexOf() ---");	//���ڿ��� ��ġ�� ã�� �޼ҵ�
		System.out.println(st1.indexOf("J"));		//������ -1, 0 ���� �ش� ���ڰ� ������� int������ �˷���.
													//			(�迭 ��ȣ�� �����ϸ� ����)
		System.out.println("--- isEmpty ---");
		System.out.println(st1.isEmpty());			//st1 = "";��� true�� ��ȯ
		
		System.out.println("--- replace() ---");
		System.out.println("st1 : "+ st1);
		System.out.println(st1.replace('a', 'B'));	//���� �����ʹ� ������ ����.
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
		System.out.println(str.substring(0, str.length()));		//beginIndex����(����)(0���� ����)
		System.out.println(str.substring(0, str.length()-2));	//endIndex����(������)����
		
		System.out.println("--- toCharArray() ---");
		char[] ch = str.toCharArray();
		System.out.println(ch);
		
		System.out.println("--- toUpperCase(), toLowerCase() ---");
		System.out.println("str : "+ str);
		System.out.println("�빮�ڷ� toUpperCase() : "+ str.toUpperCase());
		System.out.println("�ҹ��ڷ� toLowerCase() : "+ str.toLowerCase());
		
		System.out.println("--- trim() ---");
		String str2 = "    ab c D    EFG     ";
		System.out.println("str2 : -"+ str2 +"-");
		System.out.println("trim() : -"+ str2.trim() +"-");
		
		System.out.println("--- valueOf() ---");
		int num = 100;
		str2 = String.valueOf(num);		//static �޼ҵ� valueOf ���
		System.out.println(num+1);
		System.out.println(String.valueOf(num)+1);
		
		////////////////////
		int num2 = Integer.parseInt("200");			//int <- String
		
	}
}
