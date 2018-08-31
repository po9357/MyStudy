package com.mystudy.io_isr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderExam {

	public static void main(String[] args) {
		//byte 처리 계열 -> 문자처리 계열로 변환
		//InputStreamReader : InputStream -> Reader
		//OutputStreamWriter : OutputStream -> Writer
		
		FileInputStream fis = null;
		//FileOutputStream fos = null;
		
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		File file = new File("file/test_char.txt");
		
		try {
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis);
			
//			int readByte = fis.read();
//			System.out.println((char) readByte);
//			
//			readByte = fis.read();
//			System.out.println((char) readByte);
			
			int input = isr.read();
			System.out.println((char) input);
			
			input = isr.read();
			System.out.println((char) input);
			
			//버퍼기능 사용해서 읽기
			br = new BufferedReader(isr); //버퍼기능 + 문자로처리 + 파일에서 읽기
			String str = br.readLine();
			System.out.println(str);
			
			while (true) {
				str = br.readLine(); //EOF(파일끝)를 만나서 더 읽을 값이 없으면 null 리턴
				if (str == null) break;
				System.out.println(str);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

	}

}
