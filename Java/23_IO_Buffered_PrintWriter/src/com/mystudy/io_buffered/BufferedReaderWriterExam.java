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
		//����(buffer) ����� �����Ǿ� �ִ� Ŭ����
		//BufferedReader, BufferedWriter
		
		
		FileReader fr = null; //���Ϸ� ���� �б� ���� Ŭ����
		FileWriter fw = null; //���Ͽ� �����
		
		BufferedReader befferedReader = null; //���۱�� ����ؼ� �б�
		BufferedWriter befferedWriter = null; //���۱�� ����ؼ� ����
		
		try {
			File inFile = new File("file/test_buf_rw_in.txt");
			fr = new FileReader(inFile); //���� �б� ��ü ����
			
			File outFile = new File("file/test_buf_rw_out.txt");
			fw = new FileWriter(outFile); //���� ���� ��ü ����
			
			//���۱�� ��� ��ü ����
			befferedReader = new BufferedReader(fr); //���ۻ��+�����б� ���
			befferedWriter = new BufferedWriter(fw); //���ۻ��+���Ͼ��� ���
			
			//������ ����
			befferedWriter.write("�ȳ��ϼ���. �ڹٰ������Դϴ�.");
			befferedWriter.newLine();
			befferedWriter.newLine();
			befferedWriter.write("Hello Java!!!\n");
			befferedWriter.write("����ֳ���?");
			befferedWriter.write("--------------------------");
			befferedWriter.newLine();
			
			befferedWriter.flush();
			
			//���Ϸ� ���� �а�
			String str = befferedReader.readLine();
			System.out.println(str);
			//���Ͽ� ����
			befferedWriter.write(str);
			
			//���� �� ���۱���̿�(���δ��� �б� ó��)
			str = befferedReader.readLine();
			System.out.println(str);
			befferedWriter.write(str);
			befferedWriter.newLine();
			
			//���� ����Ÿ ��� �а�, ����
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
