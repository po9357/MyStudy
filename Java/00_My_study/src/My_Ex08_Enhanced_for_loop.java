import java.util.* ;

public class My_Ex08_Enhanced_for_loop {

	public static void main(String[] args) {
		
		//향상된 for문
		//1. 배열에서 향상된 for문
		//	for(배열의타입 변수명:배열){}
		int[] arr = {10, 20, 30, 40, 50};
		
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
		System.out.println();
		for (int i:arr) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		
		//2. 컬렉션
		//컬렉션 클래스의 list, map, 등의 메소드를 불러와 사용.
		//list의 경우 데이터를 저장. 중복 허용.
		ArrayList<Integer>list = new ArrayList<Integer>();
		list.add(new Integer(10));
		list.add(new Integer(20));
		list.add(new Integer(30));
		
		Iterator<Integer> it = list.iterator();
		
		for (;it.hasNext();) {
			System.out.print(it.next()+" ");
		}
	}
}
