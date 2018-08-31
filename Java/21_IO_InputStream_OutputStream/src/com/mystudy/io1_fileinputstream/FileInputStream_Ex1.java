package com.mystudy.io1_fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//바이트(byte) 단위 처리
//데이타 입력(읽기) : InputStream - 추상클래스
//FileInputStream : InputStream을 상속받아(extends) 만든 클래스
//파일(file)로 부터 데이타를 입력(읽어) 처리하기 위한 클래스
public class FileInputStream_Ex1 {

	public static void main(String[] args) {
		File file = new File("temp.txt");
		if (!file.exists()) { //파일이 존재하지 않으면(없으면)
			try {
				file.createNewFile();
			} catch (IOException e) {
				//e.printStackTrace();
				System.out.println("[예외발생]" + e.getMessage());
			}
		}
		
		//FileInputStream 객체 생성
		try {
			//전달받은 파일(file)을 이용해서 파일에 있는 데이타를 읽어서 처리
			//1. 사용할 객체 생성
			FileInputStream fis = new FileInputStream(file);
			
			//2. 객체 사용
			int readValue = fis.read();
			System.out.println("read() 값(int): " + readValue);
			System.out.println("read() char: " + (char)readValue);
			
			System.out.println("--- 전체 데이타 읽어오기 ----");
			while (true) {
				readValue = fis.read();
				//EOF(End of File)만나면 -1 리턴
				if (readValue == -1) break; 
				System.out.print("read() 값(int): " + readValue);
				System.out.println(" - char: " + (char)readValue);
			}
			
			//3. 객체 환원 : 사용자원 원위치(파일 close) 
			fis.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
