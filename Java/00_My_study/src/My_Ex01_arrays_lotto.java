
public class My_Ex01_arrays_lotto {
	public static void main(String[] args) {
		int[] ball = new int[45];
		for (int i=0; i<45; i++) {
			ball[i] = i+1;
		}
		
		int j;
		int tmp;
		
		for (int i=0; i<6; i++) {
			j = (int)(Math.random()*45);
			tmp = ball[i];
			ball[i] = ball[j];
			ball[j] = tmp;
		}
		
		for (int i=0; i<6; i++) {
			System.out.print(ball[i] + " ");
		}
		
	}
}
