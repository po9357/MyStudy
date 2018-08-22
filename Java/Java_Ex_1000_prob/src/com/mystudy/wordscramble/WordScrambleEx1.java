package com.mystudy.wordscramble;

public class WordScrambleEx1 {
	
/*
getAnswer(String[] strArr)�� �迭strArr�� ������� �ϳ��� ���Ƿ� ��� ��ȯ�Ѵ�.(Math.random()���)
getScrambledWord(String str)�� �־��� ���ڿ� str�� �� ������ ������ �ڼ��� ����, ���ο� ���ڿ��� ��ȯ�Ѵ�.
 */
	public static void main(String[] args) { 
        String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW"}; 

        String answer = getAnswer(strArr); 
        String question = getScrambledWord(answer); 

        System.out.println("Question:"+question); 
        System.out.println("Answer:"+answer); 
	} // main 

	public static String getAnswer(String[] strArr) { 
       // ������ �ϼ��ϼ���.
		int ran = (int)(Math.random()*strArr.length);
		return strArr[ran];
	} 
  
	public static String getScrambledWord(String str) { 
        // ������ �ϼ��ϼ���.
		char[] charArr = str.toCharArray();
		int ran = (int)(Math.random()*charArr.length);
		char tmp;
		for (int i=0; i<charArr.length; i++) {
			tmp = charArr[i];
			charArr[i] = charArr[ran];
			charArr[ran] = tmp;
		}
		str = String.valueOf(charArr);
		new String(charArr);
		return str;
	} // scramble(String str) 

}
