
public class My_Ex16_Callstack_method {

	public static void main(String[] args) {
		System.out.println("main(String[] args) 시작");
		firstMethod();
		System.out.println("main(String[] args) 종료");
	}
	
	static void firstMethod() {
		System.out.println("firstMethod() 시작");
		secondMethod();
		System.out.println("firstMethod() 종료");
	}
	
	static void secondMethod() {
		System.out.println("secondMethod() 시작");
		System.out.println("secondMethod() 종료");
	}
	

}
