
public class Ex09_for_gugudan {

	public static void main(String[] args) {
		//ȭ�鿡 ������ 2��
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
		System.out.println("--2��--");
		for (int i=1; i<=9; i++) {
			System.out.println("2*"+ i + "=" + (2*i));
		}
		
		System.out.println("--3��--");
		for (int i=1; i<=9; i++) {
			System.out.println("3*"+ i + "=" + (3*i));
		}
		
		System.out.println("--4��--");
		for (int i=1; i<=9; i++) {
			System.out.println("4*"+ i + "=" + (4*i));
		}
		
		System.out.println("==== 2~9�� ��� =====");
		//1. ����(��ø) for���� ����ؼ� 2~9�ܱ��� ���
		for (int dan=2; dan<=9; dan++) {
			System.out.println("--"+ dan +"��--");
			for (int i=1; i<=9; i++) {
				System.out.println(dan +"*"+ i + "=" + (dan*i));
			}
			System.out.println();
		}
		
		//2. ���۴�(startDan)�� ������ ��(endDan)�� �Է��ϸ� ������ ����ϵ��� ����
		int startDan = 11;
		int endDan = 19;
		
		for (int dan=startDan; dan<=endDan; dan++) {
			System.out.println("--"+ dan +"��--");
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
