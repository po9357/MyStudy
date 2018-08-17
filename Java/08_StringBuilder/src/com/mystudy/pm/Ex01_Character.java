package com.mystudy.pm;

public class Ex01_Character {

	public static void main(String[] args) {
		//Wrapper class : Character
		char chr = 'a';
		System.out.println(Character.isAlphabetic(chr));		//true
		System.out.println("Character.isAlphabetic('��') : "		//true
				+ Character.isAlphabetic(chr));					
		System.out.println(Character.isAlphabetic('0'));		//false
		System.out.println(Character.isLetter('0'));			//false
		System.out.println(Character.isLetter('A'));			//true
		System.out.println(Character.isUpperCase('A'));			//true
		System.out.println(Character.isLowerCase('a'));			//true
		System.out.println(Character.isWhitespace(' '));		//true
		System.out.println(Character.isWhitespace('A'));		//false
		System.out.println(Character.isDigit('0'));				//true
		
		//------------------------------------------------------------------
		char[] chs = {'��', 'a', ' ', 'A', '+', '0'};
		for (int i=0; i<chs.length; i++) {
			System.out.println(chs[i] + " : ");
			if (Character.isDigit(chs[i])) {
				System.out.println(" ����");
			}
			if (Character.isWhitespace(chs[i])) {
				System.out.println(" ����");
			}
			if (Character.isUpperCase(chs[i])) {
				System.out.println(" ��");
			}
			if (Character.isLowerCase(chs[i])) {
				System.out.println(" ��");
			}
			if (Character.isLetter(chs[i])) {
				System.out.println(" ����");
			}
			if (Character.isDefined(chs[i])) {
				System.out.println(" �����ڵ��Դϴ�");
			}
			System.out.println();
		}
	}

}
