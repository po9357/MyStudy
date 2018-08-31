package com.mystudy.io2_fileoutputstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_Ex1 {

	public static void main(String[] args) {
		//FileOutputStream : byte ������ ���Ͽ� ����(���,����)
		//- OutputStream �߻� Ŭ������ ��ӹ޾�(extends) ������� Ŭ����
		
		//File�� ���� ���� FileOutputStream Ÿ�� ��ü ������ ���� ���� ����
		FileOutputStream fos = null;
		File file = new File("file/test_out_01.txt");
		
		try {
			fos = new FileOutputStream(file); //������ ���� ���� ���� �� �ۼ�
			//fos = new FileOutputStream(file, true); //�ι�° ����: true �߰�
			
			//������ ������ File ��ü�� ���ϸ����� ���� ���� �� write
			//append ���� true�̸� ������ �߰�
			//append ���� false�̸� ������� �� �߰�(�⺻��)
			
			//"Hello" ����
			fos.write('H');
			fos.write('e');
			fos.write('l');
			fos.write('l');
			fos.write('o');
			
			//String.getBytes() : ���ڿ��� byte �迭�� ����� ����
			byte[] bytes = "Hello Java!!".getBytes();
			for (int i = 0; i < bytes.length; i++) {
				fos.write(bytes[i]);
			}
			
			//write(����Ʈ�迭) : ����Ʈ �迭���� ���Ͽ� ���(����)
			fos.write(bytes);
			
			//write(byte[], �����ε���, ũ��)
			fos.write(bytes, 6, 6);
			
			
		} catch (FileNotFoundException e) { //����(���丮)�� ���� ��� �߻�
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
