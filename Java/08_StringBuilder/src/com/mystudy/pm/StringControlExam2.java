package com.mystudy.pm;

import java.util.Arrays;
import java.util.StringTokenizer;

public class StringControlExam2 {

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
		StringBuilder sb = new StringBuilder();
		//sb.append(str1).append(str2);
		sb = new StringBuilder(str1);
		sb.append(str2);
		System.out.println(sb);
		
		System.out.println("------------------------------");
		//2. sb의 문자열을 빈칸 (" ")을 구분자로 잘라서 (이름만 추출) 화면출력
		//		(String.split() 또는 StringTokenizer 사용)
		StringTokenizer stk = new StringTokenizer(sb.toString(), " ");
		
		//잘라낸 데이터를 배열에 저장
		
		int tokenCnt = stk.countTokens();
		String[] names = new String[tokenCnt];
		
		//names <- stk 값을 저장
		for (int i=0; i<tokenCnt; i++) {
			names[i] = stk.nextToken();
			System.out.println(stk.countTokens());
		}
		System.out.println(Arrays.toString(names));
		
		for (String name : names) {
			System.out.print(name +" ");
		}
		System.out.println();
		
		System.out.println("------------------------------");
		//3. 구분자 콤마(,)로 구분하여 한라인에 출력(StringBuilder 사용)
		//	(출력예: 홍길동,이순신,이순신,Tom,홍길동,TOM,을지문덕,김유신,연개소문)
		StringBuilder sbResult = new StringBuilder();
		
		System.out.println("----- 방법 1 -----");
		sbResult.setLength(0);
		sbResult.append(names[0]);
		for (int i=1; i<names.length; i++) {
			sbResult.append(",").append(names[i]);
			//마지막일때는 이름만 붙이기
		}
		System.out.println(sbResult.toString());
		
		System.out.println("----- 방법 2 -----");
		sbResult.setLength(0);
		boolean isFirst = true;
		for (int i=0; i<names.length; i++) {
			if (isFirst) {
				//첫번째 데이터에 대한 처리
				//isFirst = false;
				System.out.print(names[i]);
				isFirst = false;
			} else {
				System.out.print(","+ names[i]);
			}
		}
		System.out.println();
		
		System.out.println("----- 방법 3 -----");
		sbResult.setLength(0);
		for (int i=0; i<names.length; i++) {
			//마지막 데이터면
			if (i == names.length-1) {
				sbResult.append(names[i]);
			} else {
				sbResult.append(names[i]).append(",");
			}
		}
		System.out.println(sbResult);
		
		//--------------------------------------------------------
		//4. 데이터의 첫글자만 추출해서 콤마(,)로 구분하여 한라인에 출력(StringBuilder 사용)
		//		(예: 홍,이,이,T,홍,T,을,김,연)
		sbResult.setLength(0);
		isFirst = true;
		for (String name : names) {
			if (isFirst) {
				sbResult.append(name.charAt(0));
				isFirst = false;
			} else {
				sbResult.append(",").append(name.charAt(0));
			}
		}
		System.out.println(sbResult);
		
		//5. 배열의 문자열 중 이름의 글자수가 4 이상인 값을 "번호:이름" 출력
		//		출력예:
		//		6:을지문덕
		//		8:연개소문
		sbResult.setLength(0);
		int idx=0;
		for (String str : names) {
			if (str.length() >= 4) {
				System.out.println(idx+ " : "+ str);
			}
			idx++;
		}
		
		
	}
	
}
