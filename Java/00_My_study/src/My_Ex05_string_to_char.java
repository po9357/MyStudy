
public class My_Ex05_string_to_char {
	
	public static void main(String[] args) {
		String src = "ABCDE";
		
		for (int i=0; i<src.length(); i++) {
			char ch = src.charAt(i);	//src�� i��° ���ڸ� ch�� ����
			System.out.println("src.charAt("+i+"):"+ch);
		}
		//char�� String[]�� ��ȯ
		char[] chArr = src.toCharArray();
		
		//String �迭(char[])�� ���
		System.out.println(chArr);
		
	}
}
