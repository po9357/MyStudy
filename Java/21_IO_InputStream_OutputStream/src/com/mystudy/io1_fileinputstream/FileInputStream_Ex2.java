package com.mystudy.io1_fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStream_Ex2 {

	public static void main(String[] args) {
		File file = new File("file/test01.txt");
		
		FileInputStream fis = null;
		
		try {
			//1. »ç¿ëÇÒ °´Ã¼ »ý¼º
			fis = new FileInputStream(file);
			
			//2. °´Ã¼ »ç¿ë
			int readValue = -1;
			//fis.read() -> readValue != -1
			/*
			readValue = fis.read();
			while (readValue != -1) {
				System.out.print("int°ª: " + readValue);
				System.out.println(", char: " + (char)readValue);
				
				readValue = fis.read();
			}
			*/
			
			while ((readValue = fis.read()) != -1) {
				System.out.print("int°ª: " + readValue);
				System.out.println(", char: " + (char)readValue);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//3. °´Ã¼ close
			try {
				if (fis != null) fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
