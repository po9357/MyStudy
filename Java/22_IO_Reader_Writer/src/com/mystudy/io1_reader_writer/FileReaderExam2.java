package com.mystudy.io1_reader_writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExam2 {
	public static void main(String[] args) {
		//읽을파일 : file/test_char.txt
		//처리 : 파일의 전체 내용을 읽어서 화면에 출력
		
		File file = new File("file/test_char.txt");
		FileReader fr = null;
		
		try {
			fr = new FileReader(file);
			
			int intChar = -1; //로컬변수는 자동 초기화 되지 않음
			//전체 데이타 읽고, 화면출력
			while ((intChar = fr.read()) != -1) {
				System.out.print((char) intChar);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
