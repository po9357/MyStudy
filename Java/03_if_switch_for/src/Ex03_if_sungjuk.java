
public class Ex03_if_sungjuk {

	public static void main(String[] args) {
		//성적처리
		//국어(kor), 영어(eng), 수학(math) 점수
		//총점(tot) = 국어 + 영어 + 수학
		//평균(avg) = 총점 / 3
		//--------------------
		//평균점수 구간에 따라 학점 부여
		//90 ~ 100 : A
		//80 ~ 89 : B
		//70 ~ 79 : C
		//60 ~ 69 : D
		//60 미만(0~59) : F + 메시지(재수강하세요)
		///////////////////////////////////
		/* 출력 형태
		국어 : 100
		영어 : 90
		수학 : 80
		----------
		성적합계 : 270
		평균점수 : 90
		<평가결과>
		A 학점
		***********************/
		int kor = 150;
		int eng = 90;
		int math = 50;
		int tot = 0; //합계(총점)
		int avg = 0; //평균
		
		//총점 구하기(출력)
		tot = kor + eng + math;
		System.out.println("성적합계 : " + tot);
		
		//평균 구하기(출력)
		avg = tot / 3;
		System.out.println("평균점수 : " + avg);
		
		System.out.println("<평가결과>");
		String hakjum = "Z";
		//평균 점수에 따른 학점 출력
		if (avg >= 90) {
			System.out.println("A 학점");
			hakjum = "A";
		//} else if (avg >= 80 && avg < 90) {
		} else if (avg >= 80) {
			System.out.println("B 학점");
			hakjum = "B";
		} else if (avg >= 70) {
			System.out.println("C 학점");
			hakjum = "C";
		} else if (avg >= 60) {
			System.out.println("D 학점");
			hakjum = "D";
		} else {
			System.out.println("F 학점 - 재수강하세요");
			hakjum = "F";
		}
		
		System.out.println("=====================");
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + math);
		System.out.println("----------");
		
		System.out.println("성적합계 : " + tot);
		System.out.println("평균점수 : " + avg);
		System.out.println("<평가결과>");
		if (hakjum == "F") {
			System.out.println(hakjum + " 학점(재수강하세요)");
		} else {
			System.out.println(hakjum + " 학점");
		}
	}

}
