package com.mystudy.io2_fileoutputstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_Ex1 {

	public static void main(String[] args) {
		//FileOutputStream : byte 단위로 파일에 저장(출력,쓰기)
		//- OutputStream 추상 클래스를 상속받아(extends) 만들어진 클래스
		
		//File에 쓰기 위해 FileOutputStream 타입 객체 저장을 위한 변수 선언
		FileOutputStream fos = null;
		File file = new File("file/test_out_01.txt");
		
		try {
			fos = new FileOutputStream(file); //파일의 기존 내용 삭제 후 작성
			//fos = new FileOutputStream(file, true); //두번째 인자: true 추가
			
			//파일이 없으면 File 객체의 파일명으로 파일 생성 후 write
			//append 값이 true이면 내용을 추가
			//append 값이 false이면 내용삭제 후 추가(기본값)
			
			//"Hello" 쓰기
			fos.write('H');
			fos.write('e');
			fos.write('l');
			fos.write('l');
			fos.write('o');
			
			//String.getBytes() : 문자열을 byte 배열로 만들어 리턴
			byte[] bytes = "Hello Java!!".getBytes();
			for (int i = 0; i < bytes.length; i++) {
				fos.write(bytes[i]);
			}
			
			//write(바이트배열) : 바이트 배열값을 파일에 출력(쓰기)
			fos.write(bytes);
			
			//write(byte[], 시작인덱스, 크기)
			fos.write(bytes, 6, 6);
			
			
		} catch (FileNotFoundException e) { //폴더(디렉토리)가 없는 경우 발생
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
