package com.mystudy.pm;

import java.util.Arrays;
import java.util.StringTokenizer;

public class StringControlExam {

	public static void main(String[] args) {
		/*
		0. 문자열 데이터
			String str1 = "홍길동 이순신  이순신 Tom 홍길동"
			String str2 = "     TOM    을지문덕 김유신 연개소문"
		1. 위의 문자열을 StringBuilder 변수 sb를 이용해서 하나의 문자열로 만들고,
		2. sb의 문자열을 빈칸 (" ")을 구분자로 잘라서 (이름만 추출) 화면출력
		       (String.split() 또는 StringTokenizer 사용)
		3. 구분자 콤마(,)로 구분하여 한라인에 출력(StringBuilder 사용)
			(출력예: 홍길동,이순신,이순신,Tom,홍길동,TOM,을지문덕,김유신,연개소문)
		4. 데이터의 첫글자만 추출해서 콤마(,)로 구분하여 한라인에 출력(StringBuilder 사용)
			(예: 홍,이,이,T,홍,T,을,김,연)
		5. 배열의 문자열 중 이름의 글자수가 4 이상인 값을 "번호:이름" 출력
			출력예:
			6:을지문덕
			8:연개소문
		 ***********************************************************/
		String str1 = "홍길동 이순신  이순신 Tom 홍길동";
		String str2 = "     TOM    을지문덕 김유신 연개소문";
		//"홍길동 이순신  이순신 Tom 홍길동    TOM     을지문덕 김유신 연개소문"

		//1. 위의 문자열을 StringBuilder 변수 sb를 이용해서 하나의 문자열로 만들고,
		System.out.println("--- 1번 문제 ---");
		StringBuilder sb = new StringBuilder();
		sb.append(str1).append(str2);
		System.out.println(sb.toString());
		
		//2. sb의 문자열을 빈칸 (" ")을 구분자로 잘라서 (이름만 추출) 화면출력
	    //   (String.split() 또는 StringTokenizer 사용)
		System.out.println("--- 2번 문제 ---");
		StringTokenizer st = new StringTokenizer(sb.toString(), " ");
		int tkNum =  st.countTokens();
		
		String[] str = new String[tkNum];
		for (int i=0; i<tkNum; i++) {
			str[i] = st.nextToken();
		}
		System.out.println(Arrays.toString(str));
		
		for (String strTmp : str) {
			System.out.print(strTmp+ " ");
		}
		System.out.println();
		//3. 구분자 콤마(,)로 구분하여 한라인에 출력(StringBuilder 사용)
		//(출력예: 홍길동,이순신,이순신,Tom,홍길동,TOM,을지문덕,김유신,연개소문)
		System.out.println("--- 3번 문제 ---");
		for (int i=0; i<tkNum; i++) {
			if (i==0) {
				System.out.print(str[i]);
			} else {
				System.out.print(", "+ str[i]);
			}
		}
		System.out.println();
		
		//4. 데이터의 첫글자만 추출해서 콤마(,)로 구분하여 한라인에 출력(StringBuilder 사용)
		//(예: 홍,이,이,T,홍,T,을,김,연)
		System.out.println("--- 4번 문제 ---");
		for (int i=0; i<tkNum; i++) {
			if (i==0) {
				System.out.print(str[i].charAt(0));
			} else {
				System.out.print(", "+ str[i].charAt(0));
			}
		}
		System.out.println();
		
		//5. 배열의 문자열 중 이름의 글자수가 4 이상인 값을 "번호:이름" 출력
		//출력예:
		//6:을지문덕
		//8:연개소문
		System.out.println("--- 5번 문제 ---");
		int num = 1;
		for (int i=0; i<tkNum; i++) {
			if (str[i].length() >= 4) {
				System.out.println(num+ " : "+ str[i]);
			}
			num++;
		}
		System.out.println();
		
		
	}
}
