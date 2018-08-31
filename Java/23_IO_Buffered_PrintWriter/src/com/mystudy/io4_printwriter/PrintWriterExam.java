package com.mystudy.io4_printwriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterExam {

	public static void main(String[] args) {
		//File -> FileWriter -> BufferedWriter -> PrintWriter
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter(new File("file/pw_out.txt"));
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			//pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("file/pw_out.txt"))));
			
			pw.write("안녕하세요~~");
			pw.write("반갑습니다~~\n");
			pw.print("지금 자바공부중입니다.");
			pw.println("졸리고 피곤하당~~~");
			pw.println("빨리 집에 가고싶다.");
			
			pw.printf("%10s %10s %10s\n", "아직도", "2시간","남았다");
			pw.printf("%50s", "끝나면 주말이다~~~ !!!");
			
			System.out.printf("%10s %10s %10s\n", "아직도", "2시간","남았다");
			System.out.printf("%50s", "끝나면 주말이다~~~ !!!");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
		
	}

}
