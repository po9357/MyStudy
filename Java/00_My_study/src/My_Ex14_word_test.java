import java.util.*;

public class My_Ex14_word_test {

	public static void main(String[] args) {
		String[][] words = {
							{"book", "책"},
							{"keyboard", "키보드"},
							{"Lotto", "로또"}
		};
		
		Scanner sc = new Scanner(System.in);
		
		for (int i=0; i<words.length; i++) {
			System.out.println("문제"+(i+1)+ ") "+ words[i][0]+ "의 뜻은?");
			String input = sc.nextLine();
			
			if (input.equals(words[i][1])) {
				System.out.println("정답입니다!");
			} else {
				System.out.println("틀렸습니다. 정답은 "+'\''+words[i][1]+'\''+"입니다.");
			}
		}
		
	}
}
