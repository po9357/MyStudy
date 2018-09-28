package com.mystudy.io4_printwriter;

import java.util.Calendar;

public class Printf_Exam {

	public static void main(String[] args) {
		int a = 20;
		long b = 300000000L;
		float c = 34.95f;
		double d = 234.234;
		char e = 'A';
		String f = "Hello~~";
		boolean g = false;
		
		Calendar today = Calendar.getInstance();
		System.out.println(today);
		System.out.printf("%tF\n", today);
		
		System.out.printf(">> "+ a +" "+ b +" "
				+ c +" "+ d +" "+ e +" "+ f +" "+ g);
		System.out.println();

		/* [] ���������׸�
		%[�ε���]$[+|-][ũ��]���Ĺ��� : %, ���Ĺ��� �ʼ�
		- �⺻�� ��������
		- �������� �� : %-10d 
		*/
		System.out.printf("\\ %% %n \n");
		System.out.printf("%d %d %f %f %c %s %b %n", a,b, c,d, e, f, g);
		
		//[�ε���]$ ��뿹 -------------------
		System.out.printf("%d %d %c %s \n", 65, 65, 'A', "Hello Java");
		//���İ� ����� 1:1�� �ƴѰ�� ��� ����
		//($�� �̿��� ��Ī ����� ������ ���� ��������Ÿ ��Ī���� ���ܵ�)
		System.out.printf("%1$d %1$d %c %s \n", 100, 'A', "Hello Java");
		
		//���İ� ����� 1:1�� �ƴѰ�� ���������� ������ġ ����
		System.out.printf("%1$d %1$d %2$c %1$d %3$s \n", 100, 'A', "Hello Java");
		
		System.out.println("--- �Ǽ��� ����Ÿ ��� ----");
		System.out.printf("%f %1$a %1$e %1$f %1$g \n", 65.841243234234);
		
		System.out.println("--- ��¥ ���� ----");
		System.out.printf("%1$tY %1$tm %1$td %1$tF %1$tB %1$th \n", today);
		System.out.printf("%1$ty %1$tm %1$te \n", today);
		System.out.printf("%1$tI %1$tM %1$tS %1$ta \n", today);
		
		//������
		System.out.println("--- ��(width) ���� ----");
		System.out.printf("%1$20f \n", 5678.1234567891); //�⺻ ��������
		System.out.printf("%1$-20f \n", 5678.1234567891); //- : ��������
		System.out.printf("%1$-20.10f \n", 5678.1234567891); //- : ��������
		
		System.out.println("---------------------");
		System.out.printf("%10s %10d %10d %10d \n", "ȫ�浿", 100, 90, 80);
		System.out.printf("%10s %10d %10d %10d \n", "��������", 100, 90, 80);
	}

}





















