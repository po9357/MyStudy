package com.mystudy.pm01_generic;

class Box {
	private Object obj;
	Object getObj() {
		return obj;
	}
	void setObj(Object obj) {
		this.obj = obj;
	}
}

//제네릭 적용 박스
class BoxG<T> {
	private T obj;
	T getObj() {
		return obj;
	}
	void setObj(T obj) {
		this.obj = obj;
	}
}
public class GenericExam {
	
	public static void main(String[] args) {
		//제네릭(Generic) : 컬렉션이 어떤 객체들로 이루어졌는지 표시하는 객체타입을 의미
		//제네릭 형태 : <객체자료>, <>
		//API -> <T> : 객체자료형, <E> : 하나의 요소(즉, 객체하나)
		//		Map형식 : <K, V> K는 Key, V는 value
		///////////////////////////////////////////////
		//Set<E>, List<E>, Queue<E>, Map<K, V>
		
		Box box = new Box();
		box.setObj(100);
		box.setObj("문자열String");
		String str = (String) box.getObj();
		System.out.println(str.substring(0, 3));
		
		box.setObj(new Box());
		
		//--------------------------------------
		String str1 = "Hello Java!!";
		String str2 = "10000";
		int str3 = 3333;
		System.out.println("---- 제네릭 적용 ----");
		BoxG<String> boxg = new BoxG<String>();
		boxg.setObj("문자열String");
		boxg.setObj(str1);
		boxg.setObj(str2);
//		boxg.setObj(str3);		//컴파일 단계에서 타입체크로 확인 가능
		
		System.out.println(boxg.getObj());
		
		//----------------------------------------
		BoxG<Integer> boxg2 = new BoxG<>();		//<> 다이아몬드 연산자 처리 가능
		boxg2.setObj(99999);
		//boxg2.setObj("문자열은 안됨");
		System.out.println(boxg2.getObj());
		
		
		
		
		
	}
	
}
