package com.mystudy.io4_printwriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class PrintWriterExam2 {

	public static void main(String[] args) {
		//PrintWriter : byte 계열, 문자계열 모두 사용 가능
		FileOutputStream fos = null; //바이트 처리 방식 계열
		PrintWriter pw = null;
		
		try {
			fos = new FileOutputStream(new File("file/pw_out2.txt"));
			pw = new PrintWriter(fos);
			
			pw.write("안녕하세요~~");
			pw.write("반갑습니다~~\n");
			pw.print("지금 자바공부중입니다.");
			pw.println("졸리고 피곤하당~~~");
			pw.println("빨리 집에 가고싶다.");
			
			pw.printf("%10s %10s %10s\n", "아직도", "2시간","남았다");
			pw.printf("%50s", "끝나면 주말이다~~~ !!!");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}

	}

}
