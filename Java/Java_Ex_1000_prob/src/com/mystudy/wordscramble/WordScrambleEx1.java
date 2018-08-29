package com.mystudy.wordscramble;

public class WordScrambleEx1 {
	
/*
getAnswer(String[] strArr)는 배열strArr의 요소중의 하나를 임의로 골라서 반환한다.(Math.random()사용)
getScrambledWord(String str)는 주어진 문자열 str의 각 문자의 순서를 뒤섞은 다음, 새로운 문자열로 반환한다.
 */
	public static void main(String[] args) { 
        String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW"}; 

        String answer = getAnswer(strArr); 
        String question = getScrambledWord(answer); 

        System.out.println("Question:"+question); 
        System.out.println("Answer:"+answer); 
	} // main 

	public static String getAnswer(String[] strArr) { 
       // 내용을 완성하세요.
		int ran = (int)(Math.random()*strArr.length);
		return strArr[ran];
	} 
  
	public static String getScrambledWord(String str) { 
        // 내용을 완성하세요.
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
