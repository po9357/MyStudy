import java.util.*;

public class My_Ex14_word_test {

	public static void main(String[] args) {
		String[][] words = {
							{"book", "å"},
							{"keyboard", "Ű����"},
							{"Lotto", "�ζ�"}
		};
		
		Scanner sc = new Scanner(System.in);
		
		for (int i=0; i<words.length; i++) {
			System.out.println("����"+(i+1)+ ") "+ words[i][0]+ "�� ����?");
			String input = sc.nextLine();
			
			if (input.equals(words[i][1])) {
				System.out.println("�����Դϴ�!");
			} else {
				System.out.println("Ʋ�Ƚ��ϴ�. ������ "+'\''+words[i][1]+'\''+"�Դϴ�.");
			}
		}
		
	}
}
