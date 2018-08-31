package com.mystudy.io1_reader_writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExam {

	public static void main(String[] args) {
		//FileWriter : 파일에 문자단위 쓰기
		File file = new File("file/test_char_out.txt");
		
		//변수 선언
		FileWriter fw = null;
		
		try {
			//객체 생성
			fw = new FileWriter(file);
			
			fw.write('대'); //char -> int
			fw.write("한"); //String
			fw.write("민국"); //String
			fw.write("Hello Java!!!");
			
			//buffer가 채워지지 않아도 강제로 output 처리
			fw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
