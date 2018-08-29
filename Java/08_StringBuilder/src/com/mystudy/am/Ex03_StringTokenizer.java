package com.mystudy.am;

import java.util.StringTokenizer;

public class Ex03_StringTokenizer {

	public static void main(String[] args) {
		//String.split() vs StringTokenizer
		System.out.println("--- String.split() ---");	//String.split은 빈 문자열을 무시하지 않는다
		String str = "사과,배,복숭아,,포도";
		System.out.println("str : "+ str);
		String[] strSplit = str.split(",");
		System.out.println("배열에 저장된 데이터 갯수 : "+strSplit.length);
		System.out.println("str.splt(\",\") 결과");
		System.out.println(strSplit[0]);
		
		//향상된 for문
		//for (데이터타입 변수명 : 집합객체) {}
		
//		for (int i=0; i<strSplit.length; i++) {			//기존에 쓰는 for문
//			System.out.print(strSplit[i] + " ");
//		}
//		System.out.println();
		
		for (String str2 : strSplit) {
			System.out.print(str2 +"-");
		}
		System.out.println();
		System.out.println("배열에 저장된 데이터 갯수 : "+strSplit.length);
		
		System.out.println("==============================");
		System.out.println("--- StringTokenizer 사용 ---");
		System.out.println("str : "+ str);
		StringTokenizer strToken = new StringTokenizer(str, ",");
		System.out.println("저장된 토큰 갯수 : "+ strToken.countTokens());
		while (strToken.hasMoreTokens()) {				//StringTokenizer는 빈 문자열 무시
			String token = strToken.nextToken();
			System.out.print(token+ "-");
		}
		System.out.println();
		
		System.out.println("저장된 토큰 갯수 : "+ strToken.countTokens());
		//저장된 토큰을 꺼내 썼지 때문에 토큰 갯수는 0
		//한 번 쓴 토큰이므로 다시 쓸 수 없다.
		
		//String.split의 경우는 배열에 저장되어 해당 배열을 불러내도 소모되지 않는다.
		
		//----------------------------------------------------------
		System.out.println("------------------------------");
		strToken = new StringTokenizer(str, ",");
		System.out.println("저장된 토큰 갯수 : "+ strToken.countTokens());
		int tokenCnt = strToken.countTokens();
		for (int i=0; i<tokenCnt; i++) {			//토큰을 꺼내 쓸때마다 소모되기때문에 
			String token = strToken.nextToken();	//i<strToken.countTokens();
			System.out.println((i+1) +" : "+ token);			//를 사용하면 i값이 늘어날때마다
		}											//strToken.countTokens()값은 줄어든다.
		System.out.println();
		
		int i=1;
		strToken = new StringTokenizer(str, ",");
		while (strToken.hasMoreTokens()) {
			String token = strToken.nextToken();
			System.out.println((i)+ " : "+ token);
			i++;
		}
		
		
	}
}
