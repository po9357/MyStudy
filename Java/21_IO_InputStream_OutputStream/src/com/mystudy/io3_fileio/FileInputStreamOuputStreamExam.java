package com.mystudy.io3_fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamOuputStreamExam {

	public static void main(String[] args) {
		//���Ͽ��� �о ���ο� ���Ͽ� ����
		//FileInputStream + FileOutputStream
		
		//��������(�������� - read)
		File fileIn = new File("file/test01.txt");
		
		//Ÿ������(���� ������� - write)
		File fileOut = new File("file/test01_out.txt");

		//FileInputStream ��������(�б��)
		FileInputStream fis = null;
		//FileOuputStream ��������(�����)
		FileOutputStream fos = null;
		
		try {
			//��ü����
			fis = new FileInputStream(fileIn);
			fos = new FileOutputStream(fileOut);
			
			//�б�
			int readValue = -1;
			while (true) {
				readValue = fis.read();
				//���Ͽ� ������ ���̻� ���� ��� �ݺ� ����
				if (readValue == -1) break;
				
				//���� ���� ������ ����
				fos.write(readValue);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}







