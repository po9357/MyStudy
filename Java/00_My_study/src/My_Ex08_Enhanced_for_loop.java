import java.util.* ;

public class My_Ex08_Enhanced_for_loop {

	public static void main(String[] args) {
		
		//���� for��
		//1. �迭���� ���� for��
		//	for(�迭��Ÿ�� ������:�迭){}
		int[] arr = {10, 20, 30, 40, 50};
		
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
		System.out.println();
		for (int i:arr) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		
		//2. �÷���
		//�÷��� Ŭ������ list, map, ���� �޼ҵ带 �ҷ��� ���.
		//list�� ��� �����͸� ����. �ߺ� ���.
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
