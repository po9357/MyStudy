package com.mystudy.io3_filecopy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest {

	public static void main(String[] args) {
		//2가지 형태 파일복사 속도 비교
		//첫번째 : byte 단위 복사
		//두번째 : 버퍼기능 사용
		
		File file = new File("file/국화.jpg");
		
		FileInputStream fis = null; //byte단위 처리
		FileOutputStream fos = null;
		
		//버퍼사용을 위한 변수 선언
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			fis = new FileInputStream(file);
			fos = new FileOutputStream("file/국화_copy.jpg");
			
			//byte 단위 복사 작업
			long startTime = System.currentTimeMillis();
			int readValue;
			readValue = fis.read();
			while (readValue != -1) {
				fos.write(readValue);
				readValue = fis.read();
			}
			
			long endTime = System.currentTimeMillis();
			System.out.println("byte 복사시간: " 
			        + (endTime - startTime));
			fos.close();
			fis.close();
			
			//버퍼(buffer)단위 복사 작업
			bis = new BufferedInputStream(new FileInputStream(file), 1000);
			bos = new BufferedOutputStream(
					new FileOutputStream("file/국화_copy_bos.jpg"), 1000);
			
			startTime = System.currentTimeMillis();
			int readBis = bis.read();
			while (readBis != -1) {
				bos.write(readBis);
				readBis = bis.read();
			}
			bos.flush(); //버퍼에 남아있는 값 출력처리
			
			endTime = System.currentTimeMillis();
			System.out.println("버퍼사용 복사시간: " + (endTime - startTime));
			
			bos.close();
			bis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
