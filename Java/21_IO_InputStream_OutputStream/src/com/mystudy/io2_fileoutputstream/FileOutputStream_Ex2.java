package com.mystudy.io2_fileoutputstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_Ex2 {

	public static void main(String[] args) {
		//FileOutputStream : byte ������ ���Ͽ� ����(���,����)
		//- OutputStream �߻� Ŭ������ ��ӹ޾�(extends) ������� Ŭ����
		
		//File�� ���� ���� FileOutputStream Ÿ�� ��ü ������ ���� ���� ����
		FileOutputStream fos = null;
		File file = new File("file/test_out_01.txt");
		
		try {
			//fos = new FileOutputStream(file); //������ ���� ���� ���� �� �ۼ�
			fos = new FileOutputStream(file, true); //�ι�° ����: true �߰�
			
			//������ ������ File ��ü�� ���ϸ����� ���� ���� �� write
			//append ���� true�̸� ������ �߰�
			//append ���� false�̸� ������� �� �߰�(�⺻��)
			fos.write('A');
			
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
