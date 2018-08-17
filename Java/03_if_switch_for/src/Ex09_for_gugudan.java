
public class Ex09_for_gugudan {

	public static void main(String[] args) {
		//화면에 구구단 2단
		/*
		2*1=2  -> 2*1=(2*1)
		2*2=4  -> 2*2=(2*2)
		2*3=6
		...
		2*9=18
		*/
		int num = 1;
		System.out.println("2*"+ num + "=" + (2*num));
		num++;
		System.out.println("2*"+ num + "=" + (2*num));
		num++;
		System.out.println("2*"+ num + "=" + (2*num));
		num++;
		
		System.out.println("-------------------");
		System.out.println("--2단--");
		for (int i=1; i<=9; i++) {
			System.out.println("2*"+ i + "=" + (2*i));
		}
		
		System.out.println("--3단--");
		for (int i=1; i<=9; i++) {
			System.out.println("3*"+ i + "=" + (3*i));
		}
		
		System.out.println("--4단--");
		for (int i=1; i<=9; i++) {
			System.out.println("4*"+ i + "=" + (4*i));
		}
		
		System.out.println("==== 2~9단 출력 =====");
		//1. 이중(중첩) for문을 사용해서 2~9단까지 출력
		for (int dan=2; dan<=9; dan++) {
			System.out.println("--"+ dan +"단--");
			for (int i=1; i<=9; i++) {
				System.out.println(dan +"*"+ i + "=" + (dan*i));
			}
			System.out.println();
		}
		
		//2. 시작단(startDan)과 끝나는 단(endDan)을 입력하면 구구단 출력하도록 보완
		int startDan = 11;
		int endDan = 19;
		
		for (int dan=startDan; dan<=endDan; dan++) {
			System.out.println("--"+ dan +"단--");
			for (int i=1; i<=9; i++) {
				System.out.println(dan +"*"+ i + "=" + (dan*i));
			}
			System.out.println();
		}
		
		System.out.println("===============");
		System.out.print("2*1=2");
		System.out.print("\t");
		System.out.print("3*1=3");
		
		System.out.println("===============");
		
	}

}
