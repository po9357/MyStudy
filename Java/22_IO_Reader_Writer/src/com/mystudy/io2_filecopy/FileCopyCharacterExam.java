package com.mystudy.io2_filecopy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyCharacterExam {

	public static void main(String[] args) {
		//(실습) FileReader, FileWriter 사용해서 파일 복사
		//원본파일 : file/test_char.txt
		//대상파일 : file/test_char_copy.txt
		//처리 : 원본파일을 읽어서 대상파일에 쓰기/저장(문자단위 처리)
		//////////////////////////////////////////
		
		//0. File 객체 생성(원본, 대상)
		File fileIn = new File("file/test_char.txt");
		File fileOut = new File("file/test_char_copy.txt");
		
		//1. FileReader, FileWriter 타입 변수 선언
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			//2. FileReader, FileWriter 객체생성(파일연결)
			//fr = new FileReader(new File("file/test_char.txt"));
			fr = new FileReader(fileIn);
			fw = new FileWriter(fileOut);
			
			//3. 파일 읽고 쓰기
			//3-1. FileReader 이용 데이타를 파일에서 읽고
			//3-2. FileWriter 이용 데이타를 파일에 쓰기
			int readValue = -1;

			readValue = fr.read(); //1.읽고
			while (readValue != -1) { //2. 읽은 값이 있는지 확인 5,
				fw.write(readValue); //3.쓰고 6,
				readValue = fr.read(); //4.읽고 7
			}
			fw.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//4. close 처리
			try {
				fw.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		

	}

}
