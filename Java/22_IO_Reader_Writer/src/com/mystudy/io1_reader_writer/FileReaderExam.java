package com.mystudy.io1_reader_writer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExam {

	public static void main(String[] args) {
		//문자(Character) 단위 입력 처리
		//FileReader : 파일로 부터 문자단위로 데이타 읽기
		//문자 단위 : 1,A,$ - 1byte, 대,깥 - 2byte(한글,중국어..)
		
		//FileReader 로 읽어 들일 대상 파일 지정
		File file = new File("file/test_char.txt");
		
		//FileReader 타입 변수 선언
		FileReader fr = null;
		
		try {
			fr = new FileReader(file);
			
			//FileReader : 문자단위 읽기
			int readChar = fr.read();
			System.out.println("첫번째 문자: " + readChar
					+ ", char: " + (char)readChar);
			
			//FileInputStream : 바이트 단위 읽기
			FileInputStream fis = new FileInputStream(file);
			int readByte = fis.read();
			System.out.println("첫번째 byte: " + readByte
					+ ", char: " + (char)readByte);
			
			fis.close();
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
