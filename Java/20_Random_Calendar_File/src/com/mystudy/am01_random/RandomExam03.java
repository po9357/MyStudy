package com.mystudy.am01_random;

import java.util.Calendar;
import java.util.Random;

public class RandomExam03 {

	public static void main(String[] args) {
		//(�ǽ�) Calendar, Math.random(), Random ���
		//���� ��¥ ����� �������(0~100)
		//Calendar Ŭ���� �̿��ؼ� ���� ��¥ ���ϰ�,
		//Math.random(), Random Ŭ���� �̿��ؼ� ������� �� �����
        //������
		//2018�� 8�� 30�� ����� �������(0~100)�� 77 �Դϴ�.
		/////////////////////////////////////////
		
		//���� ��¥ ��(��, ��, ��) ���ϱ�
		Calendar now = Calendar.getInstance();
		System.out.println(now);
		//��, ��, �� ���ϱ�
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1; //(0 ~ 11) + 1
		int date = now.get(Calendar.DATE);
		
		System.out.println(year + "�� " + month + "�� " + date + "��");
		System.out.println("-----------------------------");
		
		//������� �� �����
		int result = 0;
		
		System.out.println("���� ���� ��������� ���ϱ��?");
		
		//���1 - Random nextInt(����)
		Random ran = new Random();
		result = ran.nextInt(101); //0 ~ 100 ������ ����
		System.out.print(year + "�� " + month + "�� " + date + "�� ");
		System.out.println("����� �������(0~100)�� " + result + " �Դϴ�.");
		
		
		//���2 - Math.random()
		result = (int)(Math.random() * 101);
		System.out.print(year + "�� " + month + "�� " + date + "�� ");
		System.out.println("����� �������(0~100)�� " + result + " �Դϴ�.");
		
		//-----------------
		//���3 - Random nextInt();
		int su = ran.nextInt();
		result = Math.abs(su) % 101;
		System.out.print(year + "�� " + month + "�� " + date + "�� ");
		System.out.println("����� �������(0~100)�� " + result + " �Դϴ�.");
		
		
		
	}

}
