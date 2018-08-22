package com.mystudy.wordscramble;

import java.util.Scanner;
/*
Question :HEOP
Your answer is :phoe
phoe은/는 정답이 아닙니다. 다시 시도해보세요.
Question :HEOP
Your answer is :hope
정답입니다.
*/
public class WordScrambleEx2 {
	public static void main(String[] args) { 
        String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW"}; 


        String ans;
        Outter :
        while (true) {
        	String answer = getAnswer(strArr); 
        	String question = getScrambledWord(answer); 
	        while(true) { 
	              System.out.println("Question :" + question); 
	              System.out.print("Your answer is :"); 
	              Scanner sc = new Scanner(System.in);
	              ans = sc.nextLine();
	              if (ans.equalsIgnoreCase("q")) {
	            	  System.exit(0);
	              } else if (ans.equalsIgnoreCase(answer)) {
	            	  System.out.println("정답입니다");
	            	  break;
	              } else {
	            	  System.out.println(ans+"은/는 정답이 아닙니다. 다시 시도해보세요.");
	              }
	              
	              
	        } // while 
        }

	} // main 

	  public static String getAnswer(String[] strArr) { 
	        int idx = (int)(Math.random()*strArr.length); 
	        return strArr[idx]; 
	  } 
	  
	  public static String getScrambledWord(String str) { 
	        char[] chArr = str.toCharArray(); 
	
	        for(int i=0;i<str.length();i++) {
	               int idx = (int)(Math.random()*str.length()); 
	              
	              char tmp = chArr[i]; 
	              chArr[i] = chArr[idx]; 
	              chArr[idx] = tmp; 
	        } 
	
	        return new String(chArr); 
	  } // scramble(String str) 


}
