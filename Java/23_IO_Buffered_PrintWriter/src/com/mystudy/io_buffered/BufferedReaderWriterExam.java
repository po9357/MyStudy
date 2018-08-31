package com.mystudy.io_buffered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderWriterExam {

	public static void main(String[] args) {
		//버퍼(buffer) 기능이 구현되어 있는 클래스
		//BufferedReader, BufferedWriter
		
		
		FileReader fr = null; //파일로 부터 읽기 위한 클래스
		FileWriter fw = null; //파일에 쓰기용
		
		BufferedReader befferedReader = null; //버퍼기능 사용해서 읽기
		BufferedWriter befferedWriter = null; //버퍼기능 사용해서 쓰기
		
		try {
			File inFile = new File("file/test_buf_rw_in.txt");
			fr = new FileReader(inFile); //파일 읽기 객체 생성
			
			File outFile = new File("file/test_buf_rw_out.txt");
			fw = new FileWriter(outFile); //파일 쓰기 객체 생성
			
			//버퍼기능 사용 객체 생성
			befferedReader = new BufferedReader(fr); //버퍼사용+파일읽기 기능
			befferedWriter = new BufferedWriter(fw); //버퍼사용+파일쓰기 기능
			
			//간단히 쓰기
			befferedWriter.write("안녕하세요. 자바공부중입니다.");
			befferedWriter.newLine();
			befferedWriter.newLine();
			befferedWriter.write("Hello Java!!!\n");
			befferedWriter.write("재미있나요?");
			befferedWriter.write("--------------------------");
			befferedWriter.newLine();
			
			befferedWriter.flush();
			
			//파일로 부터 읽고
			String str = befferedReader.readLine();
			System.out.println(str);
			//파일에 쓰기
			befferedWriter.write(str);
			
			//읽을 때 버퍼기능이용(라인단위 읽기 처리)
			str = befferedReader.readLine();
			System.out.println(str);
			befferedWriter.write(str);
			befferedWriter.newLine();
			
			//남은 데이타 모두 읽고, 쓰기
			str = befferedReader.readLine();
			while (str != null) {
				befferedWriter.write(str);
				befferedWriter.newLine();
				str = befferedReader.readLine();
			}
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				befferedWriter.close();
				befferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	}

}
