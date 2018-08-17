
public class Ex04_switch {

	public static void main(String[] args) {
		//switch case문
		/*
		switch (조건값) {
		case 비교값 :
			실행할 문장;
			break;
		case 비교값 :
			실행할 문장;
			break;
		...
		default :
			실행할 문장;
			break;
		}
		*/
		int month = 8; //월
		String result = "";
		
		switch (month) {
		case 1:
			System.out.println("31일까지  있습니다");
			break;
		case 2:
			System.out.println("28 또는 29일까지 있습니다");
			break;
		case 3:
			System.out.println("31일까지  있습니다");
			break;
		case 4:
			System.out.println("30일까지  있습니다");
			break;
		}
		System.out.println("--------------------");
		switch (month) {
		case 1: 
		case 3:
		case 5:
		case 7: case 8: case 10: case 12:
			System.out.println(month + "월은 31일까지  있습니다");
			break;
		case 2:
			System.out.println(month + "월은 28 또는 29일까지 있습니다");
			break;
		
		case 4: case 6: case 9: case 11:
			System.out.println(month + "월은 30일까지  있습니다");
			break;
		}

		//-----------------------------------------
		//추첨 결과에 따라서 상품 지급
		//1등: 냉장고, 2등: 김치냉장고, 3등: 세탁기, 4등: 청소기
		result = "4등";
		switch (result) {
		case "1등" :
			System.out.println("냉장고");
			break;
		case "2등" :
			System.out.println("김치냉장고");
			break;
		case "3등" :
			System.out.println("세탁기");
			break;
		case "4등" :
			System.out.println("청소기");
			//4등은 휴지도 지급하기로 함
		default :
			System.out.println("휴지");
			//break;
		}
		
		
		
		
		
	}

}





