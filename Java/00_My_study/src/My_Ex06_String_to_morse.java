
public class My_Ex06_String_to_morse {

	public static void main(String[] args) {
		
		String source = "SOSHELP";
		String[] morse = {".-", "-...", "-.-.", "-..", ".",
						  "..-.", "--.", "....", "..", ".---",
						  "-.-", ".-..", "--", "-.", "---",
						  ".--.", "--.-", ".-.", "...", "-",
						  "..-", "...-", ".--", "-..-", "-.--",
						  "--.."};
		System.out.println(morse.length);
		String result="";
		
		for (int i=0; i<source.length(); i++) {
			result+=morse[source.charAt(i)-'A'];
		}
		System.out.println("source: " + source);
		System.out.println("morse: " + result);
		
	}
}
