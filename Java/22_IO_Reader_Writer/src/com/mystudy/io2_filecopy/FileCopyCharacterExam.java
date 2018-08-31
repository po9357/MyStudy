package com.mystudy.io2_filecopy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyCharacterExam {

	public static void main(String[] args) {
		//(�ǽ�) FileReader, FileWriter ����ؼ� ���� ����
		//�������� : file/test_char.txt
		//������� : file/test_char_copy.txt
		//ó�� : ���������� �о ������Ͽ� ����/����(���ڴ��� ó��)
		//////////////////////////////////////////
		
		//0. File ��ü ����(����, ���)
		File fileIn = new File("file/test_char.txt");
		File fileOut = new File("file/test_char_copy.txt");
		
		//1. FileReader, FileWriter Ÿ�� ���� ����
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			//2. FileReader, FileWriter ��ü����(���Ͽ���)
			//fr = new FileReader(new File("file/test_char.txt"));
			fr = new FileReader(fileIn);
			fw = new FileWriter(fileOut);
			
			//3. ���� �а� ����
			//3-1. FileReader �̿� ����Ÿ�� ���Ͽ��� �а�
			//3-2. FileWriter �̿� ����Ÿ�� ���Ͽ� ����
			int readValue = -1;

			readValue = fr.read(); //1.�а�
			while (readValue != -1) { //2. ���� ���� �ִ��� Ȯ�� 5,
				fw.write(readValue); //3.���� 6,
				readValue = fr.read(); //4.�а� 7
			}
			fw.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//4. close ó��
			try {
				fw.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		

	}

}
