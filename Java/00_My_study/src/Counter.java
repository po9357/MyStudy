import java.util.ArrayList;

public class Counter  {
	    static int count = 0; //���� �տ� static�� �پ��⿡ �Ʒ� �޼ҵ忡�� c1,c2��ü ������ ������ ���� ���´�.
	    Counter() {
	        this.count++;
	        System.out.println(this.count);
	    }
	

	    public static void main(String[] args) {
	        Counter c1 = new Counter();
	        Counter c2 = new Counter();
	        
	        
	        
	        
	        List2<List> list = new List2<>();
	        list.add(list);
	        
	    }
	    
	    
	    
	    
	}

	
	class List<T> {
		ArrayList<T> list = new ArrayList<T>();
		void add(T item) { list.add(item); }
		void add() {};
	}
	
	class List2<T extends List> extends List {
	}
	
	class test extends List2 {
		List2<List> list2 = new List2<List>();
		
		
		
	}